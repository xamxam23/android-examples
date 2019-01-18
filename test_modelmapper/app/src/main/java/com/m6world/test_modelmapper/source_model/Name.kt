package com.m6world.test_modelmapper.source_model

class Name(var firstName: String? = null, var lastName: String? = null) {
    override fun toString(): String {
        return firstName + " " + lastName
    }
}
