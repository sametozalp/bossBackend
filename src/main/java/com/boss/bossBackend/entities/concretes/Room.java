package com.boss.bossBackend.entities.concretes;

import com.boss.bossBackend.entities.abstracts.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "technopark_id", nullable = false)
    private TechnoparkUser technoparkUser;

    @Column(name = "room_name", nullable = false, unique = true)
    private String roomName;

    public Room() {

    }

    public Room(TechnoparkUser technoparkUser) {
        this.technoparkUser = technoparkUser;
    }
}
