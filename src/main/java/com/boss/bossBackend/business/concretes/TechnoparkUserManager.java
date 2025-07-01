package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.TechnoparkUserService;
import com.boss.bossBackend.business.abstracts.UserService;
import com.boss.bossBackend.business.dtos.requests.TechnoparkRegisterRequest;
import com.boss.bossBackend.dataAccess.abstracts.TechnoparkUserRepository;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.exception.userException.UserNotFoundException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TechnoparkUserManager implements TechnoparkUserService {

    private final TechnoparkUserRepository repository;
    private final UserService userService;

    public TechnoparkUserManager(TechnoparkUserRepository repository, @Lazy UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    @Override
    public TechnoparkUser findByUserId(String technoparkId) {
        return repository.findByUserId(technoparkId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public TechnoparkUser save(TechnoparkRegisterRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        User savedUser = userService.saveToDb(user);
        TechnoparkUser technoparkUser = new TechnoparkUser(request, savedUser);

        return repository.save(technoparkUser);
    }

    @Override
    public Optional<TechnoparkUser> findByUserIdOptional(String userId) {
        return repository.findByUserId(userId);
    }
}
