package com.boss.bossBackend.business.dtos.responses;

import com.boss.bossBackend.entities.concretes.Desk;
import com.boss.bossBackend.entities.enums.DeskAvailableEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeskResponse {

    String id;
    String deskName;
    DeskAvailableEnum deskAvailableEnum;

    public DeskResponse() {

    }

    public DeskResponse(Desk desk) {
        if (desk != null) {
            this.id = desk.getId();
            this.deskName = desk.getDeskName();
            //this.deskAvailableEnum = desk.getDeskAvailable();
        }
    }
}
