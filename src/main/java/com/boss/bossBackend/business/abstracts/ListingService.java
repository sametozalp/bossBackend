package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.CreateListingRequest;
import com.boss.bossBackend.business.dtos.responses.GetListingResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.entities.concretes.Listing;
import com.boss.bossBackend.entities.enums.ListingTypeEnum;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ListingService {

    DataResult<GetListingResponse> saveToDatabase(CreateListingRequest request);

    DataResult<GetListingResponse> getListing(String listingId);

    DataResult<List<GetListingResponse>> getListings(String userId, ListingTypeEnum listingTypeEnum);

    DataResult<List<GetListingResponse>> getAllListings(ListingTypeEnum listingTypeEnum);

    DataResult<List<GetListingResponse>> getAllListingsForTechnopark(String technoparkId, ListingTypeEnum listingTypeEnum);
}
