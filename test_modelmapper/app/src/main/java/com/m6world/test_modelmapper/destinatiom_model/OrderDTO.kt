package com.m6world.test_modelmapper.destinatiom_model

import java.util.*

class OrderDTO {
    var customerFirstName: String? = null
    var customerLastName: String? = null
    var addressCity: String? = null
    var addressStreet: String? = null

    override fun toString(): String {
        return String.format(Locale.US, "%s %s %s %s", customerFirstName, customerLastName, addressCity, addressStreet)
    }
}
