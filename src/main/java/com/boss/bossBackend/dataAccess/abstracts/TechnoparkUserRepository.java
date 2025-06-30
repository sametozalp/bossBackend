package com.boss.bossBackend.dataAccess.abstracts;

import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnoparkUserRepository extends JpaRepository<TechnoparkUser, String> {

    TechnoparkUser findByUserId(String userId);


}
