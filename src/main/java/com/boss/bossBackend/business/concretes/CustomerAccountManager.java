package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.CorporateUserService;
import com.boss.bossBackend.business.abstracts.CustomerAccountService;
import com.boss.bossBackend.business.abstracts.IndividualUserService;
import com.boss.bossBackend.business.abstracts.UserService;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.CorporateUserDetailResponse;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.IndividualUserDetailResponse;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.UserDetailResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.common.utilities.results.SuccessDataResult;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CustomerAccountManager implements CustomerAccountService {

    private final CorporateUserService corporateUserService;
    private final IndividualUserService individualUserService;

    public CustomerAccountManager(CorporateUserService corporateUserService, IndividualUserService individualUserService) {
        this.corporateUserService = corporateUserService;
        this.individualUserService = individualUserService;
    }

    @Override
    public DataResult<List<UserDetailResponse>> getAccountsByApprovalStatusSortedByCreatedDate(ApprovalStatusEnum approvalStatusEnum) {
        List<UserDetailResponse> corporateUsers = corporateUserService
                .findByApprovalStatusEnumOrderByCreatedAtDesc(approvalStatusEnum)
                .stream()
                .map(user -> new UserDetailResponse(new CorporateUserDetailResponse(user)))
                .toList();
        List<UserDetailResponse> individualUsers = individualUserService
                .findByApprovalStatusEnumOrderByCreatedAtDesc(approvalStatusEnum)
                .stream()
                .map(user -> new UserDetailResponse(new IndividualUserDetailResponse(user)))
                .toList();
        return new SuccessDataResult<>(Stream.concat(corporateUsers.stream(), individualUsers.stream())
                .sorted(Comparator.comparing(UserDetailResponse::getCreatedAt).reversed())
                .collect(Collectors.toList()));
    }
}
