package com.uniassignment.commerce.bid.Impl;

import com.uniassignment.commerce.auction.Auction;
import com.uniassignment.commerce.bid.Bid;
import com.uniassignment.commerce.bid.BidRepository;
import com.uniassignment.commerce.bid.BidService;
import com.uniassignment.commerce.user.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BidServiceImpl implements BidService {
    BidRepository bidRepository;

    public BidServiceImpl(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    @Override
    public Bid createBid(BigDecimal value, User user, Auction auction) {

        Bid bid = new Bid(value, user, auction);

        return bidRepository.saveAndFlush(bid);
    }
}
