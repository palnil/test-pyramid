package com.yoshallc.crm;


import com.yoshallc.crm.entities.CustomerEntity;
import com.yoshallc.crm.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

//   private CustomerRepository customerRepository;
//
//    public Application(CustomerRepository customerRepository){
//
//        this.customerRepository = customerRepository;
//    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);
    }

//   @Bean
//   CommandLineRunner insertCustomers(){
//
//        return args -> {
//            List<CustomerEntity> customerList = Arrays.asList(
//
//                    new CustomerEntity("John", "Smith"),
//                    new CustomerEntity("Kevin", "Paul"),
//                    new CustomerEntity("Roma", "Shah"),
//                    new CustomerEntity("Neal", "Levitt")
//            );
//
//            this.customerRepository.saveAll(customerList);
//        };
//    }
}
