package com.uniassignment.commerce.bid;

import com.uniassignment.commerce.auction.Auction;
import com.uniassignment.commerce.user.User;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "bids")
public class Bid implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal bid;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "auction_id", nullable = false)
    private Auction auction;

    private Boolean winner = false;

    public Bid() {
    }

    public Bid(BigDecimal bid, User user, Auction auction) {
        this.bid = bid;
        this.user = user;
        this.auction = auction;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal value) {
        this.bid = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Boolean getWinner() {
        return winner;
    }

    public void setWinner(Boolean winner) {
        this.winner = winner;
    }
}
