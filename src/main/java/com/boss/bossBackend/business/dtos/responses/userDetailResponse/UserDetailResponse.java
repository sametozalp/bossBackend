package com.boss.bossBackend.business.dtos.responses.userDetailResponse;

import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.entities.concretes.UserRole;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetailResponse {
    private String id;
    private String username;
    private String email;
    private String accessToken;
    private String refreshToken;
    private List<UserRole> roles;
    private LocalDateTime createdAt;
    private CorporateUserDetailResponse corporateUser;
    private IndividualUserDetailResponse individualUser;
    private TechnoParkUserDetailResponse technoParkUser;


    public UserDetailResponse() {

    }

    public UserDetailResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.roles = user.getUserRoles();
        this.createdAt = user.getCreatedAt();
    }

    public UserDetailResponse(User user, CorporateUserDetailResponse corporateUser, IndividualUserDetailResponse individualUser, TechnoParkUserDetailResponse technoParkUser) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.individualUser = individualUser;
        this.corporateUser = corporateUser;
        this.technoParkUser = technoParkUser;
        this.roles = user.getUserRoles();
        this.createdAt = user.getCreatedAt();
    }

    public UserDetailResponse(User user, CorporateUserDetailResponse corporateUser, IndividualUserDetailResponse individualUser, TechnoParkUserDetailResponse technoParkUser, String accessToken, String refreshToken) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.individualUser = individualUser;
        this.corporateUser = corporateUser;
        this.technoParkUser = technoParkUser;
        this.roles = user.getUserRoles();
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public CorporateUserDetailResponse getCorporateUser() {
        return corporateUser;
    }

    public void setCorporateUser(CorporateUserDetailResponse corporateUser) {
        this.corporateUser = corporateUser;
    }

    public IndividualUserDetailResponse getIndividualUser() {
        return individualUser;
    }

    public void setIndividualUser(IndividualUserDetailResponse individualUser) {
        this.individualUser = individualUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TechnoParkUserDetailResponse getTechnoParkUser() {
        return technoParkUser;
    }

    public void setTechnoParkUser(TechnoParkUserDetailResponse technoParkUser) {
        this.technoParkUser = technoParkUser;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
