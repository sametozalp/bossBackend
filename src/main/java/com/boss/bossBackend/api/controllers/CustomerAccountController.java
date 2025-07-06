package com.boss.bossBackend.api.controllers;

import com.boss.bossBackend.business.abstracts.CustomerAccountService;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/changeApprovalStatus")
    ResponseEntity<?> changeApprovalStatus(@RequestParam String customerId, @RequestParam ApprovalStatusEnum approvalStatusEnum) {
        return ResponseEntity.ok(customerAccountService.changeApprovalStatus(customerId, approvalStatusEnum));
    }
}
