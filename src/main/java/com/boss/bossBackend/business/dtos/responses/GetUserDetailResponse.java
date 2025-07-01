package com.boss.bossBackend.business.dtos.responses;

public class GetUserDetailResponse {

    private CustomUserResponse user;

    public GetUserDetailResponse() {

    }

    public GetUserDetailResponse(CustomUserResponse customUserResponse) {
        this.user = customUserResponse;
    }

    public CustomUserResponse getUser() {
        return user;
    }

    public void setUser(CustomUserResponse user) {
        this.user = user;
    }
}
