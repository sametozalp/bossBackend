package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.CorporateUserService;
import com.boss.bossBackend.business.abstracts.IndividualUserService;
import com.boss.bossBackend.business.abstracts.TechnoparkUserService;
import com.boss.bossBackend.business.abstracts.UserService;
import com.boss.bossBackend.business.dtos.requests.UserRegisterRequest;
import com.boss.bossBackend.business.dtos.requests.UserUpdateRequest;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.*;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.common.utilities.results.SuccessDataResult;
import com.boss.bossBackend.dataAccess.abstracts.UserRepository;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.exception.userException.EmailAlreadyUseException;
import com.boss.bossBackend.exception.userException.UserNotFoundException;
import com.boss.bossBackend.exception.userException.UsernameAlreadyUseException;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final IndividualUserService individualUserService;
    private final CorporateUserService corporateUserService;
    private final TechnoparkUserService technoparkUserService;

    public UserManager(UserRepository userRepository, @Lazy IndividualUserService individualUserService, CorporateUserService corporateUserService, TechnoparkUserService technoparkUserService) {
        this.userRepository = userRepository;
        this.individualUserService = individualUserService;
        this.corporateUserService = corporateUserService;
        this.technoparkUserService = technoparkUserService;
    }

    public User saveToDb(User user) {
        return userRepository.save(user);
    }

    @Override
    public void controlForRegisterParameters(UserRegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyUseException("Email is already in use.");
        } else if (userRepository.existsByUsername(request.getUsername())) {
            throw new UsernameAlreadyUseException("Username is already in use.");
        }
    }

    @Override
    public User updateUser(UserUpdateRequest request) {
        User user = userRepository.findById(request.getId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        user.setUsername(request.getUsername());
//
//        if (request.getPassword() != null && !request.getPassword().isBlank()) {
//            user.setPassword(passwordEncoder.encode(request.getPassword()));
//        }

        return userRepository.save(user);
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public DataResult<FullUserDetailResponse> getUserDetails(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        CorporateUserDetailResponse corporateUserDetailResponse = corporateUserService.findByUserIdOptional(userId)
                .map(CorporateUserDetailResponse::new)
                .orElse(null);

        IndividualUserDetailResponse individualUserDetailResponse = individualUserService.findByUserIdOptional(userId)
                .map(IndividualUserDetailResponse::new)
                .orElse(null);

        TechnoParkUserDetailResponse technoParkUserDetailResponse = technoparkUserService.findByUserIdOptional(userId)
                .map(TechnoParkUserDetailResponse::new)
                .orElse(null);

        UserDetailResponse userDetailResponse = new UserDetailResponse(user, corporateUserDetailResponse, individualUserDetailResponse, technoParkUserDetailResponse);
        return new SuccessDataResult<>(new FullUserDetailResponse(userDetailResponse));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
