package com.boss.bossBackend.business.dtos.responses.userDetailResponse;

public class FullUserDetailResponse {

    private UserDetailResponse user;

    public FullUserDetailResponse() {

    }

    public FullUserDetailResponse(UserDetailResponse userDetailResponse) {
        this.user = userDetailResponse;
    }

    public UserDetailResponse getUser() {
        return user;
    }

    public void setUser(UserDetailResponse user) {
        this.user = user;
    }
}
