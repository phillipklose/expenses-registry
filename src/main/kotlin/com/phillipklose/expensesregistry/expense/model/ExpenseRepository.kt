package com.phillipklose.expensesregistry.expense.model

interface ExpenseRepository {
    fun findAllExpenses(): List<Expense>
}