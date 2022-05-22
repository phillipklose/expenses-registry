package com.phillipklose.expensesregistry.expense.domain

interface ExpensesStatistics {
    fun findUserExpensesCount(userId: UserId): Statistics
}