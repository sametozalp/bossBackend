package com.boss.bossBackend.business.dtos.responses.userDetailResponse;

import com.boss.bossBackend.entities.concretes.IndividualUser;

import java.time.LocalDateTime;

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
