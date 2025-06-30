package com.boss.bossBackend.dataAccess.abstracts;

import com.boss.bossBackend.entities.concretes.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, String> {
}
