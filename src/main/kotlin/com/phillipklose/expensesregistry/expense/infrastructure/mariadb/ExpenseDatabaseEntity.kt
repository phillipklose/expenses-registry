package com.phillipklose.expensesregistry.expense.infrastructure.mariadb

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "expenses")
class ExpenseDatabaseEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    var userId: Long,
    var amount: BigDecimal,
    var currency: String,
    var occurredAt: LocalDateTime
)
