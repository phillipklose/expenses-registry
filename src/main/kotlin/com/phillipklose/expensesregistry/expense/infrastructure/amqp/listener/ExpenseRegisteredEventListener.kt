package com.phillipklose.expensesregistry.expense.infrastructure.amqp.listener

import com.phillipklose.expensesregistry.expense.application.RegisteredExpenseCommand
import com.phillipklose.expensesregistry.expense.application.RegisteringExpense
import com.phillipklose.expensesregistry.expense.domain.UserId
import com.phillipklose.expensesregistry.expense.infrastructure.amqp.message.UserExpenseRegisteredEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.time.Instant
import java.time.ZoneId
import java.util.*

@Component
class ExpenseRegisteredEventListener(private val registeringExpense: RegisteringExpense) {

    @RabbitListener(queues = ["user.expense.registered.event.expenses_registry"])
    fun handleUserExpenseRegistered(event: UserExpenseRegisteredEvent) {
        log.info("Received UserExpenseRegisteredEvent for UserId: ${event.userId}")
        registeringExpense.registerExpense(
            RegisteredExpenseCommand(
                UserId(event.userId),
                BigDecimal.valueOf(event.amount),
                Currency.getInstance(event.currency.uppercase()),
                Instant.ofEpochSecond(event.timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime()
            )
        )
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(ExpenseRegisteredEventListener::class.java)
    }
}