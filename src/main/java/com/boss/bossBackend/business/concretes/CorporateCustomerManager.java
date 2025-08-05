package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.*;
import com.boss.bossBackend.business.dtos.requests.CorporateUserCompleteProfileRequest;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.CorporateUserDetailResponse;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.FullUserDetailResponse;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.UserDetailResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.common.utilities.results.Result;
import com.boss.bossBackend.common.utilities.results.SuccessDataResult;
import com.boss.bossBackend.common.utilities.results.SuccessResult;
import com.boss.bossBackend.dataAccess.abstracts.CorporateUserRepository;
import com.boss.bossBackend.entities.concretes.CorporateUser;
import com.boss.bossBackend.entities.concretes.Sector;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import com.boss.bossBackend.entities.enums.UserType;
import com.boss.bossBackend.exception.userException.UserAlreadyExistException;
import com.boss.bossBackend.exception.userException.UserNotFoundException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorporateCustomerManager implements CorporateUserService, CustomerAccountService {

    private final CorporateUserRepository repository;
    private final UserService userService;
    private final SectorService sectorService;
    private final TechnoparkUserService technoparkUserService;

    public CorporateCustomerManager(CorporateUserRepository repository, @Lazy UserService userService, SectorService sectorService, TechnoparkUserService technoparkUserService) {
        this.repository = repository;
        this.userService = userService;
        this.sectorService = sectorService;
        this.technoparkUserService = technoparkUserService;
    }

    @Override
    public DataResult<FullUserDetailResponse> completeProfile(CorporateUserCompleteProfileRequest request) {
        controlForRegisterParameters(request);
        Sector sector = sectorService.findBySectorId(request.getSectorId());
        User user = userService.findById(request.getUserId());
        user.setUserType(UserType.CORPORATE);
        TechnoparkUser associatedTechnopark = technoparkUserService.findById(request.getAssociatedTechnopark());
        CorporateUser corporateUser = new CorporateUser(request, user, sector, associatedTechnopark);
        repository.save(corporateUser);
        return userService.getUserDetails(request.getUserId());
    }

    @Override
    public CorporateUser findByUserId(String userId) {
        return repository.findByUserId(userId)
                .orElseThrow(() -> new UserNotFoundException("Corporate user not found"));
    }

    @Override
    public Optional<CorporateUser> findByUserIdOptional(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<CorporateUser> findByApprovalStatusEnumAndAssociatedTechnoparkOrderByCreatedAtDesc(ApprovalStatusEnum approvalStatusEnum, String associatedTechnoparkId) {
        TechnoparkUser associatedTechnopark = technoparkUserService.findById(associatedTechnoparkId);
        return repository.findByApprovalStatusEnumAndAssociatedTechnoparkOrderByCreatedAtDesc(approvalStatusEnum, associatedTechnopark);
    }

    @Override
    public DataResult<List<UserDetailResponse>> getUsersByApprovalStatusAndTechnopark(ApprovalStatusEnum approvalStatusEnum, String associatedTechnoparkId) {
        List<UserDetailResponse> corporateUsers = findByApprovalStatusEnumAndAssociatedTechnoparkOrderByCreatedAtDesc(approvalStatusEnum, associatedTechnoparkId)
                .stream()
                .map(user -> new UserDetailResponse(new CorporateUserDetailResponse(user)))
                .toList();
        return new SuccessDataResult<>(corporateUsers);
    }

    @Override
    public Result updateApprovalStatus(String userId, ApprovalStatusEnum approvalStatusEnum) {
        CorporateUser corporateUser = findById(userId);
        corporateUser.setApprovalStatusEnum(approvalStatusEnum);
        saveToDb(corporateUser);
        return new SuccessResult();
    }

    @Override
    public Boolean existsById(String id) {
        return repository.existsById(id);
    }

    @Override
    public CorporateUser findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Corporate user not found"));
    }

    @Override
    public void saveToDb(CorporateUser corporateUser) {
        repository.save(corporateUser);
    }


    private void controlForRegisterParameters(CorporateUserCompleteProfileRequest request) {
        if (repository.existsByUserId(request.getUserId())) {
            throw new UserAlreadyExistException("User is already exist.");
        }
    }
}
