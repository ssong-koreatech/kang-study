package com.mircoservices.study.controller

import com.mircoservices.study.Interface.CustomerService
import com.mircoservices.study.data.Customer
import com.mircoservices.study.exception.CustomerNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap

@RestController
class CustomerController {

    @Autowired
    private lateinit var customerService: CustomerService

    @GetMapping("/customer/{id}")
    fun getCustomer(@PathVariable("id") id: Int): ResponseEntity<Customer?> {
        val customer = customerService.getCustomer(id)?:
                throw CustomerNotFoundException("customer '$id' not found")
      //  val status = if (customer == null) HttpStatus.NOT_FOUND else HttpStatus.OK

        return ResponseEntity(customer, HttpStatus.OK)
    }

    @PostMapping("/customer/")
    fun postCustomer(@RequestBody customer: Customer) : ResponseEntity<Unit> {
        customerService.createCustomer(customer)
        return ResponseEntity(Unit, HttpStatus.CREATED)
        //return ResponseEntity<Unit?>(null, HttpStatus.CREATED)

    }


    @DeleteMapping("/customer/{id}")
    fun deleteCustomer(@PathVariable("id") id: Int) : ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND
        if(customerService.getCustomer(id) != null){
            customerService.deleteCustomer(id)
            status = HttpStatus.OK
        }
        return ResponseEntity(Unit, status)
    }

    @PutMapping("/customer/{id}")
    fun putCustomer(@PathVariable("id") id: Int, @RequestBody customer: Customer) : ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND
        if (customerService.getCustomer(id) != null) {
            customerService.updateCustomer(id, customer)
            status = HttpStatus.OK
        }

        return ResponseEntity(Unit, status)
    }
    @GetMapping("/customers")
    fun getCustomers(@RequestParam(required = false, defaultValue = "") nameFilter: String) =
            customerService.serachCustomers(nameFilter)
}
