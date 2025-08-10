package com.boss.bossBackend.business.jobs;

import com.boss.bossBackend.business.abstracts.AppointmentService;
import com.boss.bossBackend.business.abstracts.DeskService;
import com.boss.bossBackend.entities.concretes.Appointment;
import com.boss.bossBackend.entities.concretes.Desk;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import com.boss.bossBackend.entities.enums.MeetingTypeEnum;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppointmentScheduler {

    private final AppointmentService appointmentService;
    private final DeskService deskService;

    public AppointmentScheduler(AppointmentService appointmentService, DeskService deskService) {
        this.appointmentService = appointmentService;
        this.deskService = deskService;
    }
//
//    @Scheduled(cron = "0 */30 * * * *")
//    public void runEveryHalfHour() {
//
//        List<Appointment> appointments =
//                appointmentService.findByAppointmentStatusAndMeetingTypeAndRoomIdIsNull(ApprovalStatusEnum.APPROVED, MeetingTypeEnum.FACE_TO_FACE);
//
//        for (Appointment appointment : appointments) {
//
//            TechnoparkUser technoparkUser = appointment.getTechnoparkUser();
//            List<Desk> availableDesks = deskService.findAvailableDeskBetweenDatesAndTechnopark(appointment.getAppointmentDate(), appointment.getAppointmentDateEnd(), technoparkUser.getId());
//
//            if (!availableDesks.isEmpty()) {
//                appointment.setDesk(availableDesks.get(0));
//                appointment.setRoom(availableDesks.get(0).getRoom());
//                appointmentService.updateAppointment(appointment);
//            }
//        }
//    }
}
