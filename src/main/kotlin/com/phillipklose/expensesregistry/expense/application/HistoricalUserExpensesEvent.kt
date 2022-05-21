package com.phillipklose.expensesregistry.expense.application

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

class HistoricalUserExpensesEvent(
    val userId: Long,
    val expenses: List<Expense>
) {
    class Expense(
        val expenseId: Long?,
        val amount: BigDecimal,
        val currency: Currency,
        val date: LocalDateTime
    ) {
        constructor(amount: BigDecimal, currency: Currency, date: LocalDateTime) : this(null, amount, currency, date)
    }
}
