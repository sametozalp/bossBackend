package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.IndividualUserService;
import com.boss.bossBackend.business.abstracts.UserAccountService;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.IndividualUserDetailResponse;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.UserDetailResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.common.utilities.results.Result;
import com.boss.bossBackend.common.utilities.results.SuccessDataResult;
import com.boss.bossBackend.common.utilities.results.SuccessResult;
import com.boss.bossBackend.entities.concretes.IndividualUser;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndividualUserAccountService implements UserAccountService {

    private final IndividualUserService individualUserService;

    public IndividualUserAccountService(IndividualUserService individualUserService) {
        this.individualUserService = individualUserService;
    }

    @Override
    public DataResult<List<UserDetailResponse>> getUsersByApprovalStatusAndTechnopark(ApprovalStatusEnum approvalStatusEnum, String associatedTechnoparkId) {
        List<UserDetailResponse> individualUsers = individualUserService
                .findByApprovalStatusEnumAndAssociatedTechnoparkOrderByCreatedAtDesc(approvalStatusEnum, associatedTechnoparkId)
                .stream()
                .map(user -> new UserDetailResponse(new IndividualUserDetailResponse(user)))
                .toList();
        return new SuccessDataResult<>(individualUsers);
    }

    @Override
    public Result updateApprovalStatus(String userId, ApprovalStatusEnum approvalStatusEnum) {
        IndividualUser individualUser = individualUserService.findById(userId);
        individualUser.setApprovalStatusEnum(approvalStatusEnum);
        individualUserService.saveToDb(individualUser);
        return new SuccessResult();
    }

    @Override
    public boolean existsById(String userId) {
        return individualUserService.existsById(userId);
    }
} 