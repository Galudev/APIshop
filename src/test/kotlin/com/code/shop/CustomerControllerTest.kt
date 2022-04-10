package com.code.shop

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

internal class CustomerControllerTest {

    private val customerRepository: ICustomerRepository = mockk()
    private val customerService = CustomerService(customerRepository)
    private val customerController = CustomerController(customerService, customerRepository)

    //getById()
    @Test
    fun `when the customer with this id does not exist, return the error 'not found'`() {
        //given
        every { customerService.getById(1) } returns null

        //when
        customerController.getById(1)

        //then
        verify { ResponseEntity(customerService.getById(1),HttpStatus.NOT_FOUND) }
    }

    //getAll()
    @Test
    fun `when the customers list is empty, return the error 'not found'`() {
        //given
        every { customerService.getAll() } returns emptyList()

        //when
        customerController.getAll()

        //then
        verify(exactly = 1) { ResponseEntity(customerService.getAll(),HttpStatus.NOT_FOUND) }
    }
}