package com.yoshallc.crm.controllers;

import com.yoshallc.crm.domains.Customer;
import com.yoshallc.crm.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private CustomerService customerService;


    public CustomerController(CustomerService customerService){

        this.customerService = customerService;
    }

    @GetMapping(value = "/customers",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Customer>> allCustomers(){
       return new ResponseEntity<>(customerService.getCustomers().stream()
                .map(entity -> new ModelMapper().map(entity, Customer.class))
                .collect(Collectors.toList()), HttpStatus.OK);


    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> allCustomers(@PathVariable Long id){
        return new ResponseEntity<>(new ModelMapper().map(customerService.getCustomer(id), Customer.class), HttpStatus.OK);

    }

    @PostMapping("customer/delete/{id}")
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }

    @PostMapping("customer/update")
    public void updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }

}
