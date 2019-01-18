package com.m6world.test_modelmapper.source_model

class Order constructor(var customer: Customer? = null, var address: Address? = null) {
    override fun toString(): String {
        return customer.toString() + " " + address.toString()
    }
}