package com.phillipklose.expensesregistry.expense.model

data class BusinessExpense(val expenseAmount: Double): Expense {
    override fun getCategory(): String {
        return "BUSINESS"
    }

    override fun getAmount(): Double {
        return expenseAmount
    }

    override fun getDescription(): String {
        return "This expense is related to business expenses"
    }
}
