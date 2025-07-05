package com.boss.bossBackend.entities.concretes;

import com.boss.bossBackend.entities.abstracts.BaseEntity;
import com.boss.bossBackend.entities.enums.DeskAvailableEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "desks")
public class Desk extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Column(name = "desk_available")
    private DeskAvailableEnum deskAvailable = DeskAvailableEnum.AVAILABLE;

    @Column(name = "desk_name", nullable = false, unique = true)
    private String deskName;

    public Desk(Room room, DeskAvailableEnum deskAvailable) {
        this.room = room;
        this.deskAvailable = deskAvailable;
    }

    public Desk(Room room) {
        this.room = room;
    }
}
