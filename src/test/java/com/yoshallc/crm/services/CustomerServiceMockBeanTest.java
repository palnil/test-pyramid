package com.yoshallc.crm.services;

import com.yoshallc.crm.domains.Customer;
import com.yoshallc.crm.entities.CustomerEntity;
import com.yoshallc.crm.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class CustomerServiceMockBeanTest {

    List<Customer> customerListResponse;
    List<CustomerEntity> customerList;

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;


    @BeforeEach
    void setUp() {

        customerList = Arrays.asList(
                new CustomerEntity(1L,"John","Smith"),
                new CustomerEntity(2L,"David","Levitt")
        );

        customerListResponse = Arrays.asList(
                new Customer(1L,"John","Smith"),
                new Customer(2L,"David","Levitt")
        );
    }

    @Test
    void getCustomers() {

        when(customerRepository.findAll()).thenReturn(customerList);
        assertEquals(customerList.size(),customerService.getCustomers().size());

    }

    @Test
    void getCustomer_returnsOneCustomer() {

        when(customerRepository.findById(any())).thenReturn(Optional.of(customerList.get(0)));
        assertEquals("John",customerService.getCustomer(1L).getFirstname());
    }

}