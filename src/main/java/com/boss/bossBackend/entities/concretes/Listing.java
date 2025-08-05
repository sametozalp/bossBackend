package com.boss.bossBackend.entities.concretes;

import com.boss.bossBackend.business.dtos.requests.CreateListingRequest;
import com.boss.bossBackend.entities.abstracts.BaseEntity;
import com.boss.bossBackend.entities.enums.ListingTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "listings")
@Getter
@Setter
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
}
