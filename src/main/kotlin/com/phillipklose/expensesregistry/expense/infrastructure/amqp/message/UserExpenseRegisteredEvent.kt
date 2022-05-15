package com.phillipklose.expensesregistry.expense.infrastructure.amqp.message

data class UserExpenseRegisteredEvent(
    val userId: Int,
    val amount: Double,
    val currency: String,
    val category: String
)