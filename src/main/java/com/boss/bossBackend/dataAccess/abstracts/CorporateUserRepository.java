package com.boss.bossBackend.dataAccess.abstracts;

import com.boss.bossBackend.entities.concretes.CorporateUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateUserRepository extends JpaRepository<CorporateUser, String> {

    Boolean existsByUserId(String userId);

}
