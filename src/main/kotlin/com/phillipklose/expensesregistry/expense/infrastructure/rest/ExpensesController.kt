package com.phillipklose.expensesregistry.expense.infrastructure.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExpensesController {

    @GetMapping
    fun getAllExpenses(): List<Expense> = listOf(
        Expense("1", 100.0, "Refueling the car"),
        Expense("2", 7.99, "Hot dog at the gas station"),
        Expense("3", 5.99, "Chocolate bar")
    )
}