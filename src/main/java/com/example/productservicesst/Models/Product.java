package com.example.productservicesst.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Double price;
    private String imageUrl;
    private String description;
    @ManyToOne
    private Category category;

}