package com.pizzeria.SpringApp.persistence.crud;

import com.pizzeria.SpringApp.persistence.entity.Order_item;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Optional;

public interface OrderItemCrudRepository extends CrudRepository<Order_item, Integer> {

    List<Order_item> findByIdItem(int idItem);

    List<Order_item> findByIdOrder(int idOrder);

    List<Order_item> findByIdPizza(int idPizza);

    List<Order_item> findByIdItemOrderByPriceAsc(int idItem);

    Optional<List<Order_item>> findByPriceOrderByQuantityAsc(double price);
}
