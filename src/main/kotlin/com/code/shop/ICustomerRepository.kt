package com.code.shop

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ICustomerRepository : JpaRepository<Customer,Long>