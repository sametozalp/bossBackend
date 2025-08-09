package com.boss.bossBackend.entities.concretes;

import com.boss.bossBackend.business.dtos.requests.CreateDeskRequest;
import com.boss.bossBackend.entities.abstracts.BaseEntity;
import com.boss.bossBackend.entities.enums.DeskAvailableEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "desks")
@Getter
@Setter
public class Desk extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Column(name = "desk_name", nullable = false, unique = true)
    private String deskName;

    @OneToMany(mappedBy = "desk")
    private List<Appointment> appointment;

    public Desk() {

    }

    public Desk(Room room) {
        this.room = room;
    }

    public Desk(CreateDeskRequest request, Room room) {
        this.room = room;
        this.deskName = request.getDeskName();
    }
}
