package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.SectorService;
import com.boss.bossBackend.common.utilities.results.SuccessResult;
import com.boss.bossBackend.dataAccess.abstracts.SectorRepository;
import com.boss.bossBackend.entities.concretes.Sector;
import com.boss.bossBackend.exception.sectorException.SectorNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SectorManager implements SectorService {

    private final SectorRepository repository;

    public SectorManager(SectorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Sector findBySectorId(String sectorId) {
        return repository.findById(sectorId).orElseThrow(() -> new SectorNotFoundException("Sector not found"));
    }

    @Override
    public SuccessResult saveToDbWithName(String name) {
        Sector sector = new Sector(name);
        repository.save(sector);
        return new SuccessResult();
    }
}
