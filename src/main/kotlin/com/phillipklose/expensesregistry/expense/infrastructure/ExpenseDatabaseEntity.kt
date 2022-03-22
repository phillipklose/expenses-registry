package com.phillipklose.expensesregistry.expense.infrastructure

import com.phillipklose.expensesregistry.expense.model.BusinessExpense
import com.phillipklose.expensesregistry.expense.model.Expense
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("expanses")
data class ExpenseDatabaseEntity(@Id val id: String?, val amount: Double, val description: String) {
    fun toDomainModel(): Expense {
        // TODO("Add real scenario mapping")
        return BusinessExpense(amount)
    }
}
