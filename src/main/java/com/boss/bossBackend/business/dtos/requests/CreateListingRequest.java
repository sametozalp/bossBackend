package com.boss.bossBackend.business.dtos.requests;

import com.boss.bossBackend.entities.enums.ListingTypeEnum;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class CreateListingRequest {

    @NotBlank(message = "Publisher ID cannot be blank")
    @NotNull(message = "Publisher ID cannot be null")
    private String publishedById;

    @NotNull(message = "Listing type cannot be null")
    private ListingTypeEnum listingType;

    @NotNull(message = "Title cannot be null")
    @NotBlank(message = "Title cannot be blank")
    @Size(max = 100, message = "Title must be at most 100 characters long")
    private String title;

    @NotNull(message = "Description cannot be null")
    @NotBlank(message = "Description cannot be blank")
    @Size(max = 1000, message = "Description must be at most 1000 characters long")
    private String description;

    @NotNull(message = "Minimum amount cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Minimum amount must be greater than 0") // inclusive: not included
    private BigDecimal minAmount;

    @NotNull(message = "Maximum amount cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Maximum amount must be greater than 0") // inclusive: not included
    private BigDecimal maxAmount;

    public String getPublishedById() {
        return publishedById;
    }

    public void setPublishedById(String publishedById) {
        this.publishedById = publishedById;
    }

    public ListingTypeEnum getListingType() {
        return listingType;
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
}
