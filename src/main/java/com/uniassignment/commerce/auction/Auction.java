package com.uniassignment.commerce.auction;

import com.uniassignment.commerce.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "auctions")
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32)
    private String title;
    @Column(precision = 10, scale = 2)
    private Double initial_bid;
    private String description;
    private String category;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
