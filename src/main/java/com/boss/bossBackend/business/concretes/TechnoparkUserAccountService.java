package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.TechnoparkUserService;
import com.boss.bossBackend.business.abstracts.UserAccountService;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.TechnoParkUserDetailResponse;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.UserDetailResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.common.utilities.results.Result;
import com.boss.bossBackend.common.utilities.results.SuccessDataResult;
import com.boss.bossBackend.common.utilities.results.SuccessResult;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnoparkUserAccountService implements UserAccountService {

    private final TechnoparkUserService technoparkUserService;

    public TechnoparkUserAccountService(TechnoparkUserService technoparkUserService) {
        this.technoparkUserService = technoparkUserService;
    }

    @Override
    public DataResult<List<UserDetailResponse>> getUsersByApprovalStatusAndTechnopark(ApprovalStatusEnum approvalStatusEnum, String associatedTechnoparkId) {
        List<UserDetailResponse> technoparkUsers = technoparkUserService
                .findByApprovalStatusEnumAndAssociatedTechnoparkOrderByCreatedAtDesc(approvalStatusEnum, associatedTechnoparkId)
                .stream()
                .map(user -> new UserDetailResponse(new TechnoParkUserDetailResponse(user)))
                .toList();
        return new SuccessDataResult<>(technoparkUsers);
    }

    @Override
    public Result updateApprovalStatus(String userId, ApprovalStatusEnum approvalStatusEnum) {
        TechnoparkUser technoparkUser = technoparkUserService.findById(userId);
        technoparkUser.setApprovalStatusEnum(approvalStatusEnum);
        technoparkUserService.saveToDb(technoparkUser);
        return new SuccessResult();
    }

    @Override
    public boolean existsById(String userId) {
        return technoparkUserService.existsById(userId);
    }
} 