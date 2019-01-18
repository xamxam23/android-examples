package com.m6world.test_modelmapper;

import android.icu.text.Collator;

import com.m6world.test_modelmapper.destinatiom_model.OrderDTO;
import com.m6world.test_modelmapper.source_model.Address;
import com.m6world.test_modelmapper.source_model.Customer;
import com.m6world.test_modelmapper.source_model.Name;
import com.m6world.test_modelmapper.source_model.Order;

import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;

public class ModelMapperTest {
    ModelMapper mapper = new ModelMapper();
    // http://modelmapper.org/getting-started/
    // http://modelmapper.org/user-manual/property-mapping/
    @Test public void mapOrderToOrderDTO() {
        Address address = new Address("city", "street");
        Name name = new Name("firstName", "lastName");
        Customer customer = new Customer(name);

        Order order = new Order(customer, address);

        OrderDTO orderDTO = mapper.map(order, OrderDTO.class);

        System.out.println("order: " + order);
        System.out.println("orderDTO: " + orderDTO);

        assertEquals(order.getCustomer().getName().getFirstName(), orderDTO.getCustomerFirstName());
        assertEquals(order.getCustomer().getName().getLastName(), orderDTO.getCustomerLastName());
        assertEquals(order.getAddress().getStreet(), orderDTO.getAddressStreet());
        assertEquals(order.getAddress().getCity(), orderDTO.getAddressCity());

        order = mapper.map(orderDTO, Order.class);

        assertEquals(order.getCustomer().getName().getFirstName(), orderDTO.getCustomerFirstName());
        assertEquals(order.getCustomer().getName().getLastName(), orderDTO.getCustomerLastName());
        assertEquals(order.getAddress().getStreet(), orderDTO.getAddressStreet());
        assertEquals(order.getAddress().getCity(), orderDTO.getAddressCity());

        Name name2 = mapper.map(orderDTO, Name.class);
        System.out.println("name2:"+ name2);
    }
}