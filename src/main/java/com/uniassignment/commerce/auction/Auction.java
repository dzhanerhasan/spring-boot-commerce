package com.uniassignment.commerce.auction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uniassignment.commerce.bid.Bid;
import com.uniassignment.commerce.user.User;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "auctions")
public class Auction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32, nullable = false)
    private String title;
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal initialBid;
    private String description;
    private String category;
    private String picture;
    private Boolean active = true;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auction")
    @JsonIgnore
    private Set<Bid> bids;

    public Auction() {

    }
    public Auction(String title, BigDecimal initialBid, String description, String category, String picture, User user) {
        this.title = title;
        this.initialBid = initialBid;
        this.description = description;
        this.category = category;
        this.picture = picture;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getInitialBid() {
        return initialBid;
    }

    public void setInitialBid(BigDecimal initial_bid) {
        this.initialBid = initial_bid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", initial_bid=" + initialBid +
                '}';
    }
}
