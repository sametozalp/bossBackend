package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.CorporateUserService;
import com.boss.bossBackend.business.abstracts.IndividualUserService;
import com.boss.bossBackend.business.abstracts.UserService;
import com.boss.bossBackend.business.dtos.requests.UserRegisterRequest;
import com.boss.bossBackend.business.dtos.requests.UserUpdateRequest;
import com.boss.bossBackend.business.dtos.responses.CorporateUserResponse;
import com.boss.bossBackend.business.dtos.responses.CustomUserResponse;
import com.boss.bossBackend.business.dtos.responses.GetUserDetailResponse;
import com.boss.bossBackend.business.dtos.responses.IndividualUserResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.common.utilities.results.SuccessDataResult;
import com.boss.bossBackend.dataAccess.abstracts.UserRepository;
import com.boss.bossBackend.entities.concretes.CorporateUser;
import com.boss.bossBackend.entities.concretes.IndividualUser;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.exception.userException.EmailAlreadyUseException;
import com.boss.bossBackend.exception.userException.UserNotFoundException;
import com.boss.bossBackend.exception.userException.UsernameAlreadyUseException;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final IndividualUserService individualUserService;
    private final CorporateUserService corporateUserService;

    public UserManager(UserRepository userRepository, @Lazy IndividualUserService individualUserService, CorporateUserService corporateUserService) {
        this.userRepository = userRepository;
        this.individualUserService = individualUserService;
        this.corporateUserService = corporateUserService;
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
    public DataResult<GetUserDetailResponse> getUserDetails(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        CustomUserResponse customUserResponse = new CustomUserResponse(user);

        CorporateUserResponse corporateUserResponse = corporateUserService.findByUserIdOptional(userId)
                .map(CorporateUserResponse::new)
                .orElse(null);

        IndividualUserResponse individualUserResponse = individualUserService.findByUserIdOptional(userId)
                .map(IndividualUserResponse::new)
                .orElse(null);

        return new SuccessDataResult<>(new GetUserDetailResponse(customUserResponse, corporateUserResponse, individualUserResponse));
    }
}
