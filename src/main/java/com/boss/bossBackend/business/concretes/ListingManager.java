package com.boss.bossBackend.business.concretes;

import com.boss.bossBackend.business.abstracts.ListingService;
import com.boss.bossBackend.business.abstracts.TechnoparkUserService;
import com.boss.bossBackend.business.abstracts.UserService;
import com.boss.bossBackend.business.dtos.requests.CreateListingRequest;
import com.boss.bossBackend.business.dtos.responses.GetListingResponse;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.FullUserDetailResponse;
import com.boss.bossBackend.business.dtos.responses.userDetailResponse.UserDetailResponse;
import com.boss.bossBackend.common.utilities.results.DataResult;
import com.boss.bossBackend.common.utilities.results.SuccessDataResult;
import com.boss.bossBackend.dataAccess.abstracts.ListingRepository;
import com.boss.bossBackend.entities.concretes.Listing;
import com.boss.bossBackend.entities.concretes.TechnoparkUser;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.entities.enums.ListingTypeEnum;
import com.boss.bossBackend.exception.listingException.ListingNotFound;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListingManager implements ListingService {

    private final ListingRepository repository;
    private final UserService userService;
    private final TechnoparkUserService technoparkUserService;

    public ListingManager(ListingRepository repository, UserService userService, TechnoparkUserService technoparkUserService) {
        this.repository = repository;
        this.userService = userService;
        this.technoparkUserService = technoparkUserService;
    }
//
//    @Override
//    public DataResult<List<Listing>> findByPublishedBy(String userId) {
//        return new SuccessDataResult<>(repository.findByPublishedBy(request.getPublishedById()));
//    }

    @Transactional
    @Override
    public DataResult<GetListingResponse> saveToDatabase(CreateListingRequest request) {
        User publishedByUser = userService.findById(request.getPublishedById());
        TechnoparkUser associateTechnopark = userService.findByAssociateTechnoparkUser(publishedByUser);
        Listing listing = new Listing(request, publishedByUser, associateTechnopark);
        repository.save(listing);
        FullUserDetailResponse fullUserDetailResponse = new FullUserDetailResponse(new UserDetailResponse(publishedByUser));
        return new SuccessDataResult<>(new GetListingResponse(listing, fullUserDetailResponse));
    }

    @Transactional
    @Override
    public DataResult<GetListingResponse> getListing(String listingId) {
        Listing listing = repository.findById(listingId)
                .orElseThrow(() -> new ListingNotFound("Listing not found"));
        FullUserDetailResponse fullUserDetailResponse =
                new FullUserDetailResponse(new UserDetailResponse(listing.getPublishedBy()));
        return new SuccessDataResult<>(new GetListingResponse(listing, fullUserDetailResponse));
    }

    @Override
    public DataResult<List<GetListingResponse>> getListings(String userId, ListingTypeEnum listingTypeEnum) {
        User publishedBy = userService.findById(userId);
        List<Listing> listings = repository.findByPublishedByAndListingType(publishedBy, listingTypeEnum);
        List<GetListingResponse> listingResponses = new ArrayList<>();
        for (Listing listing : listings) {
            listingResponses.add(new GetListingResponse(listing, new FullUserDetailResponse(new UserDetailResponse(listing.getPublishedBy()))));
        }
        return new SuccessDataResult<>(listingResponses);
    }

    @Override
    public DataResult<List<GetListingResponse>> getAllListings(ListingTypeEnum listingTypeEnum) {
        List<Listing> listings = repository.findByListingType(listingTypeEnum);
        List<GetListingResponse> listingResponses = new ArrayList<>();
        for (Listing listing : listings) {
            listingResponses.add(new GetListingResponse(listing, new FullUserDetailResponse(new UserDetailResponse(listing.getPublishedBy()))));
        }
        return new SuccessDataResult<>(listingResponses);
    }

    @Override
    public DataResult<List<GetListingResponse>> getAllListingsForTechnopark(String technoparkId, ListingTypeEnum listingTypeEnum) {
        List<Listing> listings = repository.findByAssociatedTechnoparkIdAndListingType(technoparkId, listingTypeEnum);
        List<GetListingResponse> listingResponses = new ArrayList<>();
        for (Listing listing : listings) {
            listingResponses.add(new GetListingResponse(listing, new FullUserDetailResponse(new UserDetailResponse(listing.getPublishedBy()))));
        }
        return new SuccessDataResult<>(listingResponses);
    }
}
