package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.ListingService;
import com.boss.bossBackend.business.abstracts.UserService;
import com.boss.bossBackend.business.dtos.requests.ListingSaveRequest;
import com.boss.bossBackend.business.dtos.responses.GetListingResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.common.utilities.results.SuccessDataResult;
import com.boss.bossBackend.dataAccess.abstracts.ListingRepository;
import com.boss.bossBackend.entities.concretes.Listing;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.exception.listingException.ListingNotFound;
import org.springframework.stereotype.Service;

@Service
public class ListingManager implements ListingService {

    private final ListingRepository repository;
    private final UserService userService;

    public ListingManager(ListingRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }
//
//    @Override
//    public DataResult<List<Listing>> findByPublishedBy(String userId) {
//        return new SuccessDataResult<>(repository.findByPublishedBy(request.getPublishedById()));
//    }

    @Override
    public DataResult<Listing> save(ListingSaveRequest request) {
        User publishedByUser = userService.getUser(request.getPublishedById());
        Listing listing = new Listing(request, publishedByUser);
        return new SuccessDataResult<>(repository.save(listing));
    }

    @Override
    public DataResult<GetListingResponse> getListing(String listingId) {
        Listing listing = repository.findById(listingId)
                .orElseThrow(() -> new ListingNotFound("Listing not found"));
        //User publishedBy = userService.getUser(listing.getPublishedBy().getId());
        GetListingResponse getListingResponse = new GetListingResponse(listing);

        return new SuccessDataResult<>(getListingResponse);
    }
}
