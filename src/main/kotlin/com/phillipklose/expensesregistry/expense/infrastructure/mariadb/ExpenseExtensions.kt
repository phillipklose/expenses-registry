package com.phillipklose.expensesregistry.expense.infrastructure.mariadb

import com.phillipklose.expensesregistry.expense.domain.Expense.HistoricalExpense
import com.phillipklose.expensesregistry.expense.domain.Expense.NewlyRegisteredExpense

fun NewlyRegisteredExpense.toEntity(): ExpenseDatabaseEntity = ExpenseDatabaseEntity(
    id = null,
    userId = userId().id,
    amount = price().amount,
    currency = price().currency.toString(),
    occurredAt = occurredAt()
)

fun HistoricalExpense.toEntity(): ExpenseDatabaseEntity = ExpenseDatabaseEntity(
    id = expenseId().id,
    userId = userId().id,
    amount = price().amount,
    currency = price().currency.toString(),
    occurredAt = occurredAt()
)