package com.yoshallc.crm.controllers;

import com.yoshallc.crm.domains.Customer;
import com.yoshallc.crm.entities.CustomerEntity;
import com.yoshallc.crm.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerController.class)
@Slf4j
public class CustomerControllerTest {

    List<Customer> customerListResponse;
    List<CustomerEntity> customerList;

    @Autowired
    private MockMvc mvc;

    @MockBean
    CustomerService customerService;

    @BeforeEach
    public void setUp(){

        customerList = Arrays.asList(
                new CustomerEntity(1L,"John","Smith"),
                new CustomerEntity(2L,"Joe","Doe")
        );

        customerListResponse = Arrays.asList(
                new Customer(1L,"John","Smith"),
                new Customer(2L,"Joe","Doe")
        );


    }

    @Test
    void givenCustomers_whenGetCustomers_returnsAllCustomers() throws Exception {


        when(customerService.getCustomers()).thenReturn(customerList);


        MvcResult result = mvc.perform(get("/api/customers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstname", is("John")))
                .andExpect(jsonPath("$[1].firstname", is("Joe")))
                .andReturn();

        log.info(result.getResponse().getContentAsString());



    }


    @Test
    void givenCustomers_WhenGetCustomerById_returnsOneCustomer() throws Exception{


        when(customerService.getCustomer(anyLong())).thenReturn(new CustomerEntity(1L,"Jane","Doe"));

        MvcResult result = mvc.perform(get("/api/customer/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("firstname", is("Jane")))
                .andReturn();

    }


}
