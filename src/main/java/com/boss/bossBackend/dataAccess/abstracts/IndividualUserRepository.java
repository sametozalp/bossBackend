package com.boss.bossBackend.dataAccess.abstracts;

import com.boss.bossBackend.entities.concretes.CorporateUser;
import com.boss.bossBackend.entities.concretes.IndividualUser;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IndividualUserRepository extends JpaRepository<IndividualUser, String> {

    Boolean existsByUserId(String userId);

    Optional<IndividualUser> findByUserId(String userId);

    List<IndividualUser> findByApprovalStatusEnumAndAssociatedTechnoparkOrderByCreatedAtDesc(
            ApprovalStatusEnum approvalStatusEnum,
            TechnoparkUser associatedTechnopark
    );

}
