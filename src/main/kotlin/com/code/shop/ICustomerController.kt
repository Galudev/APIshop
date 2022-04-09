package com.code.shop

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody

interface ICustomerController {
    fun create(@RequestBody customer: Customer): ResponseEntity<Customer>
    fun getById(@PathVariable("id") idCustomer: Long): ResponseEntity<Customer>
    fun getAll(): ResponseEntity<List<Customer>>
    fun update(@RequestBody customer: Customer): ResponseEntity<Customer>
    fun delete(@PathVariable("id") idCustomer: Long): ResponseEntity<Any>
}