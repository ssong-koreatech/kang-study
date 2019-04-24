package com.microservice.study.service

import com.microservice.study.data.Customer
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface CustomerService {
    fun getCustomer(id: Int) : Mono<Customer>
    fun searchCustomer(nameFilter : String) : Flux<Customer>
    fun createCustomer(customerMono: Mono<Customer>) : Mono<Customer>
    fun deleteCustomer(id: Int) : Mono<Boolean>
}