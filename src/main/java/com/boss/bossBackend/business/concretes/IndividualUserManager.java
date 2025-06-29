package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.IndividualUserService;
import com.boss.bossBackend.business.abstracts.UserService;
import com.boss.bossBackend.business.dtos.requests.IndividualUserCompleteProfileRequest;
import com.boss.bossBackend.common.utilities.results.SuccessResult;
import com.boss.bossBackend.dataAccess.abstracts.IndividualUserRepository;
import com.boss.bossBackend.entities.concretes.IndividualUser;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.exception.userException.UserAlreadyExistException;
import org.springframework.stereotype.Service;

@Service
public class IndividualUserManager implements IndividualUserService {

    private final IndividualUserRepository individualUserRepository;
    private final UserService userService;

    public IndividualUserManager(IndividualUserRepository individualUserRepository, UserService userService) {
        this.individualUserRepository = individualUserRepository;
        this.userService = userService;
    }


    @Override
    public SuccessResult completeProfile(IndividualUserCompleteProfileRequest request) {

        controlForRegisterParameters(request);

        User user = userService.getUser(request.getUserId());
        IndividualUser individualUser = new IndividualUser(request, user);

        individualUserRepository.save(individualUser);

        return new SuccessResult();
    }

    private void controlForRegisterParameters(IndividualUserCompleteProfileRequest request) {
        if (individualUserRepository.existsByUserId(request.getUserId())) {
            throw new UserAlreadyExistException("User is already exist.");
        }
    }
}
