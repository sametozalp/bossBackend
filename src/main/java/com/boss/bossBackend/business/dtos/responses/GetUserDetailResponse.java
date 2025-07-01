package com.boss.bossBackend.business.dtos.responses;

public class GetUserDetailResponse {

    private CustomUserResponse user;
    private CorporateUserResponse corporateUser;
    private IndividualUserResponse individualUser;

    public GetUserDetailResponse() {

    }

    public GetUserDetailResponse(CustomUserResponse customUserResponse, CorporateUserResponse corporateUserResponse, IndividualUserResponse individualUserResponse) {
        this.user = customUserResponse;
        this.corporateUser = corporateUserResponse;
        this.individualUser = individualUserResponse;
    }

    public CustomUserResponse getUser() {
        return user;
    }

    public void setUser(CustomUserResponse user) {
        this.user = user;
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
}
