package com.phillipklose.expensesregistry.ui.rest.api

import com.phillipklose.expensesregistry.ui.rest.dto.Expense
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExpensesController {

    @GetMapping
    fun getAllExpenses(): List<Expense> = listOf(
        Expense("1", 100.0, "Paliwo Pb 95"),
        Expense("2", 7.99, "HotDog"),
        Expense("3", 5.99, "Batonik czekoladowy")
    )
}