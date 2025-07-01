package com.boss.bossBackend.business.dtos.responses.userDetailResponse;

import com.boss.bossBackend.entities.concretes.User;

public class UserDetailResponse {
    private String id;
    private String username;
    private String email;
    private CorporateUserDetailResponse corporateUser;
    private IndividualUserDetailResponse individualUser;
    private TechnoParkUserDetailResponse technoParkUser;

    public UserDetailResponse() {

    }

    public UserDetailResponse(User user, CorporateUserDetailResponse corporateUser, IndividualUserDetailResponse individualUser, TechnoParkUserDetailResponse technoParkUser) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.individualUser = individualUser;
        this.corporateUser = corporateUser;
        this.technoParkUser = technoParkUser;
    }

    public CorporateUserDetailResponse getCorporateUser() {
        return corporateUser;
    }

    public void setCorporateUser(CorporateUserDetailResponse corporateUser) {
        this.corporateUser = corporateUser;
    }

    public IndividualUserDetailResponse getIndividualUser() {
        return individualUser;
    }

    public void setIndividualUser(IndividualUserDetailResponse individualUser) {
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

    public TechnoParkUserDetailResponse getTechnoParkUser() {
        return technoParkUser;
    }

    public void setTechnoParkUser(TechnoParkUserDetailResponse technoParkUser) {
        this.technoParkUser = technoParkUser;
    }
}
