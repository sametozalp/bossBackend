package com.boss.bossBackend.business.dtos.responses.userDetailResponse;

import com.boss.bossBackend.entities.concretes.IndividualUser;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IndividualUserDetailResponse {

    private String id;
    private String name;
    private String surname;
    private String socialSecurityNumber;
    private String phoneNumber;
    private LocalDateTime createdAt;

    public IndividualUserDetailResponse() {
    }

    public IndividualUserDetailResponse(IndividualUser individualUser) {
        this.id = individualUser.getId();
        this.name = individualUser.getName();
        this.surname = individualUser.getSurname();
        this.socialSecurityNumber = individualUser.getSocialSecurityNumber();
        this.phoneNumber = individualUser.getPhoneNumber();
        this.createdAt = individualUser.getCreatedAt();
    }
}
