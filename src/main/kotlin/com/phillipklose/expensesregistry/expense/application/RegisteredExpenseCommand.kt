package com.phillipklose.expensesregistry.expense.application

import com.phillipklose.expensesregistry.expense.domain.UserId
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

class RegisteredExpenseCommand(
    val userId: UserId,
    val amount: BigDecimal,
    val currency: Currency,
    val registeredAt: LocalDateTime
)
