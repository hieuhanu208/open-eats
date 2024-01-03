package com.engineerpro.first.helloworld.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_category")
    private String name_category;
    @Column(name = "created_at")
    private Date created_at;
    @OneToMany(mappedBy = "category")
    private Set<Food> listFood;

    public Set<Food> getListFood() {
        return listFood;
    }

    public void setListFood(Set<Food> listFood) {
        this.listFood = listFood;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
