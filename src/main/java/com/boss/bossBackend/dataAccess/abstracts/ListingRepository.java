package com.boss.bossBackend.dataAccess.abstracts;

import com.boss.bossBackend.entities.concretes.Listing;
import com.boss.bossBackend.entities.concretes.User;
import com.boss.bossBackend.entities.enums.ListingTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListingRepository extends JpaRepository<Listing, String> {

    List<Listing> findByPublishedByAndListingType(User publishedBy, ListingTypeEnum listingTypeEnum);

    List<Listing> findByListingType(ListingTypeEnum listingTypeEnum);

    List<Listing> findByAssociatedTechnoparkIdAndListingType(String associatedTechnoparkId, ListingTypeEnum listingTypeEnum);

}
