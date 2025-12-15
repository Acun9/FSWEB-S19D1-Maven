package com.workintech.s18d2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vegetable", schema = "fsweb")
public class Vegetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private boolean grownOnTree;

    public Vegetable() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isGrownOnTree() {
        return grownOnTree;
    }

    public void setGrownOnTree(boolean grownOnTree) {
        this.grownOnTree = grownOnTree;
    }
}

