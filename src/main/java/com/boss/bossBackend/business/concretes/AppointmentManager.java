package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.*;
import com.boss.bossBackend.business.dtos.requests.CreateAppointmentRequest;
import com.boss.bossBackend.business.dtos.requests.UpdateAppointmentStatusRequest;
import com.boss.bossBackend.business.dtos.responses.AppointmentResponse;
import com.boss.bossBackend.business.dtos.responses.GetListingResponse;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.UserDetailResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.common.utilities.results.SuccessDataResult;
import com.boss.bossBackend.dataAccess.abstracts.AppointmentRepository;
import com.boss.bossBackend.entities.concretes.*;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import com.boss.bossBackend.entities.enums.MeetingTypeEnum;
import com.boss.bossBackend.exception.exceptions.appointmentException.AppointmentNotFoundException;
import com.boss.bossBackend.exception.exceptions.generalException.OwnerViolationException;
import com.boss.bossBackend.handler.AppointmentHandler;
import com.boss.bossBackend.handler.AppointmentHandlerFactory;
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
    private final IndividualUserService individualUserService;
    private final CorporateUserService corporateUserService;

    public AppointmentManager(AppointmentRepository repository, UserService userService, TechnoparkUserService technoparkUserService, DeskService deskService, ListingService listingService, IndividualUserService individualUserService, CorporateUserService corporateUserService) {
        this.repository = repository;
        this.userService = userService;
        this.technoparkUserService = technoparkUserService;
        this.deskService = deskService;
        this.listingService = listingService;
        this.individualUserService = individualUserService;
        this.corporateUserService = corporateUserService;
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

        TechnoparkUser technoparkUser = technoparkUserService.findById(request.getTechnoparkId());
        Listing listing = listingService.findById(request.getListingId());
        Appointment appointment = new Appointment(request, investor, entrepreneur, requestBy, technoparkUser);
        appointment.setListing(listing);

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

    @Override
    public DataResult<AppointmentResponse> updateAppointment(UpdateAppointmentStatusRequest updateAppointmentStatusRequest) {
        Appointment appointment = findById(updateAppointmentStatusRequest.getId());

        if (!updateAppointmentStatusRequest.getWhoApprovesOrRejectsId().equals(appointment.getInvestor().getId())
                && !updateAppointmentStatusRequest.getWhoApprovesOrRejectsId().equals(appointment.getEntrepreneur().getId())) {
            throw new OwnerViolationException("Owner violation error");

        }
        appointment.setAppointmentStatus(updateAppointmentStatusRequest.getAppointmentStatus());

//        if (appointment.getAppointmentStatus() == ApprovalStatusEnum.APPROVED) {
//            if (appointment.getMeetingTypeEnum() == MeetingTypeEnum.ONLINE) {
//
//                appointment.setOnlineLink("gorusmelink.com");
//
//            } else if (appointment.getMeetingTypeEnum() == MeetingTypeEnum.FACE_TO_FACE) {
//
//                List<Desk> availableDesks = deskService.findAvailableDeskBetweenDatesAndTechnopark(appointment.getAppointmentDate(), appointment.getAppointmentDateEnd(), appointment.getTechnoparkUser().getId());
//                if(!availableDesks.isEmpty()) {
//                    appointment.setRoom(availableDesks.get(0).getRoom());
//                    appointment.setDesk(availableDesks.get(0));
//                } else {
//                    throw new DeskNotFoundException("Available desk not found");
//                }
//            }
//
//        }

        if (appointment.getAppointmentStatus() == ApprovalStatusEnum.APPROVED) {
            AppointmentHandlerFactory factory = new AppointmentHandlerFactory(deskService);
            AppointmentHandler handler = factory.getHandler(appointment.getMeetingTypeEnum());
            handler.handle(appointment);
        }

        Appointment savedAppointment = repository.save(appointment);
        return new SuccessDataResult<>(new AppointmentResponse(savedAppointment,
                new UserDetailResponse(savedAppointment.getInvestor()),
                new UserDetailResponse(savedAppointment.getEntrepreneur()),
                new UserDetailResponse(savedAppointment.getRequestBy()),
                new GetListingResponse(savedAppointment.getListing())));
    }

    @Override
    public DataResult<AppointmentResponse> updateAppointment(Appointment appointment) {
        Appointment savedAppointment = repository.save(appointment);
        return new SuccessDataResult<>(new AppointmentResponse(savedAppointment,
                new UserDetailResponse(savedAppointment.getInvestor()),
                new UserDetailResponse(savedAppointment.getEntrepreneur()),
                new UserDetailResponse(savedAppointment.getRequestBy()),
                new GetListingResponse(savedAppointment.getListing())
        ));
    }

    @Override
    public List<Appointment> findByAppointmentStatusAndMeetingTypeAndRoomIdIsNull(ApprovalStatusEnum appointmentStatus, MeetingTypeEnum meetingType) {
        return repository.findByAppointmentStatusAndMeetingTypeEnumAndRoomIdIsNull(appointmentStatus, meetingType);
    }
}
