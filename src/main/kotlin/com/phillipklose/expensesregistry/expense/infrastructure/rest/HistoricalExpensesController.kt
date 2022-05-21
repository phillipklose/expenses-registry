package com.phillipklose.expensesregistry.expense.infrastructure.rest

import com.phillipklose.expensesregistry.expense.application.HistoricalExpense
import com.phillipklose.expensesregistry.expense.application.HistoricalUserExpensesEvent
import com.phillipklose.expensesregistry.expense.domain.UserId
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/rest/v1/historical/user/{userId}/expenses")
class HistoricalExpensesController(private val historicalExpense: HistoricalExpense) {

    @GetMapping
    fun getAllHistoricalExpenses(
        @PathVariable userId: Long,
        @RequestParam(name = "page") page: Int
    ): HistoricalUserExpensesEvent = historicalExpense.getHistoricalUserExpenses(UserId(userId), page)
}