package com.boss.bossBackend.business.dtos.requests;

import com.boss.bossBackend.entities.enums.MeetingTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

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

    public String getInvestorId() {
        return investorId;
    }

    public void setInvestorId(String investorId) {
        this.investorId = investorId;
    }

    public String getEntrepreneurId() {
        return entrepreneurId;
    }

    public void setEntrepreneurId(String entrepreneurId) {
        this.entrepreneurId = entrepreneurId;
    }

    public String getRequestById() {
        return requestById;
    }

    public void setRequestById(String requestById) {
        this.requestById = requestById;
    }

    public String getTechnoparkId() {
        return technoparkId;
    }

    public void setTechnoparkId(String technoparkId) {
        this.technoparkId = technoparkId;
    }

    public MeetingTypeEnum getMeetingTypeEnum() {
        return meetingTypeEnum;
    }

    public void setMeetingTypeEnum(MeetingTypeEnum meetingTypeEnum) {
        this.meetingTypeEnum = meetingTypeEnum;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public String getListingId() {
        return listingId;
    }

    public void setListingId(String listingId) {
        this.listingId = listingId;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
