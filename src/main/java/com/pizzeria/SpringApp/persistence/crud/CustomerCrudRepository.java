package com.pizzeria.SpringApp.persistence.crud;

import com.pizzeria.SpringApp.persistence.entity.Customer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerCrudRepository extends CrudRepository<Customer, Integer> {


    List<Customer> findByIdCustomer(int idCustomer);

    List<Customer> findByIdCustomerOrderByNameAsc(int idCustomer);

    Optional<List<Customer>> findByEmailOrderByAddressAsc(String email);

//    List<Customer> findByIdOrder(int idOrder);

}
