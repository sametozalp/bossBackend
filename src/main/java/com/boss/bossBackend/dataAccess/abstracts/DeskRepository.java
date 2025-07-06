package com.boss.bossBackend.dataAccess.abstracts;

import com.boss.bossBackend.entities.concretes.Desk;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.enums.DeskAvailableEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeskRepository extends JpaRepository<Desk, String> {

    List<Desk> findByDeskAvailableAndRoom_TechnoparkUser(
            DeskAvailableEnum deskAvailableEnum,
            TechnoparkUser technoparkUser
    );
}
