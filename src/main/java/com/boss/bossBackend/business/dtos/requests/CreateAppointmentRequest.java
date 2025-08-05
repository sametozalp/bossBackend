package com.boss.bossBackend.business.dtos.requests;

import com.boss.bossBackend.entities.enums.MeetingTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateAppointmentRequest {

    @NotBlank(message = "Investor id cannot be blank")
    @NotNull(message = "Investor id cannot be null")
    private String investorId;

    @NotBlank(message = "EntrepreneurId cannot be blank")
    @NotNull(message = "EntrepreneurId id cannot be null")
    private String entrepreneurId;

    @NotBlank(message = "RequestBy Id cannot be blank")
    @NotNull(message = "RequestBy Id id cannot be null")
    private String requestById;

    @NotBlank(message = "Listing Id cannot be blank")
    @NotNull(message = "Listing id cannot be null")
    private String listingId;

    @NotBlank(message = "Technopark Id cannot be blank")
    @NotNull(message = "Technopark Id id cannot be null")
    private String technoparkId;

    @NotNull(message = "Appointment date cannot be null")
    private LocalDateTime appointmentDate;

    @NotNull(message = "Meeting type cannot be null")
    private MeetingTypeEnum meetingTypeEnum;

    @NotNull(message = "Meeting time cannot be null")
    private int meetingTime;
}
