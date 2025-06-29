package com.boss.bossBackend.api.controllers;

import com.boss.bossBackend.business.abstracts.ListingService;
import com.boss.bossBackend.business.dtos.requests.ListingSaveRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/listings")
public class ListingController {

    private final ListingService listingService;

    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveListing(@Valid @RequestBody ListingSaveRequest request) {
        return ResponseEntity.ok(listingService.save(request));
    }

    @GetMapping("/getListing")
    public ResponseEntity<?> getListings(@RequestParam String listingId) {
        return ResponseEntity.ok(listingService.getListing(listingId));
    }

}
