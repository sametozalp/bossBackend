package com.boss.bossBackend.handler;

import com.boss.bossBackend.business.abstracts.DeskService;
import com.boss.bossBackend.entities.enums.MeetingTypeEnum;

import static com.boss.bossBackend.entities.enums.MeetingTypeEnum.ONLINE;

public class AppointmentHandlerFactory {

    private DeskService deskService;

    public AppointmentHandlerFactory(DeskService deskService) {
        this.deskService = deskService;
    }

    public AppointmentHandler getHandler(MeetingTypeEnum meetingType) {

        switch (meetingType) {
            case ONLINE:
                return new OnlineAppointmentHandler();
            case FACE_TO_FACE:
                return new FaceToFaceAppointmentHandler(deskService);
            default:
                throw new IllegalArgumentException("Unsupported meeting type: " + meetingType);
        }
    }
}
