package com.uniassignment.commerce.auction.Impl;

import com.uniassignment.commerce.auction.Auction;
import com.uniassignment.commerce.auction.AuctionRepository;
import com.uniassignment.commerce.auction.AuctionService;
import com.uniassignment.commerce.bid.Bid;
import com.uniassignment.commerce.user.User;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService {
    private final AuctionRepository auctionRepository;

    public AuctionServiceImpl(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @Override
    public List<Auction> getAllAuctions() {
        return auctionRepository.findAllByActive(true);
    }

    @Override
    public Auction createAuction(String title,
                                 BigDecimal initialBid,
                                 String description,
                                 String category,
                                 String pictureUrl,
                                 User user) {

        if(pictureUrl.isEmpty()) {
            pictureUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/1024px-No_image_available.svg.png";
        }

        if(category.isEmpty()) {
            category = "Other";
        }

        Auction auction = new Auction(title, initialBid, description, category, pictureUrl, user);

        return auctionRepository.saveAndFlush(auction);
    }

    public Auction retrieveAuction(Long id) {

        return auctionRepository.findById(id).get();
    }

    @Override
    public Auction closeAuction(Long id) {
        // When a user closes an auction the highest bidder wins it, and the auction will show
        // on "Won Auctions" page of the winner.
        Auction auction = auctionRepository.findById(id).get();

        if(!auction.getBids().isEmpty()) {
            Bid highestBid = auction.getBids().get(auction.getBids().size() - 1);
            highestBid.setWinner(true);
        }

        auction.setActive(false);

        return auctionRepository.saveAndFlush(auction);
    }

    @Override
    public List<Auction> getCategoryAuctions(String category) {
        return auctionRepository.findAllByCategoryAndActive(category, true);
    }

}
