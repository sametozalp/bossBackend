package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.entities.concretes.Sector;

public interface SectorService {

    Sector findBySectorId(int sectorId);

}
