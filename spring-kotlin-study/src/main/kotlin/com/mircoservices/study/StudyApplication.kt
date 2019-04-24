package com.mircoservices.study

import com.mircoservices.study.Interface.ServiceInterface
import com.mircoservices.study.data.Customer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class StudyApplication {
    @Bean
    @ConditionalOnExpression("#{'\${service.message.type}'=='simple'}")
    fun exampleService() : ServiceInterface = ExampleService()

    @Bean
    @ConditionalOnExpression("#{'\${service.message.type}'=='advance'}")
    fun advanceService() : ServiceInterface = AdvanceService()
}

fun main(args: Array<String>) {
    runApplication<StudyApplication>(*args)
}
