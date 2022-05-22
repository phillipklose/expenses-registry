package com.phillipklose.expensesregistry.expense.application

import com.phillipklose.expensesregistry.expense.domain.ExpensesStatistics
import org.springframework.stereotype.Component

@Component
class ExpenseStatistics(private val statistics: ExpensesStatistics) {

    fun getUserExpensesCount(query: UserExpensesCountQuery): UserExpensesCount {
        val userId = query.userId
        return statistics.findUserExpensesCount(userId).let { UserExpensesCount(userId.id, it.allExpensesCount) }
    }
}