package com.boss.bossBackend.business.dtos.responses.userDetailResponse;

import com.boss.bossBackend.entities.concretes.IndividualUser;

public class IndividualUserDetailResponse {

    private String id;
    private String name;
    private String surname;
    private String socialSecurityNumber;
    private String phoneNumber;

    public IndividualUserDetailResponse() {
    }

    public IndividualUserDetailResponse(IndividualUser individualUser) {
        this.id = individualUser.getId();
        this.name = individualUser.getName();
        this.surname = individualUser.getSurname();
        this.socialSecurityNumber = individualUser.getSocialSecurityNumber();
        this.phoneNumber = individualUser.getPhoneNumber();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
