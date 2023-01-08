package com.uniassignment.commerce.comment.Impl;

import com.uniassignment.commerce.auction.Auction;
import com.uniassignment.commerce.comment.Comment;
import com.uniassignment.commerce.comment.CommentRepository;
import com.uniassignment.commerce.comment.CommentService;
import com.uniassignment.commerce.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> retrieveComments(Long id) {
        return commentRepository.findAllByAuctionId(id);
    }

    @Override
    public ResponseEntity<String> getCommentUser(Long id) {
        Comment comment = commentRepository.findById(id).get();
        return new ResponseEntity<>(comment.getUser().getUsername(), HttpStatus.OK);
    }

    @Override
    public Comment createComment(String comment, User user, Auction auction) {

        Comment newComment = new Comment(comment, user, auction);

        return commentRepository.saveAndFlush(newComment);
    }
}
