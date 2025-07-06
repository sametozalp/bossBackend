package com.boss.bossBackend.api.controllers;

import com.boss.bossBackend.business.abstracts.CustomerAccountService;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customerAccount")
public class CustomerAccountController {

    private final CustomerAccountService customerAccountService;

    public CustomerAccountController(CustomerAccountService customerAccountService) {
        this.customerAccountService = customerAccountService;
    }

    @PostMapping("/getAccountsByApprovalStatus")
    ResponseEntity<?> getAccountsByApprovalStatus(@RequestParam ApprovalStatusEnum approvalStatusEnum, @RequestParam String associatedTechnoparkId) {
        return ResponseEntity.ok(customerAccountService.getAccountsByApprovalStatusSortedByCreatedDate(approvalStatusEnum, associatedTechnoparkId));
    }
}
