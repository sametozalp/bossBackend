package com.boss.bossBackend.business.dtos.responses;

import com.boss.bossBackend.business.dtos.responses.userDetailResponse.UserDetailResponse;
import com.boss.bossBackend.entities.concretes.Listing;
import com.boss.bossBackend.entities.enums.ListingEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class GetListingResponse {

    private UserDetailResponse publishedBy;
    private String listingType;
    private String title;
    private String description;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private ListingEnum status;
    private UserDetailResponse reviewedBy;
    private LocalDateTime reviewedAt;

    public GetListingResponse() {

    }

    public GetListingResponse(Listing listing) {
        //this.publishedBy = listing.getPublishedBy() != null ? new CustomUserResponse(listing.getPublishedBy()) : null;
        this.listingType = listing.getListingType();
        this.title = listing.getTitle();
        this.description = listing.getDescription();
        this.minAmount = listing.getMinAmount();
        this.maxAmount = listing.getMaxAmount();
        this.status = listing.getStatus();
        this.reviewedBy = listing.getReviewedBy() != null ? new UserDetailResponse() : null;
        this.reviewedAt = listing.getReviewedAt();
    }

    public UserDetailResponse getPublishedBy() {
        return publishedBy;
    }

    public void setPublishedBy(UserDetailResponse publishedBy) {
        this.publishedBy = publishedBy;
    }

    public String getListingType() {
        return listingType;
    }

    public void setListingType(String listingType) {
        this.listingType = listingType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public ListingEnum getStatus() {
        return status;
    }

    public void setStatus(ListingEnum status) {
        this.status = status;
    }

    public UserDetailResponse getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(UserDetailResponse reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public LocalDateTime getReviewedAt() {
        return reviewedAt;
    }

    public void setReviewedAt(LocalDateTime reviewedAt) {
        this.reviewedAt = reviewedAt;
    }
}
