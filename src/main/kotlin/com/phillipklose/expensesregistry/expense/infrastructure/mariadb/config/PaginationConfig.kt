package com.phillipklose.expensesregistry.expense.infrastructure.mariadb.config

interface PaginationConfig {

    companion object {
        const val DEFAULT_PAGE_SIZE: Int = 10
    }
}