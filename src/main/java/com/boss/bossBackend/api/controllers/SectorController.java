package com.boss.bossBackend.api.controllers;

import com.boss.bossBackend.business.abstracts.SectorService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sectors")
public class SectorController {

    private final SectorService sectorService;

    public SectorController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/createSector")
    public ResponseEntity<?> createSector(@RequestParam String name) {
        return ResponseEntity.ok(sectorService.saveToDbWithName(name));
    }
}
