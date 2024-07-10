package com.pizzeria.SpringApp.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
//import java.sql.Time;
import java.io.Serializable;
import java.time.*;
import java.util.List;
import lombok.*;



//@Data
@Entity
@Table(name="customer")
//@Getter
//@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_customer",nullable = false)
    private Integer idCustomer;
    
    @Column(columnDefinition = "VARCHAR(15)",nullable = false)
    private String name;
    
    @Column(columnDefinition = "VARCHAR(60)",nullable = false)
    private String address;

    @Column(columnDefinition = "VARCHAR(200)",nullable = false)
    private String email;
    
    @Column(columnDefinition = "VARCHAR(200)",nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonManagedReference
    private List<Pizza_order> item;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public List<Pizza_order> getItem() {
        return item;
    }

    public void setItem(List<Pizza_order> item) {
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
