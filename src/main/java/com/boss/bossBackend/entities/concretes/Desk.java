package com.boss.bossBackend.entities.concretes;

import com.boss.bossBackend.business.dtos.requests.CreateDeskRequest;
import com.boss.bossBackend.entities.abstracts.BaseEntity;
import com.boss.bossBackend.entities.enums.DeskAvailableEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "desks")
public class Desk extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Enumerated(EnumType.STRING)
    @Column(name = "desk_available")
    private DeskAvailableEnum deskAvailable = DeskAvailableEnum.AVAILABLE;

    @Column(name = "desk_name", nullable = false, unique = true)
    private String deskName;

    public Desk() {

    }

    public Desk(Room room, DeskAvailableEnum deskAvailable) {
        this.room = room;
        this.deskAvailable = deskAvailable;
    }

    public Desk(CreateDeskRequest request, Room room) {
        this.room = room;
        this.deskName = request.getDeskName();
    }

    public Room getRoom() {
        return room;
    }

    public DeskAvailableEnum getDeskAvailable() {
        return deskAvailable;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setDeskAvailable(DeskAvailableEnum deskAvailable) {
        this.deskAvailable = deskAvailable;
    }

    public void setDeskName(String deskName) {
        this.deskName = deskName;
    }

    public String getDeskName() {
        return deskName;
    }
}
