package com.code.shop

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
data class Customer(
    var name: String = "",
    var surname: String = "",
    var email: String = "",
    var birthdate: String = "",
    @Id @GeneratedValue var id: Long? = null) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Customer

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , surname = $surname , email = $email , birthdate = $birthdate )"
    }
}