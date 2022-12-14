package com.uniassignment.commerce.auction;

import com.uniassignment.commerce.user.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auction")
public class AuctionController {

    private AuctionService auctionService;

    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @GetMapping("/all")
    public List<Auction> retrieveAllAuctions() {
        return auctionService.getAllAuctions();
    }

    @PostMapping("/create")
    public Auction createAuction(@RequestParam String title,
                                 @RequestParam BigDecimal initialBid,
                                 @RequestParam String description,
                                 @RequestParam String category,
                                 @RequestParam String pictureUrl,
                                 HttpSession session) {


        User user = (User) session.getAttribute("loggedUser");

        return auctionService.createAuction(title, initialBid, description, category, pictureUrl, user);
    }

    @GetMapping("/{id}")
    public Auction detailsAuction(@PathVariable Long id) {
        return auctionService.retrieveAuction(id);
    }

}
