package com.uniassignment.commerce.bid;

import com.uniassignment.commerce.auction.Auction;
import com.uniassignment.commerce.user.User;

import java.math.BigDecimal;

public interface BidService {
    Bid createBid(BigDecimal value, User user, Auction auction);
}
