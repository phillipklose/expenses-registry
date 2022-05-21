package com.phillipklose.expensesregistry.expense.infrastructure.mariadb

import com.phillipklose.expensesregistry.expense.domain.Expense
import com.phillipklose.expensesregistry.expense.domain.Expense.HistoricalExpense
import com.phillipklose.expensesregistry.expense.domain.Expense.NewlyRegisteredExpense
import com.phillipklose.expensesregistry.expense.domain.ExpenseId
import com.phillipklose.expensesregistry.expense.domain.Price
import com.phillipklose.expensesregistry.expense.domain.UserId
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "expenses")
class ExpenseDatabaseEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    var userId: Long,
    var amount: BigDecimal,
    var currency: String,
    var occurredAt: LocalDateTime
) {
    fun toDomainModel(): Expense {
        return when (id) {
            null -> toNewlyRegisteredExpense()
            else -> toHistoricalExpense()
        }
    }

    private fun toNewlyRegisteredExpense(): NewlyRegisteredExpense = NewlyRegisteredExpense(
        UserId(userId),
        Price(amount, Currency.getInstance(currency)),
        occurredAt
    )

    private fun toHistoricalExpense(): HistoricalExpense = HistoricalExpense(
        ExpenseId(id!!),
        UserId(userId),
        Price(amount, Currency.getInstance(currency)),
        occurredAt
    )

}
