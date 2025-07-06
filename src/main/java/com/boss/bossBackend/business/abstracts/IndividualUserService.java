package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.IndividualUserCompleteProfileRequest;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.FullUserDetailResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.entities.concretes.CorporateUser;
import com.boss.bossBackend.entities.concretes.IndividualUser;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;

import java.util.List;
import java.util.Optional;

public interface IndividualUserService {

    DataResult<FullUserDetailResponse> completeProfile(IndividualUserCompleteProfileRequest request);

    IndividualUser findByUserId(String userId);

    Optional<IndividualUser> findByUserIdOptional(String userId);

    List<IndividualUser> findByApprovalStatusEnumAndAssociatedTechnoparkOrderByCreatedAtDesc(
            ApprovalStatusEnum approvalStatusEnum,
            String associatedTechnoparkId
    );


}
