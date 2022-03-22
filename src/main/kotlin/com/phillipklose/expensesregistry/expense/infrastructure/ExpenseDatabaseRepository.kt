package com.phillipklose.expensesregistry.expense.infrastructure

import com.phillipklose.expensesregistry.expense.model.Expense
import com.phillipklose.expensesregistry.expense.model.ExpenseRepository
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper

class ExpenseDatabaseRepository(private val jdbcTemplate: JdbcTemplate) : ExpenseRepository {

    override fun findAllExpenses(): List<Expense> {
        val rowMapper = RowMapper<ExpenseDatabaseEntity> { resultSet, rowIndex ->
            ExpenseDatabaseEntity(
                resultSet.getString("id"),
                resultSet.getDouble("amount"),
                resultSet.getString("description"),
            )
        }
        val results = jdbcTemplate.query("select * from expenses", rowMapper)
        return results.map { expenseDatabaseEntity -> expenseDatabaseEntity.toDomainModel() }
    }
}