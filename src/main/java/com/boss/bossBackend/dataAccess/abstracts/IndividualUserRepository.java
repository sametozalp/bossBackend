package com.boss.bossBackend.dataAccess.abstracts;

import com.boss.bossBackend.entities.concretes.IndividualUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualUserRepository extends JpaRepository<IndividualUser, String> {

    Boolean existsByUserId(String userId);
}
