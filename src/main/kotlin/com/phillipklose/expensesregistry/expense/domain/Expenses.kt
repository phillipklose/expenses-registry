package com.phillipklose.expensesregistry.expense.domain

interface Expenses {
    fun findAllExpenses(): List<Expense>
    fun save(expense: Expense)
}