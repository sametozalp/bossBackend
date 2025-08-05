package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.CustomerAccountService;
import com.boss.bossBackend.business.abstracts.UserAccountService;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.UserDetailResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.common.utilities.results.Result;
import com.boss.bossBackend.common.utilities.results.SuccessDataResult;
import com.boss.bossBackend.common.utilities.results.SuccessResult;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import com.boss.bossBackend.exception.userException.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CustomerAccountManager implements CustomerAccountService {

    private final List<UserAccountService> userAccountServices;

    public CustomerAccountManager(List<UserAccountService> userAccountServices) {
        this.userAccountServices = userAccountServices;
    }

    @Override
    public DataResult<List<UserDetailResponse>> getAccountsByApprovalStatusSortedByCreatedDate(ApprovalStatusEnum approvalStatusEnum, String associatedTechnoparkId) {
        List<UserDetailResponse> allUsers = userAccountServices.stream()
                .flatMap(service -> service.getUsersByApprovalStatusAndTechnopark(approvalStatusEnum, associatedTechnoparkId)
                        .getData()
                        .stream())
                .sorted(Comparator.comparing(UserDetailResponse::getCreatedAt).reversed())
                .collect(Collectors.toList());
        
        return new SuccessDataResult<>(allUsers);
    }

    @Override
    public Result changeApprovalStatus(String customerId, ApprovalStatusEnum approvalStatusEnum) {
        UserAccountService targetService = userAccountServices.stream()
                .filter(service -> service.existsById(customerId))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return targetService.updateApprovalStatus(customerId, approvalStatusEnum);
    }
}
