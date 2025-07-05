package com.boss.bossBackend.business.dtos.responses;

import com.boss.bossBackend.business.dtos.responses.userDetailResponse.FullUserDetailResponse;
import com.boss.bossBackend.entities.concretes.Listing;
import com.boss.bossBackend.entities.enums.ListingStatusEnum;
import com.boss.bossBackend.entities.enums.ListingTypeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetListingResponse {

    private String id;
    private FullUserDetailResponse publishedBy;
    private ListingTypeEnum listingType;
    private String title;
    private String description;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private ListingStatusEnum status;
    private FullUserDetailResponse reviewedBy;
    private LocalDateTime reviewedAt;

    public GetListingResponse() {

    }

    public GetListingResponse(Listing listing) {
        this.id = listing.getId();
        this.listingType = listing.getListingType();
        this.title = listing.getTitle();
        this.description = listing.getDescription();
        this.minAmount = listing.getMinAmount();
        this.maxAmount = listing.getMaxAmount();
        this.status = listing.getStatus();
        this.reviewedBy = listing.getReviewedBy() != null ? new FullUserDetailResponse() : null;
        this.reviewedAt = listing.getReviewedAt();
    }

    public GetListingResponse(Listing listing, FullUserDetailResponse fullUserDetailResponse) {
        this.id = listing.getId();
        this.publishedBy = fullUserDetailResponse;
        this.listingType = listing.getListingType();
        this.title = listing.getTitle();
        this.description = listing.getDescription();
        this.minAmount = listing.getMinAmount();
        this.maxAmount = listing.getMaxAmount();
        this.status = listing.getStatus();
        this.reviewedBy = listing.getReviewedBy() != null ? new FullUserDetailResponse() : null;
        this.reviewedAt = listing.getReviewedAt();
    }

    public ListingTypeEnum getListingType() {
        return listingType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setListingType(ListingTypeEnum listingType) {
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

    public ListingStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ListingStatusEnum status) {
        this.status = status;
    }

    public FullUserDetailResponse getPublishedBy() {
        return publishedBy;
    }

    public void setPublishedBy(FullUserDetailResponse publishedBy) {
        this.publishedBy = publishedBy;
    }

    public FullUserDetailResponse getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(FullUserDetailResponse reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public LocalDateTime getReviewedAt() {
        return reviewedAt;
    }

    public void setReviewedAt(LocalDateTime reviewedAt) {
        this.reviewedAt = reviewedAt;
    }
}
