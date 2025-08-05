package com.boss.bossBackend.business.dtos.responses.userDetailResponse;

import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TechnoParkUserDetailResponse {

    private String id;
    private String name;
    private String location;

    public TechnoParkUserDetailResponse() {

    }

    public TechnoParkUserDetailResponse(TechnoparkUser technoparkUser) {
        this.id = technoparkUser.getId();
        this.name = technoparkUser.getName();
        this.location = technoparkUser.getLocation();
    }
}
