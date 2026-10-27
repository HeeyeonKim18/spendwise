package com.spendwise.expense.dto;

import com.spendwise.expense.entity.Expense;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class ExpenseResponse {

    private Long id;
    private BigDecimal amount;
    private String description;
    private LocalDate spentAt;
    private Long categoryId;
    private Instant createdAt;

    public static ExpenseResponse from(Expense expense) {
        return new ExpenseResponse(
                expense.getId(),
                expense.getAmount(),
                expense.getDescription(),
                expense.getSpentAt(),
                expense.getCategory().getId(),
                expense.getCreatedAt()
        );
    }
}
