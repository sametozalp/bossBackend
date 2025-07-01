package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.RoleService;
import com.boss.bossBackend.dataAccess.abstracts.RoleRepository;
import com.boss.bossBackend.entities.concretes.Role;
import com.boss.bossBackend.entities.enums.RoleEnum;
import com.boss.bossBackend.exception.roleException.RoleNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RoleManager implements RoleService {

    private final RoleRepository repository;

    public RoleManager(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role findByName(RoleEnum roleEnum) {
        return repository.findByName(roleEnum)
                .orElseThrow(() -> new RoleNotFoundException("Role not found"));
    }

//    @Override
//    public Role findById(int id) {
//        return repository.findById(id).orElseThrow(() -> new RoleNotFoundException("Role not found"));
//    }
}
