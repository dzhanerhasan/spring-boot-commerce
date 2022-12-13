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
    private String picture =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/1024px-No_image_available.svg.png";
    private Boolean active = false;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Auction() {

    }
    public Auction(String title, Double initial_bid, String description, String category, String picture, Boolean active, User user) {
        this.title = title;
        this.initial_bid = initial_bid;
        this.description = description;
        this.category = category;
        this.picture = picture;
        this.active = active;
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

    public Double getInitial_bid() {
        return initial_bid;
    }

    public void setInitial_bid(Double initial_bid) {
        this.initial_bid = initial_bid;
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

    @Override
    public String toString() {
        return "Auction{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", initial_bid=" + initial_bid +
                '}';
    }
}
