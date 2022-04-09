package com.code.shop

interface ICustomerService {
    fun save(customer: Customer) : Customer
    fun getById(idCustomer : Long) : Customer
    fun getAll() : List<Customer>
    fun delete(idCustomer: Long)
}