package com.boss.bossBackend.business.dtos.responses.userDetailResponse;

import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.entities.concretes.UserRole;
import com.boss.bossBackend.entities.enums.RoleEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class UserDetailResponse {
    private String id;
    private String username;
    private String email;
    private String accessToken;
    private String refreshToken;
    private List<String> roles;
    private LocalDateTime createdAt;
    private CorporateUserDetailResponse corporateUser;
    private IndividualUserDetailResponse individualUser;
    private TechnoParkUserDetailResponse technoParkUser;

    public UserDetailResponse() {

    }

    public UserDetailResponse(CorporateUserDetailResponse corporateUser) {
        this.corporateUser = corporateUser;
        this.createdAt = corporateUser.getCreatedAt();
    }

    public UserDetailResponse(IndividualUserDetailResponse individualUser) {
        this.individualUser = individualUser;
        this.createdAt = individualUser.getCreatedAt();
    }

    public UserDetailResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        //this.roles = user.getUserRoles();
        this.createdAt = user.getCreatedAt();

        this.roles = new ArrayList<>();
        for (UserRole userRole: user.getUserRoles()) {
            this.roles.add(userRole.getRole().getAuthority());
        }
    }

    public UserDetailResponse(User user, CorporateUserDetailResponse corporateUser, IndividualUserDetailResponse individualUser, TechnoParkUserDetailResponse technoParkUser) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.individualUser = individualUser;
        this.corporateUser = corporateUser;
        this.technoParkUser = technoParkUser;
        //this.roles = user.getUserRoles();
        this.createdAt = user.getCreatedAt();

        this.roles = new ArrayList<>();
        for (UserRole userRole: user.getUserRoles()) {
            this.roles.add(userRole.getRole().getAuthority());
        }
    }

    public UserDetailResponse(User user, CorporateUserDetailResponse corporateUser, IndividualUserDetailResponse individualUser, TechnoParkUserDetailResponse technoParkUser, String accessToken, String refreshToken) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.individualUser = individualUser;
        this.corporateUser = corporateUser;
        this.technoParkUser = technoParkUser;
        //this.roles = user.getUserRoles();
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;

        this.roles = new ArrayList<>();
        for (UserRole userRole: user.getUserRoles()) {
            this.roles.add(userRole.getRole().getAuthority());
        }

    }
}
