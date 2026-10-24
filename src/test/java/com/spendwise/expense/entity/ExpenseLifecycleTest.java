package com.spendwise.expense.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ExpenseLifecycleTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void createdAtIsSetWhenExpenseIsPersisted(){
        // Arrange
        Category category = new Category("Food");
        entityManager.persist(category);

        Expense expense = new Expense(
                new BigDecimal("12.50"),
                LocalDate.of(2026, 10, 24),
                category
        );

        // Act
        assertNull(expense.getCreatedAt());

        entityManager.persist(expense);
        entityManager.flush();
        entityManager.clear();

        Expense found = entityManager.find(Expense.class, expense.getId());
        assertNotNull(found.getCreatedAt());

        assertNotNull(expense.getCreatedAt());
    }
}
