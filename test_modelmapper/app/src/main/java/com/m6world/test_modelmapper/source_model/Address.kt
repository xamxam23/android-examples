package com.m6world.test_modelmapper.source_model

class Address(var city: String? = null, var street: String? = null) {
    override fun toString(): String {
        return street + " " + city
    }
}
