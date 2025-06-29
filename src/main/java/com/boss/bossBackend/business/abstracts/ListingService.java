package com.boss.bossBackend.business.abstracts;

import com.boss.bossBackend.business.dtos.requests.ListingSaveRequest;
import com.boss.bossBackend.business.dtos.responses.GetListingResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.common.utilities.results.Result;
import com.boss.bossBackend.entities.concretes.Listing;

import java.util.List;

public interface ListingService {

    DataResult<Listing> save(ListingSaveRequest request);

    DataResult<GetListingResponse> getListing(String listingId);

}
