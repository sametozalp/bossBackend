package com.boss.bossBackend.business.dtos.responses;

import com.boss.bossBackend.entities.concretes.Desk;
import com.boss.bossBackend.entities.enums.DeskAvailableEnum;

public class DeskResponse {

    String id;
    String deskName;
    DeskAvailableEnum deskAvailableEnum;

    public DeskResponse() {

    }

    public DeskResponse(Desk desk) {
        this.id = desk.getId();
        this.deskName = desk.getDeskName();
        this.deskAvailableEnum = desk.getDeskAvailable();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeskName() {
        return deskName;
    }

    public void setDeskName(String deskName) {
        this.deskName = deskName;
    }

    public DeskAvailableEnum getDeskAvailableEnum() {
        return deskAvailableEnum;
    }

    public void setDeskAvailableEnum(DeskAvailableEnum deskAvailableEnum) {
        this.deskAvailableEnum = deskAvailableEnum;
    }
}
