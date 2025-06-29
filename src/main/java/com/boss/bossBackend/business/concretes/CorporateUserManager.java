package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.CorporateUserService;
import com.boss.bossBackend.business.abstracts.SectorService;
import com.boss.bossBackend.business.abstracts.UserService;
import com.boss.bossBackend.business.dtos.requests.CorporateUserCompleteProfileRequest;
import com.boss.bossBackend.common.utilities.results.SuccessResult;
import com.boss.bossBackend.dataAccess.abstracts.CorporateUserRepository;
import com.boss.bossBackend.entities.concretes.CorporateUser;
import com.boss.bossBackend.entities.concretes.Sector;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.exception.userException.UserAlreadyExistException;
import org.springframework.stereotype.Service;

@Service
public class CorporateUserManager implements CorporateUserService {

    private final CorporateUserRepository repository;
    private final UserService userService;
    private final SectorService sectorService;

    public CorporateUserManager(CorporateUserRepository repository, UserService userService, SectorService sectorService) {
        this.repository = repository;
        this.userService = userService;
        this.sectorService = sectorService;
    }

    @Override
    public SuccessResult completeProfile(CorporateUserCompleteProfileRequest request) {

        controlForRegisterParameters(request);

        Sector sector = sectorService.findBySectorId(request.getSectorId());

        User user = userService.getUser(request.getUserId());
        CorporateUser corporateUser = new CorporateUser(request, user, sector);

        repository.save(corporateUser);

        return new SuccessResult();
    }

    private void controlForRegisterParameters(CorporateUserCompleteProfileRequest request) {
        if (repository.existsByUserId(request.getUserId())) {
            throw new UserAlreadyExistException("User is already exist.");
        }
    }
}
