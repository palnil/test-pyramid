package com.yoshallc.crm;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

   /* private CustomerRepository customerRepository;

    public Application(CustomerRepository customerRepository){

        this.customerRepository = customerRepository;
    }*/

    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);
    }

   /* @Bean
    CommandLineRunner insertCustomers(){

        return args -> {
            List<CustomerEntity> customerList = Arrays.asList(

                    new CustomerEntity("Nilesh", "Patel"),
                    new CustomerEntity("Palak", "Patel"),
                    new CustomerEntity("Swina", "Patel"),
                    new CustomerEntity("Stuti", "Patel")
            );

            this.customerRepository.saveAll(customerList);
        };
    }*/
}
