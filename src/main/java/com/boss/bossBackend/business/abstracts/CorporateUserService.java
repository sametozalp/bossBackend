package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.CorporateUserCompleteProfileRequest;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.FullUserDetailResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.entities.concretes.CorporateUser;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;

import java.util.List;
import java.util.Optional;

public interface CorporateUserService {

    DataResult<FullUserDetailResponse> completeProfile(CorporateUserCompleteProfileRequest request);

    CorporateUser findByUserId(String userId);

    Optional<CorporateUser> findByUserIdOptional(String userId);

    List<CorporateUser> findByApprovalStatusEnumAndAssociatedTechnoparkOrderByCreatedAtDesc(
            ApprovalStatusEnum approvalStatusEnum,
            String associatedTechnoparkId
    );


}
