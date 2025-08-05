package com.boss.bossBackend.business.dtos.requests;

import com.boss.bossBackend.entities.enums.ListingTypeEnum;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
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
}
