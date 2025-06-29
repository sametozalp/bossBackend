package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.SectorService;
import com.boss.bossBackend.dataAccess.abstracts.SectorRepository;
import com.boss.bossBackend.entities.concretes.Sector;
import org.springframework.stereotype.Service;

@Service
public class SectorManager implements SectorService {

    private final SectorRepository repository;

    public SectorManager(SectorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Sector findBySectorId(int sectorId) {
        return repository.findById(sectorId).orElseThrow(() -> new SectorNotFoundException("Sector not found"));
    }
}
