package com.phillipklose.expensesregistry.expense.domain

interface Expenses {
    fun findAllUserExpensesPaginated(userId: UserId, pageNumber: Int): List<Expense>
    fun save(expense: Expense)
}