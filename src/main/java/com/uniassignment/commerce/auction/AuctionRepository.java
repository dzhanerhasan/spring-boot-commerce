package com.uniassignment.commerce.auction;

import com.uniassignment.commerce.bid.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    List<Auction> findAllByActive(Boolean active);
    List<Auction> findAllByCategoryAndActive(String category, Boolean active);
}
