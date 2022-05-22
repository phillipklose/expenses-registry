package com.phillipklose.expensesregistry.expense.infrastructure.rest

import com.phillipklose.expensesregistry.expense.application.ExpenseStatistics
import com.phillipklose.expensesregistry.expense.application.UserExpensesCount
import com.phillipklose.expensesregistry.expense.application.UserExpensesCountQuery
import com.phillipklose.expensesregistry.expense.domain.UserId
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/rest/v1/statistics/user/{userId}/expenses")
class ExpensesStatisticsController(private val statistics: ExpenseStatistics) {

    @GetMapping("/count")
    fun getUserExpensesCount(@PathVariable userId: Long): UserExpensesCount = statistics.getUserExpensesCount(UserExpensesCountQuery(UserId(userId)))
}