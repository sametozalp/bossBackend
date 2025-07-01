package com.boss.bossBackend.business.dtos.requests;

import com.boss.bossBackend.entities.enums.AppointmentEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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

    @NotBlank(message = "Technopark Id cannot be blank")
    @NotNull(message = "Technopark Id id cannot be null")
    private String technoparkId;

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
}
