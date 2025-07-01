package com.boss.bossBackend.business.dtos.responses.userDetailResponse;

import com.boss.bossBackend.entities.concretes.TechnoparkUser;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
