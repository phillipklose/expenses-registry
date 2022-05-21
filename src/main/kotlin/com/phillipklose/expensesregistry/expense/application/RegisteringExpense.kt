package com.phillipklose.expensesregistry.expense.application

import com.phillipklose.expensesregistry.expense.domain.Expense.NewlyRegisteredExpense
import com.phillipklose.expensesregistry.expense.domain.Expenses
import com.phillipklose.expensesregistry.expense.domain.Price
import org.springframework.stereotype.Component

@Component
class RegisteringExpense(private val expenses: Expenses) {

    fun registerExpense(command: RegisteredExpenseCommand) {
        expenses.save(command.asExpense())
        // TODO() Check if new expense will exceed the limit for day/week/month etc. If so then send an event.
    }

    private fun RegisteredExpenseCommand.asExpense(): NewlyRegisteredExpense = with(this) {
        NewlyRegisteredExpense(
            userId = userId,
            price = Price(amount, currency),
            occurredAt = registeredAt
        )
    }

}