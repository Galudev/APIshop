package com.code.shop

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/shop/customers")
class CustomerController(var customerService: CustomerService) : ICustomerController {

    @PostMapping("")
    override fun create(@RequestBody customer: Customer): ResponseEntity<Customer> {
        return ResponseEntity(customerService.save(customer), HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    override fun getById(@PathVariable("id") idCustomer: Long): ResponseEntity<Customer> {
        return ResponseEntity(customerService.getById(idCustomer), HttpStatus.OK)
    }

    @GetMapping("")
    override fun getAll(): ResponseEntity<List<Customer>> {
        return ResponseEntity(customerService.getAll(), HttpStatus.OK)
    }

    @PutMapping("")
    override fun update(@RequestBody customer: Customer): ResponseEntity<Customer> {
        return ResponseEntity(customerService.save(customer), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    override fun delete(@PathVariable("id") idCustomer: Long): ResponseEntity<Any> {
        return ResponseEntity(customerService.delete(idCustomer), HttpStatus.OK)
    }
}