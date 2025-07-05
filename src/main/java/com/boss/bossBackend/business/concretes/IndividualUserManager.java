package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.IndividualUserService;
import com.boss.bossBackend.business.abstracts.TechnoparkUserService;
import com.boss.bossBackend.business.abstracts.UserService;
import com.boss.bossBackend.business.dtos.requests.IndividualUserCompleteProfileRequest;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.FullUserDetailResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.dataAccess.abstracts.IndividualUserRepository;
import com.boss.bossBackend.entities.concretes.IndividualUser;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import com.boss.bossBackend.exception.userException.UserAlreadyExistException;
import com.boss.bossBackend.exception.userException.UserNotFoundException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndividualUserManager implements IndividualUserService {

    private final IndividualUserRepository individualUserRepository;
    private final UserService userService;
    private final TechnoparkUserService technoparkUserService;

    public IndividualUserManager(IndividualUserRepository individualUserRepository, @Lazy UserService userService, TechnoparkUserService technoparkUserService) {
        this.individualUserRepository = individualUserRepository;
        this.userService = userService;
        this.technoparkUserService = technoparkUserService;
    }


    @Override
    public DataResult<FullUserDetailResponse> completeProfile(IndividualUserCompleteProfileRequest request) {
        controlForRegisterParameters(request);
        User user = userService.findById(request.getUserId());
        TechnoparkUser associatedTechnopark = technoparkUserService.findById(request.getAssociatedTechnopark());
        IndividualUser individualUser = new IndividualUser(request, user, associatedTechnopark);
        individualUserRepository.save(individualUser);
        return userService.getUserDetails(request.getUserId());
    }

    @Override
    public IndividualUser findByUserId(String userId) {
        return individualUserRepository.findByUserId(userId)
                .orElseThrow(() -> new UserNotFoundException("Individual user not found"));
    }

    @Override
    public Optional<IndividualUser> findByUserIdOptional(String userId) {
        return individualUserRepository.findByUserId(userId);
    }

    @Override
    public List<IndividualUser> findByApprovalStatusEnumOrderByCreatedAtDesc(ApprovalStatusEnum approvalStatusEnum) {
        return individualUserRepository.findByApprovalStatusEnumOrderByCreatedAtDesc(approvalStatusEnum);
    }

    private void controlForRegisterParameters(IndividualUserCompleteProfileRequest request) {
        if (individualUserRepository.existsByUserId(request.getUserId())) {
            throw new UserAlreadyExistException("User is already exist.");
        }
    }
}
