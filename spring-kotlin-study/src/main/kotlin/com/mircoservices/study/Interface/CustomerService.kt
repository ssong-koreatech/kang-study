package com.mircoservices.study.Interface

import com.mircoservices.study.data.Customer

interface CustomerService {
    fun getCustomer(id: Int) : Customer?
    fun createCustomer(customer: Customer)
    fun deleteCustomer(id: Int)
    fun updateCustomer(id: Int, customer: Customer)
    fun serachCustomers(nameFilter: String): List<Customer>
}