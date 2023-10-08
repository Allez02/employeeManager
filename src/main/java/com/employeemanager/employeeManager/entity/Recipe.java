package com.employeemanager.employeeManager.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String product;

    private String cookingMethod;

    private String linkToPicture;

    @ManyToOne
    private User author;

    public Recipe() {

    }

    public Recipe(String name, String product, String cookingMethod, String linkToPicture, User author) {
        this.name = name;
        this.product = product;
        this.cookingMethod = cookingMethod;
        this.linkToPicture = linkToPicture;
        this.author = author;
    }
}
