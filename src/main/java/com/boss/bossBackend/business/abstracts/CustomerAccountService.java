package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.responses.userDetailResponse.UserDetailResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;

import java.util.List;

public interface CustomerAccountService {

    DataResult<List<UserDetailResponse>> getAccountsByApprovalStatusSortedByCreatedDate(ApprovalStatusEnum approvalStatusEnum);


}
