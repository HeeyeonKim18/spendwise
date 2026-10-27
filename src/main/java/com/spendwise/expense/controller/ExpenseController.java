package com.spendwise.expense.controller;

import com.spendwise.expense.dto.ExpenseCreateRequest;
import com.spendwise.expense.dto.ExpenseResponse;
import com.spendwise.expense.entity.Expense;
import com.spendwise.expense.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/api/expenses")
    public ResponseEntity<ExpenseResponse> createExpense(
            @Valid @RequestBody ExpenseCreateRequest req
    ) {
        Expense expense = expenseService.createExpense(req);
        ExpenseResponse res = ExpenseResponse.from(expense);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

}
