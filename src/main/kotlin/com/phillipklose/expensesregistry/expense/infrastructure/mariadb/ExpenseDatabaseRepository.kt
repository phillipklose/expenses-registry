package com.phillipklose.expensesregistry.expense.infrastructure.mariadb

import com.phillipklose.expensesregistry.expense.domain.Expense
import com.phillipklose.expensesregistry.expense.domain.Expense.HistoricalExpense
import com.phillipklose.expensesregistry.expense.domain.Expense.NewlyRegisteredExpense
import com.phillipklose.expensesregistry.expense.domain.Expenses
import com.phillipklose.expensesregistry.expense.domain.UserId
import com.phillipklose.expensesregistry.expense.infrastructure.mariadb.config.PaginationConfig
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component


@Component
class ExpenseDatabaseRepository(private val repository: ExpenseCrudRepository) : Expenses {

    override fun findAllUserExpensesPaginated(userId: UserId, pageNumber: Int): List<Expense> {
        val pagination = PageRequest.of(pageNumber, PaginationConfig.DEFAULT_PAGE_SIZE, Sort.by("occurredAt").descending())
        return repository.findAllByUserId(userId.id, pagination).map { it.toDomainModel() }
    }

    override fun save(expense: Expense) {
        when (expense) {
            is NewlyRegisteredExpense -> expense.toEntity()
            is HistoricalExpense -> expense.toEntity()
        }.let { repository.save(it) }
    }
}