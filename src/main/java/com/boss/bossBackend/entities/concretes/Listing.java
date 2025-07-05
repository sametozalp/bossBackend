package com.boss.bossBackend.entities.concretes;

import com.boss.bossBackend.business.dtos.requests.CreateListingRequest;
import com.boss.bossBackend.entities.abstracts.BaseEntity;
import com.boss.bossBackend.entities.enums.ListingStatusEnum;
import com.boss.bossBackend.entities.enums.ListingTypeEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "listings")
public class Listing extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "published_by", nullable = false)
    private User publishedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "listing_type", nullable = false)
    private ListingTypeEnum listingType;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "min_amount", nullable = false)
    private BigDecimal minAmount;

    @Column(name = "max_amount", nullable = false)
    private BigDecimal maxAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ListingStatusEnum status = ListingStatusEnum.PUBLISHED;

    @Column(name = "reviewed_by")
    private User reviewedBy;

    @Column(name = "reviewed_at")
    private LocalDateTime reviewedAt;

    @ManyToOne
    @JoinColumn(name = "associated_technopark_id", nullable = false)
    private TechnoparkUser associatedTechnopark;

    public Listing() {

    }

    public Listing(CreateListingRequest request, User publishedBy, TechnoparkUser associatedTechnopark) {
        this.publishedBy = publishedBy;
        this.listingType = request.getListingType();
        this.title = request.getTitle();
        this.description = request.getDescription();
        this.minAmount = request.getMinAmount();
        this.maxAmount = request.getMaxAmount();
        this.associatedTechnopark = associatedTechnopark;
    }

    public TechnoparkUser getAssociatedTechnopark() {
        return associatedTechnopark;
    }

    public void setAssociatedTechnopark(TechnoparkUser associatedTechnopark) {
        this.associatedTechnopark = associatedTechnopark;
    }

    public User getPublishedBy() {
        return publishedBy;
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

    public ListingStatusEnum getStatus() {
        return status;
    }

    public User getReviewedBy() {
        return reviewedBy;
    }

    public LocalDateTime getReviewedAt() {
        return reviewedAt;
    }

    public void setPublishedBy(User publishedBy) {
        this.publishedBy = publishedBy;
    }

    public ListingTypeEnum getListingType() {
        return listingType;
    }

    public void setListingType(ListingTypeEnum listingType) {
        this.listingType = listingType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public void setStatus(ListingStatusEnum status) {
        this.status = status;
    }

    public void setReviewedBy(User reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public void setReviewedAt(LocalDateTime reviewedAt) {
        this.reviewedAt = reviewedAt;
    }
}
