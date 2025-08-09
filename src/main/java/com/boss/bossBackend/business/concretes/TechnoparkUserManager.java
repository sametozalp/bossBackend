package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.RoleService;
import com.boss.bossBackend.business.abstracts.TechnoparkUserService;
import com.boss.bossBackend.business.abstracts.UserService;
import com.boss.bossBackend.business.dtos.requests.TechnoparkRegisterRequest;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.FullUserDetailResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.dataAccess.abstracts.TechnoparkUserRepository;
import com.boss.bossBackend.entities.concretes.Role;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.entities.concretes.UserRole;
import com.boss.bossBackend.entities.enums.RoleEnum;
import com.boss.bossBackend.exception.exceptions.userException.UserNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TechnoparkUserManager implements TechnoparkUserService {

    private final TechnoparkUserRepository repository;
    private final UserService userService;
    private final RoleService roleService;

    public TechnoparkUserManager(TechnoparkUserRepository repository, @Lazy UserService userService, RoleService roleService) {
        this.repository = repository;
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public TechnoparkUser findByUserId(String technoparkId) {
        return repository.findByUserId(technoparkId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public TechnoparkUser findById(String technoparkId) {
        return repository.findById(technoparkId)
                .orElseThrow(() -> new UserNotFoundException("Technopark not found"));
    }

    @Transactional
    @Override
    public DataResult<FullUserDetailResponse> saveToDb(TechnoparkRegisterRequest request, User savedUser) {
        TechnoparkUser technoparkUser = new TechnoparkUser(request, savedUser);

        UserRole userRole = new UserRole();
        userRole.setUser(savedUser);

        Role technoparkRole = roleService.findByName(RoleEnum.ROLE_TECHNOPARK);
        userRole.setRole(technoparkRole);

        ArrayList<UserRole> userRoleList = new ArrayList<>();
        userRoleList.add(userRole);
        savedUser.setRoles(userRoleList);
        repository.save(technoparkUser);

        return userService.getUserDetails(savedUser.getId());
    }

    @Override
    public Optional<TechnoparkUser> findByUserIdOptional(String userId) {
        return repository.findByUserId(userId);
    }
}
