package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.AuthService;
import com.boss.bossBackend.business.abstracts.UserService;
import com.boss.bossBackend.business.dtos.requests.UserRegisterRequest;
import com.boss.bossBackend.business.dtos.responses.UserResponse;
import com.boss.bossBackend.common.security.jwt.JwtService;
import com.boss.bossBackend.dataAccess.abstracts.UserRepository;
import com.boss.bossBackend.dataAccess.abstracts.UserRoleRepository;
import com.boss.bossBackend.entities.concretes.Role;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.entities.concretes.UserRole;
import com.boss.bossBackend.util.mappers.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserRoleRepository userRoleRepository;

    public AuthManager(UserService userService, UserRepository userRepository, UserService userService1, PasswordEncoder passwordEncoder, JwtService jwtService, UserRoleRepository userRoleRepository) {
        this.userService = userService1;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.userRoleRepository = userRoleRepository;
    }

    public ResponseEntity<UserResponse> login(User user) {

        UserResponse response = UserMapper.toResponse(user);

        String generatedToken = jwtService.generateToken(user.getEmail(),
                user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());

        String refreshToken = jwtService.generateToken(user.getEmail(),
                user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());

        response.setAccessToken(generatedToken);

        response.setRefreshToken(refreshToken);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
//
//    public ResponseEntity<UserResponse> refreshToken(String refreshToken) {
//        if (!jwtService.isTokenValid(refreshToken)) {
//            throw new RuntimeException("Invalid refresh token");
//        }
//
//        User user = jwtService.extractUser(refreshToken);
//        return login(user);
//    }

    public ResponseEntity<UserResponse> register(UserRegisterRequest request) {

        userService.controlForRegisterParameters(request); // throw

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User result = userService.add(user);

        if (request.getIsCorporate()) {
            UserRole userRole = new UserRole();
            userRole.setUser(result);
            userRole.setRole(new Role(1));
            userRoleRepository.save(userRole);
        }

        return login(result);
    }

}
