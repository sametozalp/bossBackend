package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.UserService;
import com.boss.bossBackend.business.dtos.requests.UserRegisterRequest;
import com.boss.bossBackend.business.dtos.requests.UserUpdateRequest;
import com.boss.bossBackend.dataAccess.abstracts.UserRepository;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.exception.userException.EmailAlreadyUseException;
import com.boss.bossBackend.exception.userException.UsernameAlreadyUseException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private final UserRepository userRepository;

    public UserManager(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
    }

    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean controlForRegisterParameters(UserRegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyUseException("Email is already in use.");
        } else if (userRepository.existsByUsername(request.getUsername())) {
            throw new UsernameAlreadyUseException("Username is already in use.");
        }

        return true;
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
}
