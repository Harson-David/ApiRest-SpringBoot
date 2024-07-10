package com.pizzeria.SpringApp.domain.service;

import com.pizzeria.SpringApp.domain.dto.Pizza_OrderDTO;
import com.pizzeria.SpringApp.domain.repository.Pizza_OrderDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Pizza_OrderService {

    @Autowired
    private Pizza_OrderDtoRepository pizzaOrderDtoRepository;

    public List<Pizza_OrderDTO> getAll(){
        return pizzaOrderDtoRepository.getAll();
    }

    public List<Pizza_OrderDTO> getByIdCustomers(int idCustomers){
        return pizzaOrderDtoRepository.getByIdCustomers(idCustomers);

    }

    public List<Pizza_OrderDTO> getByIdPizzaOrderDto(int idPizzaOrderDto){
        return pizzaOrderDtoRepository.getByIdPizzaOrderDto(idPizzaOrderDto);
    }

    public List<Pizza_OrderDTO> getByIdPizzaOrderDtoOrderByMethodsAsc(int idPizzaOrderDto){
        return pizzaOrderDtoRepository.getByIdPizzaOrderDtoOrderByMethodsAsc(idPizzaOrderDto);
    }

    public Optional<List<Pizza_OrderDTO>> getByIdCustomersLessThanAndTotal(int idCustomers, double total){
        return pizzaOrderDtoRepository.getByIdCustomersLessThanAndTotal(idCustomers,total);
    }

    public Optional<Pizza_OrderDTO> getPizzaOrder(int idPizzaOrderDto){
        return pizzaOrderDtoRepository.getPizzaOrder(idPizzaOrderDto);

    }

    public Boolean edit(Pizza_OrderDTO pizzaOrden){
        return pizzaOrderDtoRepository.edit(pizzaOrden);

    }

    public Pizza_OrderDTO save(Pizza_OrderDTO pizza_order){
        return pizzaOrderDtoRepository.save(pizza_order);
    }

    public boolean delete(int idPizzaOrderDto){
        return getPizzaOrder(idPizzaOrderDto).map(pizza -> {
            pizzaOrderDtoRepository.delete(idPizzaOrderDto);
            return true;
        }).orElse(false);
    }


}
