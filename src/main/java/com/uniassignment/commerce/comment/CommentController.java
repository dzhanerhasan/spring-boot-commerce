package com.uniassignment.commerce.comment;

import com.uniassignment.commerce.auction.Auction;
import com.uniassignment.commerce.auction.AuctionService;
import com.uniassignment.commerce.user.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;
    private final AuctionService auctionService;

    public CommentController(CommentService commentService, AuctionService auctionService) {
        this.commentService = commentService;
        this.auctionService = auctionService;
    }

    @GetMapping("/{id}")
    public List<Comment> commentsOnAuction(@PathVariable Long id) {
        return commentService.retrieveComments(id);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<String> commentUser(@PathVariable Long id) {
        return commentService.getCommentUser(id);
    }

    @PostMapping("/create")
    public Comment createComment(@RequestParam Long auctionId,
                                 @RequestParam String comment,
                                 HttpSession session) {

        User user = (User) session.getAttribute("loggedUser");
        Auction auction = auctionService.retrieveAuction(auctionId);

        return commentService.createComment(comment, user, auction);
    }
}
