package com.boss.bossBackend.api.controllers;

import com.boss.bossBackend.business.abstracts.RoleService;
import com.boss.bossBackend.entities.enums.RoleEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/createRole")
    public ResponseEntity<?> createRole(@RequestParam RoleEnum roleEnum) {
        return new ResponseEntity<>(roleService.saveToDb(roleEnum), HttpStatus.OK);
    }
}
