package com.phillipklose.expensesregistry.expense.infrastructure.amqp.message

data class UserExpenseRegisteredEvent(
    val userId: Long,
    val amount: Double,
    val currency: String,
    val timestamp: Long
)