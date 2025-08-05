package com.boss.bossBackend.business.dtos.responses;

import com.boss.bossBackend.business.dtos.responses.userDetailResponse.FullUserDetailResponse;
import com.boss.bossBackend.entities.concretes.Listing;
import com.boss.bossBackend.entities.enums.ApprovalStatusEnum;
import com.boss.bossBackend.entities.enums.ListingTypeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class GetListingResponse {

    private String id;
    private FullUserDetailResponse publishedBy;
    private ListingTypeEnum listingType;
    private String title;
    private String description;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private ApprovalStatusEnum status;
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
        this.reviewedBy = listing.getReviewedBy() != null ? new FullUserDetailResponse() : null;
        this.reviewedAt = listing.getReviewedAt();
    }
}
