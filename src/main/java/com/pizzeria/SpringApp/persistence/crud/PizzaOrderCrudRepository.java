package com.pizzeria.SpringApp.persistence.crud;

import com.pizzeria.SpringApp.persistence.entity.Pizza;
import com.pizzeria.SpringApp.persistence.entity.Pizza_order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PizzaOrderCrudRepository extends CrudRepository<Pizza_order, Integer> {

    List<Pizza_order> findByIdOrder(int idOrder);

    List<Pizza_order> findByIdCustomer(int idCustomer);

    List<Pizza_order> findByIdOrderOrderByMethodAsc(int idOrder);

    Optional<List<Pizza_order>> findByIdCustomerAndTotalLessThan(int idCustomer, double total);
}

