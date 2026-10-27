package com.spendwise.expense.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Getter
public class Expense {

    protected Expense(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    private String description;

    @Column(nullable = false)
    private LocalDate spentAt;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


    @PrePersist
    protected void onCreate(){
        createdAt = Instant.now();
    }

    public Expense(BigDecimal amount, LocalDate spentAt, Category category) {
        this(amount, spentAt, null, category);
    }


    public Expense(BigDecimal amount, LocalDate spentAt, String description, Category category) {
        this.amount = amount;
        this.spentAt = spentAt;
        this.description = description;
        this.category = category;
    }
}
