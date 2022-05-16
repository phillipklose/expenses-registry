package com.phillipklose.expensesregistry.expense.domain

import java.time.LocalDateTime

sealed interface Expense {
    fun userId(): UserId
    fun price(): Price
    fun occurredAt(): LocalDateTime

    data class NewlyRegisteredExpense(val userId: UserId, val price: Price, val occurredAt: LocalDateTime) : Expense {
        override fun userId(): UserId = userId
        override fun price(): Price = price
        override fun occurredAt(): LocalDateTime = occurredAt
    }

    data class HistoricalExpense(val expenseId: ExpenseId, val userId: UserId, val price: Price, val occurredAt: LocalDateTime) : Expense {
        fun expenseId(): ExpenseId = expenseId
        override fun userId(): UserId = userId
        override fun price(): Price = price
        override fun occurredAt(): LocalDateTime = occurredAt
    }
}
