package com.phillipklose.expensesregistry.expense.application

import com.phillipklose.expensesregistry.expense.application.HistoricalUserExpensesEvent.Expense
import com.phillipklose.expensesregistry.expense.domain.Expense.HistoricalExpense
import com.phillipklose.expensesregistry.expense.domain.Expense.NewlyRegisteredExpense
import com.phillipklose.expensesregistry.expense.domain.Expenses
import com.phillipklose.expensesregistry.expense.domain.UserId
import org.springframework.stereotype.Component

@Component
class HistoricalExpense(private val expenses: Expenses) {

    fun getHistoricalUserExpenses(userId: UserId, page: Int) = expenses.findAllUserExpensesPaginated(userId, page)
        .map {
            when (it) {
                is HistoricalExpense -> Expense(it.expenseId.id, it.price.amount, it.price.currency, it.occurredAt)
                is NewlyRegisteredExpense -> Expense(it.price.amount, it.price.currency, it.occurredAt)
            }
        }.let { HistoricalUserExpensesEvent(userId.id, it) }
}