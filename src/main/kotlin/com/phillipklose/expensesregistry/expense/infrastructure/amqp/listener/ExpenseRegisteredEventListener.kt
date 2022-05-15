package com.phillipklose.expensesregistry.expense.infrastructure.amqp.listener

import com.phillipklose.expensesregistry.expense.infrastructure.amqp.message.UserExpenseRegisteredEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class ExpenseRegisteredEventListener {

    @RabbitListener(queues = ["user.expense.registered.event.expenses_registry"])
    fun handleUserExpenseRegistered(event: UserExpenseRegisteredEvent) {
        log.info("Received event: $event")
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(ExpenseRegisteredEventListener::class.java)
    }
}