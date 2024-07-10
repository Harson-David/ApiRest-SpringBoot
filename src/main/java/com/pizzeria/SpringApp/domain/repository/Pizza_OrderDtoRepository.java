package com.pizzeria.SpringApp.domain.repository;


import com.pizzeria.SpringApp.domain.dto.Pizza_OrderDTO;

import java.util.List;
import java.util.Optional;

public interface Pizza_OrderDtoRepository {


    public List<Pizza_OrderDTO> getAll();

    public List<Pizza_OrderDTO> getByIdCustomers(int idCustomers);

    public List<Pizza_OrderDTO> getByIdPizzaOrderDto(int idPizzaOrderDto);

    public List<Pizza_OrderDTO> getByIdPizzaOrderDtoOrderByMethodsAsc(int idPizzaOrderDto);

    public Optional<List<Pizza_OrderDTO>> getByIdCustomersLessThanAndTotal(int idCustomers, double total);

    public Optional<Pizza_OrderDTO> getPizzaOrder(int idPizzaOrderDto);

    public Boolean edit(Pizza_OrderDTO pizzaOrden);

    public Pizza_OrderDTO save(Pizza_OrderDTO pizza_order);

    public void delete(int idPizzaOrderDto);




}
