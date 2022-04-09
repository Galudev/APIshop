package com.code.shop

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CustomerService (var customerRepository: ICustomerRepository) : ICustomerService {

    override fun getAll(): List<Customer> {
        return customerRepository.findAll()
    }

    override fun getById(idCustomer: Long): Customer {
        return customerRepository.findByIdOrNull(idCustomer)!!
    }

    override fun save(customer: Customer): Customer {
        return customerRepository.save(customer)
    }

    override fun delete(idCustomer: Long) {
        customerRepository.deleteById(idCustomer)
    }
}