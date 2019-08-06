package com.yoshallc.crm.services;

import com.yoshallc.crm.domains.Customer;
import com.yoshallc.crm.entities.CustomerEntity;
import com.yoshallc.crm.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class CustomerServiceClassTest {

    List<Customer> customerListResponse;
    List<CustomerEntity> customerList;

    private CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;


    @BeforeEach
    void setUp() {

        customerService = new CustomerService(customerRepository);

        customerList = Arrays.asList(
                new CustomerEntity(1L,"Nilesh","Patel"),
                new CustomerEntity(2L,"Palak","Patel")
        );

        customerListResponse = Arrays.asList(
                new Customer(1L,"Nilesh","Patel"),
                new Customer(2L,"Palak","Patel")
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
        assertEquals("Nilesh",customerService.getCustomer(1L).getFirstname());
    }

    @Test
    void updateCustomer() {

        customerService.updateCustomer(new Customer(3L,"Test","Test"));

        verify(customerRepository, times(1)).save(any());
    }

    @Test
    void updateCustomer_ThrowsException() {



        assertThrows(Exception.class, () -> {
            customerRepository.save(any());
        });
    }
}