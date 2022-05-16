package com.phillipklose.expensesregistry.expense.infrastructure.mariadb

import com.phillipklose.expensesregistry.expense.domain.Expense
import com.phillipklose.expensesregistry.expense.domain.Expenses
import org.springframework.stereotype.Component

@Component
class ExpenseDatabaseRepository(private val repository: ExpenseCrudRepository) : Expenses {

    override fun findAllExpenses(): List<Expense> {
        TODO("Not yet implemented")
    }

    override fun save(expense: Expense) {
        when (expense) {
            is Expense.NewlyRegisteredExpense -> expense.toEntity()
            is Expense.HistoricalExpense -> expense.toEntity()
        }.let { repository.save(it) }
    }

    private fun Expense.NewlyRegisteredExpense.toEntity(): ExpenseDatabaseEntity = ExpenseDatabaseEntity(
        id = null,
        userId = userId().userId,
        amount = price().amount,
        currency = price().currency.toString(),
        occurredAt = occurredAt()
    )

    private fun Expense.HistoricalExpense.toEntity(): ExpenseDatabaseEntity = ExpenseDatabaseEntity(
        id = expenseId().expenseId,
        userId = userId().userId,
        amount = price().amount,
        currency = price().currency.toString(),
        occurredAt = occurredAt()
    )
}