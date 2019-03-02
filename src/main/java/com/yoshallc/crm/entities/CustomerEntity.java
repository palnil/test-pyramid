package com.yoshallc.crm.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
