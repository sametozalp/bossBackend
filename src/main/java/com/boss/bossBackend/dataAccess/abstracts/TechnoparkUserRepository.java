package com.boss.bossBackend.dataAccess.abstracts;

import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechnoparkUserRepository extends JpaRepository<TechnoparkUser, String> {

    Optional<TechnoparkUser> findByUserId(String userId);


}
