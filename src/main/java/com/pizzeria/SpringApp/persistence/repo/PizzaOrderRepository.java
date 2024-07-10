package com.pizzeria.SpringApp.persistence.repo;

import com.pizzeria.SpringApp.domain.dto.Pizza_OrderDTO;
import com.pizzeria.SpringApp.domain.repository.Pizza_OrderDtoRepository;
import com.pizzeria.SpringApp.persistence.crud.PizzaOrderCrudRepository;
import com.pizzeria.SpringApp.persistence.entity.Pizza_order;
import com.pizzeria.SpringApp.persistence.mapper.Pizza_OrderDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class PizzaOrderRepository implements Pizza_OrderDtoRepository {

    @Autowired
    private PizzaOrderCrudRepository pizzaOrderCrudRepository;

    @Autowired
    private Pizza_OrderDtoMapper mapper;


    @Override
    public List<Pizza_OrderDTO> getAll() {
        List<Pizza_order> pizzaOrders = (List<Pizza_order>) pizzaOrderCrudRepository.findAll();
        return mapper.toPizzaOrdenes(pizzaOrders);
    }

    @Override
    public List<Pizza_OrderDTO> getByIdCustomers(int idCliente) {
        List<Pizza_order> pizzaOrders = pizzaOrderCrudRepository.findByIdCustomer(idCliente);
        return mapper.toPizzaOrdenes(pizzaOrders);
    }

    @Override
    public List<Pizza_OrderDTO> getByIdPizzaOrderDto(int idPizzaOrderDto) {
        List<Pizza_order> pizzaOrders = pizzaOrderCrudRepository.findByIdOrder(idPizzaOrderDto);
        return mapper.toPizzaOrdenes(pizzaOrders);
    }

    @Override
    public List<Pizza_OrderDTO> getByIdPizzaOrderDtoOrderByMethodsAsc(int idPizzaOrderDto) {
        List<Pizza_order> pizzaOrders =pizzaOrderCrudRepository.findByIdOrderOrderByMethodAsc(idPizzaOrderDto);
        return mapper.toPizzaOrdenes(pizzaOrders);
    }

    @Override
    public Optional<List<Pizza_OrderDTO>> getByIdCustomersLessThanAndTotal(int idCustomers, double total) {
        Optional<List<Pizza_order>> pizzaOrders = pizzaOrderCrudRepository.findByIdCustomerAndTotalLessThan(idCustomers,total);
        return pizzaOrders.map(pizzaOrders1 -> mapper.toPizzaOrdenes(pizzaOrders1));

    }

    @Override
    public Optional<Pizza_OrderDTO> getPizzaOrder(int idPizzaOrderDto) {
        return pizzaOrderCrudRepository.findById(idPizzaOrderDto).map(pizzaOrder -> mapper.toPizzaOrden(pizzaOrder));
    }

    @Override
    public Boolean edit(Pizza_OrderDTO pizzaOrderDTO) {
        Optional<Pizza_OrderDTO> pizzaOrden = getPizzaOrder(pizzaOrderDTO.getIdPizzaOrderDto());
        if (pizzaOrden.isPresent()) {
            Pizza_order pizza_order = mapper.toPizzaOrder(pizzaOrderDTO);
            pizza_order.setAditionalNotes("CAMBIOS");
            pizzaOrderCrudRepository.save(pizza_order);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Pizza_OrderDTO save(Pizza_OrderDTO pizzaOrderDTO) {
        Pizza_order pizza_order = mapper.toPizzaOrder(pizzaOrderDTO);
        pizza_order.setAditionalNotes("Nueva Orden!");
        return mapper.toPizzaOrden(pizzaOrderCrudRepository.save(pizza_order));
    }

    @Override
    public void delete(int idPizzaOrderDto) {
        pizzaOrderCrudRepository.deleteById(idPizzaOrderDto);
    }



    // Originales

//    public List<Pizza_order> getAll() {
//        return (List<Pizza_order>) pizzaOrderCrudRepository.findAll();
//    }
//
//
//    public List<Pizza_order> getByIdCustomer(int idCustomer) {
//        return pizzaOrderCrudRepository.findByIdCustomer(idCustomer);
//    }
//
//    public List<Pizza_order> getByIdOrder(int idOrder) {
//        return pizzaOrderCrudRepository.findByIdOrder(idOrder);
//    }
//
//    public List<Pizza_order> getByIdOrderByMethodAsc(int idOrder) {
//        return pizzaOrderCrudRepository.findByIdOrderOrderByMethodAsc(idOrder);
//    }
//
//    public Optional<List<Pizza_order>> getByIdCustomerLessThanAndTotal(int idCustomer, double total) {
//        return pizzaOrderCrudRepository.findByIdCustomerAndTotalLessThan(idCustomer, total);
//    }
//
//    public Optional<Pizza_order> getPizzaOrder(int idOrder) {
//        return pizzaOrderCrudRepository.findById(idOrder);
//    }
//
//    public Pizza_order save(Pizza_order pizza_order) {
//        return pizzaOrderCrudRepository.save(pizza_order);
//    }
//
//    public void delete(int idOrder) {
//        pizzaOrderCrudRepository.deleteById(idOrder);
//    }
}
