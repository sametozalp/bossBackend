package com.boss.bossBackend.dataAccess.abstracts;

import com.boss.bossBackend.entities.concretes.CorporateUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CorporateUserRepository extends JpaRepository<CorporateUser, String> {

    Boolean existsByUserId(String userId);

    Optional<CorporateUser> findByUserId(String userId);

}
