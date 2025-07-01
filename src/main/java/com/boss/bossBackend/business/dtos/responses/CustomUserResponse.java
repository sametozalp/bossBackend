package com.boss.bossBackend.business.dtos.responses;

import com.boss.bossBackend.entities.concretes.User;

public class CustomUserResponse {
    private String id;
    private String username;
    private String email;
    private CorporateUserResponse corporateUser;
    private IndividualUserResponse individualUser;

    public CustomUserResponse() {

    }

    public CustomUserResponse(User user, CorporateUserResponse corporateUser, IndividualUserResponse individualUser) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.individualUser = individualUser;
        this.corporateUser = corporateUser;
    }

    public CorporateUserResponse getCorporateUser() {
        return corporateUser;
    }

    public void setCorporateUser(CorporateUserResponse corporateUser) {
        this.corporateUser = corporateUser;
    }

    public IndividualUserResponse getIndividualUser() {
        return individualUser;
    }

    public void setIndividualUser(IndividualUserResponse individualUser) {
        this.individualUser = individualUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
