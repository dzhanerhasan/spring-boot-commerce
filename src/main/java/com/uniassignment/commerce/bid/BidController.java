package com.uniassignment.commerce.bid;

import com.uniassignment.commerce.auction.Auction;
import com.uniassignment.commerce.auction.AuctionService;
import com.uniassignment.commerce.user.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/bid")
public class BidController {
    private final BidService bidService;
    private final AuctionService auctionService;

    public BidController(BidService bidService, AuctionService auctionService) {
        this.bidService = bidService;
        this.auctionService = auctionService;
    }

    @PostMapping("/create")
    public Boolean createBid(@RequestParam Long auctionId,
                            @RequestParam BigDecimal bidValue,
                            HttpSession session) {

        User user = (User) session.getAttribute("loggedUser");
        Auction auction = auctionService.retrieveAuction(auctionId);

        return bidService.createBid(bidValue, user, auction);
    }
}
