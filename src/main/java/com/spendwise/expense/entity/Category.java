package com.spendwise.expense.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Category {

    protected Category(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    public Category(String name) {
        this.name = name;
    }
}
