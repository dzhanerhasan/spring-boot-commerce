package com.uniassignment.commerce.bid;

import com.uniassignment.commerce.auction.Auction;
import com.uniassignment.commerce.user.User;

import java.math.BigDecimal;
import java.util.List;

public interface BidService {
    Boolean createBid(BigDecimal value, User user, Auction auction);

    List<Auction> retrieveWonAuctions(User user);
}
