package com.code.shop

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/shop/customers")
class CustomerController(var customerService: CustomerService, var customerRepository: ICustomerRepository) :
    ICustomerController {

    @PostMapping("")
    override fun create(@RequestBody customer: Customer): ResponseEntity<Customer> {
        return ResponseEntity(customerService.save(customer), HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    override fun getById(@PathVariable("id") idCustomer: Long): ResponseEntity<Customer> {
        val responseEntity = if (customerService.getById(idCustomer) == null) {
            ResponseEntity(customerService.getById(idCustomer), HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
        return responseEntity
    }

    @GetMapping("")
    override fun getAll(): ResponseEntity<List<Customer>> {
        val customer = customerService.getAll()
        val responseEntity = if (customer.isNotEmpty()) {
            ResponseEntity(customer, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
        return responseEntity
    }

    @PutMapping("")
    override fun update(@RequestBody customer: Customer): ResponseEntity<Customer> {
        if (customer.id == null) return ResponseEntity(HttpStatus.BAD_REQUEST)
        val responseEntity = if (customerRepository.findById(customer.id!!).isPresent) {
            ResponseEntity(customerService.save(customer), HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
        return responseEntity
    }

    @DeleteMapping("/{id}")
    override fun delete(@PathVariable("id") idCustomer: Long): ResponseEntity<Unit> {
        val responseEntity = if (customerRepository.findById(idCustomer).isPresent) {
            ResponseEntity(customerService.delete(idCustomer), HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
        return responseEntity
    }
}