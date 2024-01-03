package com.engineerpro.first.helloworld.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "subtitle")
    private String subtitle;
    @Column(name = "description")

    private String description;
    @Column(name = "image")

    private String image;
    @Column(name = "is_free_ship")

    private boolean is_free_ship;
    @Column(name = "address")

    private String address;
    @Column(name = "open_date")
    private Date open_date;
    @OneToMany(mappedBy = "restaurant")
    private Set<RatingRestaurant> listRatingRestaurant;
    @OneToMany(mappedBy = "restaurant")
    private Set<Promotion> listPromotion;
    @OneToMany(mappedBy = "restaurant")
    private Set<Order> listOrder;
    @OneToMany(mappedBy = "restaurant")
    private Set<MenuRestaurant> listMenuRestaurant;

    public Set<MenuRestaurant> getListMenuRestaurant() {
        return listMenuRestaurant;
    }

    public void setListMenuRestaurant(Set<MenuRestaurant> listMenuRestaurant) {
        this.listMenuRestaurant = listMenuRestaurant;
    }

    public Set<Order> getListOrder() {
        return listOrder;
    }

    public void setListOrder(Set<Order> listOrder) {
        this.listOrder = listOrder;
    }

    public Set<RatingRestaurant> getListRatingRestaurant() {
        return listRatingRestaurant;
    }

    public void setListRatingRestaurant(Set<RatingRestaurant> listRatingRestaurant) {
        this.listRatingRestaurant = listRatingRestaurant;
    }

    public Set<Promotion> getListPromotion() {
        return listPromotion;
    }

    public void setListPromotion(Set<Promotion> listPromotion) {
        this.listPromotion = listPromotion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isIs_free_ship() {
        return is_free_ship;
    }

    public void setIs_free_ship(boolean is_free_ship) {
        this.is_free_ship = is_free_ship;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOpen_date() {
        return open_date;
    }

    public void setOpen_date(Date open_date) {
        this.open_date = open_date;
    }
}
