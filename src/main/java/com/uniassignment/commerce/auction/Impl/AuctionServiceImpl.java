package com.uniassignment.commerce.auction.Impl;

import com.uniassignment.commerce.auction.Auction;
import com.uniassignment.commerce.auction.AuctionRepository;
import com.uniassignment.commerce.auction.AuctionService;
import com.uniassignment.commerce.user.User;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService {

    private AuctionRepository auctionRepository;

    public AuctionServiceImpl(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @Override
    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
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
}
