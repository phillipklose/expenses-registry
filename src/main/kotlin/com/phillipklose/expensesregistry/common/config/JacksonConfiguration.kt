package com.phillipklose.expensesregistry.common.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.text.SimpleDateFormat


@Configuration
class JacksonConfiguration {

    @Bean
    fun jacksonObjectMapper(): ObjectMapper = ObjectMapper().apply {
        registerModule(kotlinModule())
        registerModule(JavaTimeModule())
        dateFormat = SimpleDateFormat("dd-MM-yyyy hh:mm:ss")
        propertyNamingStrategy = PropertyNamingStrategies.SNAKE_CASE
    }

    private fun kotlinModule() = KotlinModule.Builder()
        .withReflectionCacheSize(512)
        .configure(KotlinFeature.NullToEmptyCollection, false)
        .configure(KotlinFeature.NullToEmptyMap, false)
        .configure(KotlinFeature.NullIsSameAsDefault, false)
        .configure(KotlinFeature.SingletonSupport, false)
        .configure(KotlinFeature.StrictNullChecks, false)
        .build()
}