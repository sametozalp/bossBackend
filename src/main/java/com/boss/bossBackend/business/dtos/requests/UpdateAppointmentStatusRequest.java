package com.boss.bossBackend.business.dtos.requests;

import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAppointmentStatusRequest {

    @NotNull(message = "Id is cannot be null")
    @NotBlank(message = "Id is cannot be blank")
    @NotEmpty(message = "Id is cannot be empty")
    private String id;

    @NotNull(message = "Status is cannot be null")
    private ApprovalStatusEnum appointmentStatus;

    @NotNull(message = "whoApprovesOrRejectsId is cannot be null")
    @NotBlank(message = "whoApprovesOrRejectsId is cannot be blank")
    @NotEmpty(message = "whoApprovesOrRejectsId is cannot be empty")
    private String whoApprovesOrRejectsId;


}
