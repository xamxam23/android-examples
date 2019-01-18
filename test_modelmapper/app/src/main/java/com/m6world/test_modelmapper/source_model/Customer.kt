package com.m6world.test_modelmapper.source_model

class Customer(var name: Name? = null) {
    override fun toString(): String {
        return name.toString()
    }
}
