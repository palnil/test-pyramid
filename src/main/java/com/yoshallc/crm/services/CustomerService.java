package com.yoshallc.crm.services;

import com.yoshallc.crm.domains.Customer;
import com.yoshallc.crm.entities.CustomerEntity;
import com.yoshallc.crm.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // find all customers
    public List<CustomerEntity> getCustomers(){

        return (List<CustomerEntity>)customerRepository.findAll();

    }

    // find customer by id
    public CustomerEntity getCustomer(Long id){

        return customerRepository.findById(id)
                .orElse(new CustomerEntity());

    }

    // update customer
    public void updateCustomer(Customer customer){

        customerRepository.save(new ModelMapper().map(customer, CustomerEntity.class));

    }

    // delete customer by id
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }


}
