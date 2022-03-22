package com.phillipklose.expensesregistry.expense.model

interface Expense {
    fun getCategory(): String
    fun getAmount(): Double
    fun getDescription(): String
}
