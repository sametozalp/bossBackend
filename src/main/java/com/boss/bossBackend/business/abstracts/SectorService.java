package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.common.utilities.results.SuccessResult;
import com.boss.bossBackend.entities.concretes.Sector;

public interface SectorService {

    Sector findBySectorId(String sectorId);

    SuccessResult saveToDbWithName(String name);

}
