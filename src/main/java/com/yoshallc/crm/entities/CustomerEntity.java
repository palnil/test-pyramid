package com.yoshallc.crm.entities;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerEntity {

    public CustomerEntity(String firstname, String lastname){

        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String firstname;
    private String lastname;

}
