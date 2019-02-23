package com.yoshallc.crm.services;

import com.yoshallc.crm.domains.Customer;
import com.yoshallc.crm.entities.CustomerEntity;
import com.yoshallc.crm.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){

        this.customerRepository = customerRepository;
    }

    // find all customers
    public List<CustomerEntity> getCustomers(){

        return (List<CustomerEntity>)customerRepository.findAll();

    }

    // find customer by id
    public CustomerEntity getCustomer(Long id){

        CustomerEntity customerEntity = customerRepository.findById(id)
                .orElse(new CustomerEntity());

        return customerEntity;

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
