package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.RoleService;
import com.boss.bossBackend.business.abstracts.AuthService;
import com.boss.bossBackend.business.abstracts.UserRoleService;
import com.boss.bossBackend.business.abstracts.UserService;
import com.boss.bossBackend.business.dtos.requests.UserLoginRequest;
import com.boss.bossBackend.business.dtos.requests.UserRegisterRequest;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.FullUserDetailResponse;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.UserDetailResponse;
import com.boss.bossBackend.common.security.jwt.JwtService;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.common.utilities.results.SuccessDataResult;
import com.boss.bossBackend.entities.concretes.Role;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.entities.concretes.UserRole;
import com.boss.bossBackend.entities.enums.RoleEnum;
import com.boss.bossBackend.exception.authException.LoginException;
import jakarta.transaction.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthManager implements AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final RoleService roleService;
    private final UserRoleService userRoleService;

    public AuthManager(UserService userService1, PasswordEncoder passwordEncoder, JwtService jwtService, RoleService roleService, UserRoleService userRoleService) {
        this.userService = userService1;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.roleService = roleService;
        this.userRoleService = userRoleService;
    }

    public DataResult<FullUserDetailResponse> generateTokens(User user) {

        DataResult<FullUserDetailResponse> response = userService.getUserDetails(user.getId());

        String generatedToken = jwtService.generateToken(user.getEmail(),
                user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());

        String refreshToken = jwtService.generateToken(user.getEmail(),
                user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());

        UserDetailResponse userDetailResponse = response.getData().getUser();
        userDetailResponse.setAccessToken(generatedToken);
        userDetailResponse.setRefreshToken(refreshToken);

        response.getData().setUser(userDetailResponse);

        return response;
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

    @Transactional
    public DataResult<FullUserDetailResponse> register(UserRegisterRequest request) {

        userService.controlForRegisterParameters(request); // throw
        request.setPassword(passwordEncoder.encode(request.getPassword()));

        User user = new User(request);
        User savedUser = userService.saveToDb(user); // save user

        UserRole userRole1 = new UserRole();
        userRole1.setUser(savedUser);

        Role investorRole = roleService.findByName(RoleEnum.INVESTOR);
        userRole1.setRole(investorRole);
        userRoleService.save(userRole1);

        UserRole userRole2 = new UserRole();
        userRole2.setUser(savedUser);
        Role entrepreneurRole = roleService.findByName(RoleEnum.ENTREPRENEUR);
        userRole2.setRole(entrepreneurRole);
        userRoleService.save(userRole2);

        ArrayList<UserRole> userRoleList = new ArrayList<>();
        userRoleList.add(userRole1);
        userRoleList.add(userRole2);
        savedUser.setRoles(userRoleList);

        return generateTokens(savedUser);
    }

    @Override
    public DataResult<FullUserDetailResponse> login(UserLoginRequest request) {
        User user = userService.findByEmail(request.getEmail());
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new LoginException("Incorrect password or email");
        }
        return userService.getUserDetails(user.getId());
    }
}
