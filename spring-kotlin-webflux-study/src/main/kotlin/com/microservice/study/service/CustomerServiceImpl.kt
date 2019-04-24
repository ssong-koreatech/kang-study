package com.microservice.study.service

import com.microservice.study.data.Customer
import com.microservice.study.exception.CustomerExistException
import com.microservice.study.exception.CustomerNoExistException
import com.microservice.study.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono
import java.util.concurrent.ConcurrentHashMap

@Component
class CustomerServiceImpl : CustomerService {
    @Autowired
    lateinit var customerRepository: CustomerRepository


    override fun getCustomer(id: Int) = customerRepository.findById(id)

    override fun searchCustomer(nameFilter: String) = customerRepository.findCustomer(nameFilter)

    override fun createCustomer(customerMono: Mono<Customer>) = customerRepository.create(customerMono)


    override fun deleteCustomer(id: Int) = customerRepository.deleteById(id).map { it.deletedCount > 0}

}