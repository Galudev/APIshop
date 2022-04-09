package com.code.shop

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.data.repository.findByIdOrNull

internal class CustomerServiceTest {

    private val customerRepository: ICustomerRepository = mockk()
    private val customerService = CustomerService(customerRepository)

    //getAll()
    @Test
    fun `when get list of customers return list of customers`() {

        val customers = listOf(
            Customer("Juan", "Sanchez", "juansanchez@gmail.com", "05/03/1990"),
            Customer("Ana", "Garcia", "anagarcia@gmail.com", "01/10/1985")
        )

        //given
        every { customerRepository.findAll() } returns customers

        //when
        val result = customerService.getAll()

        //then
        verify(exactly = 1) { customerRepository.findAll() }
        assertEquals(customers, result)

    }

    //getById()
    @Test
    fun `when get a customer return this customer`() {

        val customer = Customer("Juan", "Sanchez", "juansanchez@gmail.com", "05/03/1990")

        //given
        every { customerRepository.findByIdOrNull(1) } returns customer

        //when
        val result = customerService.getById(1)

        //then
        verify(exactly = 1) { customerRepository.findByIdOrNull(1) }
        assertEquals(customer, result)

    }

    //save()
    @Test
    fun `when give a customer save this customer`() {

        val customer = Customer("Juan", "Sanchez", "juansanchez@gmail.com", "05/03/1990")

        //given
        every { customerRepository.save(customer) } returns customer

        //when
        val result = customerService.save(customer)

        //then
        verify(exactly = 1) { customerRepository.save(customer) }
        assertEquals(customer, result)

    }
}