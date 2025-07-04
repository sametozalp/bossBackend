package com.boss.bossBackend.api.controllers;

import com.boss.bossBackend.business.abstracts.ListingService;
import com.boss.bossBackend.business.dtos.requests.CreateListingRequest;
import com.boss.bossBackend.entities.enums.ListingTypeEnum;
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
    public ResponseEntity<?> getListing(@RequestParam String listingId) {
        return ResponseEntity.ok(listingService.getListing(listingId));
    }

    @GetMapping("/getUsersListings")
    public ResponseEntity<?> getUsersListings(@RequestParam String userId, @RequestParam ListingTypeEnum listingTypeEnum) {
        return ResponseEntity.ok(listingService.getListings(userId, listingTypeEnum));
    }

    @GetMapping("/getAllFeedListings")
    public ResponseEntity<?> getAllFeedListings(@RequestParam String userId, @RequestParam ListingTypeEnum listingTypeEnum) {
        return ResponseEntity.ok(listingService.getAllFeedListings(userId, listingTypeEnum));
    }

    @GetMapping("/getAllTechnoParksListings")
    public ResponseEntity<?> getAllTechnoParksListings(@RequestParam String technoparkId, @RequestParam ListingTypeEnum listingTypeEnum) {
        return ResponseEntity.ok(listingService.getAllListingsForTechnopark(technoparkId, listingTypeEnum));
    }

}
