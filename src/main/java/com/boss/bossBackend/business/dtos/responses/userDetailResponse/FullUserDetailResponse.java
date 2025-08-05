package com.boss.bossBackend.business.dtos.responses.userDetailResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullUserDetailResponse {

    private UserDetailResponse user;

    public FullUserDetailResponse() {

    }

    public FullUserDetailResponse(UserDetailResponse userDetailResponse) {
        this.user = userDetailResponse;
    }
}
