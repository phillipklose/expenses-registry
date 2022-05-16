package com.phillipklose.expensesregistry.expense.infrastructure.mariadb

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ExpenseCrudRepository : CrudRepository<ExpenseDatabaseEntity, Long>