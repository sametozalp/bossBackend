package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.CreateListingRequest;
import com.boss.bossBackend.business.dtos.responses.GetListingResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.entities.concretes.Listing;

public interface ListingService {

    DataResult<GetListingResponse> saveToDatabase(CreateListingRequest request);

    DataResult<GetListingResponse> getListing(String listingId);

}
