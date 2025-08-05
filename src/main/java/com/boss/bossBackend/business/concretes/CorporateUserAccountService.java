package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.CorporateUserService;
import com.boss.bossBackend.business.abstracts.UserAccountService;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.CorporateUserDetailResponse;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.UserDetailResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.common.utilities.results.Result;
import com.boss.bossBackend.common.utilities.results.SuccessDataResult;
import com.boss.bossBackend.common.utilities.results.SuccessResult;
import com.boss.bossBackend.entities.concretes.CorporateUser;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorporateUserAccountService implements UserAccountService {

    private final CorporateUserService corporateUserService;

    public CorporateUserAccountService(CorporateUserService corporateUserService) {
        this.corporateUserService = corporateUserService;
    }

        @Override
        public DataResult<List<UserDetailResponse>> getUsersByApprovalStatusAndTechnopark(ApprovalStatusEnum approvalStatusEnum, String associatedTechnoparkId) {
            List<UserDetailResponse> corporateUsers = corporateUserService
                    .findByApprovalStatusEnumAndAssociatedTechnoparkOrderByCreatedAtDesc(approvalStatusEnum, associatedTechnoparkId)
                    .stream()
                    .map(user -> new UserDetailResponse(new CorporateUserDetailResponse(user)))
                    .toList();
            return new SuccessDataResult<>(corporateUsers);
        }

        @Override
        public Result updateApprovalStatus(String userId, ApprovalStatusEnum approvalStatusEnum) {
            CorporateUser corporateUser = corporateUserService.findById(userId);
        corporateUser.setApprovalStatusEnum(approvalStatusEnum);
        corporateUserService.saveToDb(corporateUser);
        return new SuccessResult();
    }

    @Override
    public boolean existsById(String userId) {
        return corporateUserService.existsById(userId);
    }
} 