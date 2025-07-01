package com.boss.bossBackend.business.dtos.responses.userDetailResponse;

public class GetUserDetailResponse {

    private UserDetailResponse user;

    public GetUserDetailResponse() {

    }

    public GetUserDetailResponse(UserDetailResponse userDetailResponse) {
        this.user = userDetailResponse;
    }

    public UserDetailResponse getUser() {
        return user;
    }

    public void setUser(UserDetailResponse user) {
        this.user = user;
    }
}
