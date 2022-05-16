package com.phillipklose.expensesregistry.expense.infrastructure.amqp.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitmqConfiguration {

    @Bean
    fun rabbitListenerContainerFactory(
        connectionFactory: ConnectionFactory,
        messageConverter: Jackson2JsonMessageConverter
    ): SimpleRabbitListenerContainerFactory = SimpleRabbitListenerContainerFactory().apply {
        setConnectionFactory(connectionFactory)
        setMessageConverter(messageConverter)
        setErrorHandler(conditionalRejectingErrorHandler())
    }

    @Bean
    fun jackson2JsonMessageConverter(objectMapper: ObjectMapper): Jackson2JsonMessageConverter = Jackson2JsonMessageConverter(objectMapper)

    private fun conditionalRejectingErrorHandler(): ConditionalRejectingErrorHandler = ConditionalRejectingErrorHandler().also {
        it.setDiscardFatalsWithXDeath(false)
    }

}