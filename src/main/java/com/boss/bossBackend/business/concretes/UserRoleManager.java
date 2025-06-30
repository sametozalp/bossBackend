package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.UserRoleService;
import com.boss.bossBackend.dataAccess.abstracts.UserRoleRepository;
import com.boss.bossBackend.entities.concretes.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleManager implements UserRoleService {

    private final UserRoleRepository repository;

    public UserRoleManager(UserRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserRole> findByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public UserRole save(UserRole userRole) {
        return repository.save(userRole);
    }
}
