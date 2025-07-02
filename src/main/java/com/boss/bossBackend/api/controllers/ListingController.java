package com.boss.bossBackend.api.controllers;

import com.boss.bossBackend.business.abstracts.ListingService;
import com.boss.bossBackend.business.dtos.requests.CreateListingRequest;
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

    @PostMapping("/createListing")
    public ResponseEntity<?> createListing(@Valid @RequestBody CreateListingRequest request) {
        return ResponseEntity.ok(listingService.saveToDatabase(request));
    }

    @GetMapping("/getListing")
    public ResponseEntity<?> getListings(@RequestParam String listingId) {
        return ResponseEntity.ok(listingService.getListing(listingId));
    }

}
