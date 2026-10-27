package com.spendwise.expense.service;

import com.spendwise.expense.dto.ExpenseCreateRequest;
import com.spendwise.expense.entity.Category;
import com.spendwise.expense.entity.Expense;
import com.spendwise.expense.repository.CategoryRepository;
import com.spendwise.expense.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public Expense createExpense(ExpenseCreateRequest req){
        Long categoryId = req.getCategoryId();
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new IllegalArgumentException("Category not found")
                );

        Expense expense = new Expense(req.getAmount(), req.getSpentAt(), req.getDescription(), category);

        return expenseRepository.save(expense);
    }
}
