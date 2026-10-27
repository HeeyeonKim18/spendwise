package com.spendwise.expense.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class ExpenseCreateRequest {

    @NotNull
    @DecimalMin(value = "0.01")
    private BigDecimal amount;

    private String description;

    @NotNull
    private LocalDate spentAt;

    @NotNull
    private Long categoryId;
}
