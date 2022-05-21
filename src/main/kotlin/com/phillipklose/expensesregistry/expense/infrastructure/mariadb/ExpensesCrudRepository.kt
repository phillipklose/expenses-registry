package com.phillipklose.expensesregistry.expense.infrastructure.mariadb

import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface ExpenseCrudRepository : PagingAndSortingRepository<ExpenseDatabaseEntity, Long> {
    fun findAllByUserId(userId: Long, pageable: Pageable): List<ExpenseDatabaseEntity>
}