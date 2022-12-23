package com.uniassignment.commerce.auction;

import com.uniassignment.commerce.user.User;

import java.math.BigDecimal;
import java.util.List;

public interface AuctionService {
    List<Auction> getAllAuctions();

    Auction createAuction(String title, BigDecimal initialBid,
                          String description, String category,
                          String pictureUrl, User user);

    Auction retrieveAuction(Long id);
}
