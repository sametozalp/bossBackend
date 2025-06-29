package com.boss.bossBackend.entities.concretes;

import com.boss.bossBackend.business.dtos.requests.ListingSaveRequest;
import com.boss.bossBackend.entities.abstracts.BaseEntity;
import com.boss.bossBackend.entities.enums.ListingEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "listings")
public class Listing extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "published_by", nullable = false)
    private User publishedBy;

    @Column(name = "listing_type", nullable = false)
    private String listingType;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "min_amount", nullable = false)
    private BigDecimal minAmount;

    @Column(name = "max_amount", nullable = false)
    private BigDecimal maxAmount;

    @Column(name = "status", nullable = false)
    private ListingEnum status = ListingEnum.WAITING;

    @Column(name = "reviewed_by")
    private User reviewedBy;

    @Column(name = "reviewed_at")
    private LocalDateTime reviewedAt;

    public Listing() {

    }

    public Listing(ListingSaveRequest request, User publishedBy) {
        this.publishedBy = publishedBy;
        this.listingType = request.getListingType();
        this.title = request.getTitle();
        this.description = request.getDescription();
        this.minAmount = request.getMinAmount();
        this.maxAmount = request.getMaxAmount();
    }

    public User getPublishedBy() {
        return publishedBy;
    }

    public String getListingType() {
        return listingType;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public ListingEnum getStatus() {
        return status;
    }

    public User getReviewedBy() {
        return reviewedBy;
    }

    public LocalDateTime getReviewedAt() {
        return reviewedAt;
    }
}
