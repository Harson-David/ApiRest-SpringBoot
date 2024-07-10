package com.pizzeria.SpringApp.persistence.crud;

import com.pizzeria.SpringApp.persistence.entity.Pizza;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PizzaCrudRepository extends CrudRepository<Pizza, Integer> {

    List<Pizza> findByIdPizza(int idPizza);

    List<Pizza> findByIdPizzaOrderByNameAsc(int idPizza);

    Optional<List<Pizza>> findByPriceOrderByAvailableAsc(double price);
}
