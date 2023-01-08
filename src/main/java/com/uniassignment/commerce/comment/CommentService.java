package com.uniassignment.commerce.comment;

import com.uniassignment.commerce.auction.Auction;
import com.uniassignment.commerce.user.User;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

public interface CommentService {
    List<Comment> retrieveComments(Long id);

    ResponseEntity<String> getCommentUser(Long id);

    Comment createComment(String comment, User user, Auction auction);
}
