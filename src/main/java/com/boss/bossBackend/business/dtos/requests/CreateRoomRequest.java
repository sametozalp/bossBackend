package com.boss.bossBackend.business.dtos.requests;

import jakarta.validation.constraints.NotBlank;

public class CreateRoomRequest {

    @NotBlank(message = "Technopark user id cannot be blank")
    private String technoparkUserId;

    public String getTechnoparkUserId() {
        return technoparkUserId;
    }

    public void setTechnoparkUserId(String technoparkUserId) {
        this.technoparkUserId = technoparkUserId;
    }
}
