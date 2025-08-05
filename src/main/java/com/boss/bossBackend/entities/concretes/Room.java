package com.boss.bossBackend.entities.concretes;

import com.boss.bossBackend.business.dtos.requests.CreateRoomRequest;
import com.boss.bossBackend.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rooms")
@Getter
@Setter
public class Room extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "technopark_id", nullable = false)
    private TechnoparkUser technoparkUser;

    @Column(name = "room_name", nullable = false, unique = true)
    private String roomName;

    public Room() {

    }

    public Room(CreateRoomRequest request, TechnoparkUser technoparkUser) {
        this.roomName = request.getRoomName();
        this.technoparkUser = technoparkUser;
    }
}
