package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.CorporateUserService;
import com.boss.bossBackend.business.abstracts.SectorService;
import com.boss.bossBackend.business.abstracts.UserService;
import com.boss.bossBackend.business.dtos.requests.CorporateUserCompleteProfileRequest;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.GetUserDetailResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.dataAccess.abstracts.CorporateUserRepository;
import com.boss.bossBackend.entities.concretes.CorporateUser;
import com.boss.bossBackend.entities.concretes.Sector;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.exception.userException.UserAlreadyExistException;
import com.boss.bossBackend.exception.userException.UserNotFoundException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CorporateUserManager implements CorporateUserService {

    private final CorporateUserRepository repository;
    private final UserService userService;
    private final SectorService sectorService;

    public CorporateUserManager(CorporateUserRepository repository, @Lazy UserService userService, SectorService sectorService) {
        this.repository = repository;
        this.userService = userService;
        this.sectorService = sectorService;
    }

    @Override
    public DataResult<GetUserDetailResponse> completeProfile(CorporateUserCompleteProfileRequest request) {

        controlForRegisterParameters(request);

        Sector sector = sectorService.findBySectorId(request.getSectorId());

        User user = userService.findById(request.getUserId());
        CorporateUser corporateUser = new CorporateUser(request, user, sector);

        repository.save(corporateUser);

        return userService.getUserDetails(request.getUserId());
    }

    @Override
    public CorporateUser findByUserId(String userId) {
        return repository.findByUserId(userId)
                .orElseThrow(() -> new UserNotFoundException("Corporate user not found"));
    }

    @Override
    public Optional<CorporateUser> findByUserIdOptional(String userId) {
        return repository.findByUserId(userId);
    }

    private void controlForRegisterParameters(CorporateUserCompleteProfileRequest request) {
        if (repository.existsByUserId(request.getUserId())) {
            throw new UserAlreadyExistException("User is already exist.");
        }
    }
}
