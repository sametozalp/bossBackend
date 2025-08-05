package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.*;
import com.boss.bossBackend.business.dtos.requests.CreateAppointmentRequest;
import com.boss.bossBackend.business.dtos.responses.AppointmentResponse;
import com.boss.bossBackend.business.dtos.responses.GetListingResponse;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.UserDetailResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.common.utilities.results.SuccessDataResult;
import com.boss.bossBackend.dataAccess.abstracts.AppointmentRepository;
import com.boss.bossBackend.entities.concretes.*;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import com.boss.bossBackend.entities.enums.DeskAvailableEnum;
import com.boss.bossBackend.entities.enums.MeetingTypeEnum;
import com.boss.bossBackend.exception.appointmentException.AppointmentNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentManager implements AppointmentService {

    private final AppointmentRepository repository;
    private final UserService userService;
    private final TechnoparkUserService technoparkUserService;
    private final DeskService deskService;
    private final ListingService listingService;

    public AppointmentManager(AppointmentRepository repository, UserService userService, TechnoparkUserService technoparkUserService, DeskService deskService, ListingService listingService) {
        this.repository = repository;
        this.userService = userService;
        this.technoparkUserService = technoparkUserService;
        this.deskService = deskService;
        this.listingService = listingService;
    }

    @Override
    public Appointment findById(String appointmentId) {
        return repository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found"));
    }

    @Transactional
    @Override
    public DataResult<AppointmentResponse> saveToDb(CreateAppointmentRequest request) {
        User investor = userService.findById(request.getInvestorId());
        User entrepreneur = userService.findById(request.getEntrepreneurId());
        User requestBy = userService.findById(request.getRequestById());
        TechnoparkUser technoparkUser = technoparkUserService.findByUserId(request.getTechnoparkId());
        Listing listing = listingService.findById(request.getListingId());
        Appointment appointment = new Appointment(request, investor, entrepreneur, requestBy, technoparkUser);
        appointment.setListing(listing);
        if (request.getMeetingTypeEnum() == MeetingTypeEnum.ONLINE) {
            appointment.setOnlineLink("https://buluşma linki.com");
        } else if (request.getMeetingTypeEnum() == MeetingTypeEnum.FACE_TO_FACE) {
            Desk availableDesk = deskService.findByDeskAvailableAndRoom_TechnoparkUser(DeskAvailableEnum.AVAILABLE, technoparkUser).get(0);
            appointment.setDesk(availableDesk);
            appointment.setRoom(availableDesk.getRoom());
            deskService.updateDeskAsNotAvailable(availableDesk.getId());
        }
        Appointment savedAppointment = repository.save(appointment);
        return new SuccessDataResult<>(new AppointmentResponse(savedAppointment,
                new UserDetailResponse(investor),
                new UserDetailResponse(entrepreneur),
                new UserDetailResponse(requestBy),
                new GetListingResponse(listing))
        );
    }

    @Override
    public DataResult<List<AppointmentResponse>> findByAppointmentStatusAndTechnoparkUserOrderByCreatedAtDesc(ApprovalStatusEnum status, String technoparkUserId) {
        TechnoparkUser technoparkUser = technoparkUserService.findById(technoparkUserId);
        List<AppointmentResponse> appointmentResponses = new ArrayList<>();
        for (Appointment appointment : repository.findByAppointmentStatusAndTechnoparkUserOrderByCreatedAtDesc(status, technoparkUser)) {
            appointmentResponses.add(
                    new AppointmentResponse(
                            appointment,
                            new UserDetailResponse(appointment.getInvestor()),
                            new UserDetailResponse(appointment.getEntrepreneur()),
                            new UserDetailResponse(appointment.getRequestBy()),
                            new GetListingResponse(appointment.getListing())
                    )

            );
        }
        return new SuccessDataResult<>(appointmentResponses);
    }
}
