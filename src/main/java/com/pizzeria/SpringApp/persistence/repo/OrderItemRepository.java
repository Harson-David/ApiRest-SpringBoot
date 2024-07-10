package com.pizzeria.SpringApp.persistence.repo;

import com.pizzeria.SpringApp.domain.dto.Order_ItemDTO;
import com.pizzeria.SpringApp.domain.repository.Order_ItemDtoRepository;
import com.pizzeria.SpringApp.persistence.crud.OrderItemCrudRepository;
import com.pizzeria.SpringApp.persistence.entity.Order_item;
import com.pizzeria.SpringApp.persistence.mapper.Order_ItemDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderItemRepository implements Order_ItemDtoRepository {

    @Autowired
    private OrderItemCrudRepository orderItemCrudRepository;

    @Autowired
    private Order_ItemDtoMapper mapper;


    @Override
    public List<Order_ItemDTO> getAll() {
        List<Order_item> orderItems = (List<Order_item>) orderItemCrudRepository.findAll();
        return mapper.toItem_Orders(orderItems);
    }

    @Override
    public List<Order_ItemDTO> getByIdItemDto(int idItemDto) {
        List<Order_item> orderItems = orderItemCrudRepository.findByIdItem(idItemDto);
        return mapper.toItem_Orders(orderItems);
    }

    @Override
    public List<Order_ItemDTO> getByIdOrders(int idOrders) {
        List<Order_item> orderItems = orderItemCrudRepository.findByIdOrder(idOrders);
        return mapper.toItem_Orders(orderItems);
    }

    @Override
    public List<Order_ItemDTO> getByIdPizzas(int idPizzas) {
        List<Order_item> orderItems = orderItemCrudRepository.findByIdPizza(idPizzas);
        return mapper.toItem_Orders(orderItems);
    }

    @Override
    public List<Order_ItemDTO> getByIdItemDtoOrderByPricesAsc(int idItemDto) {
        List<Order_item> orderItems = orderItemCrudRepository.findByIdItemOrderByPriceAsc(idItemDto);
        return mapper.toItem_Orders(orderItems);
    }

    @Override
    public Optional<List<Order_ItemDTO>> getByIdItemDtoByPricesOrderByQuantityAsc(double prices) {
        Optional<List<Order_item>> orderItems = orderItemCrudRepository.findByPriceOrderByQuantityAsc(prices);
        return orderItems.map(orderItems1 -> mapper.toItem_Orders(orderItems1));
    }

    @Override
    public Optional<Order_ItemDTO> getIdItemDto(int idItemDto) {
        return orderItemCrudRepository.findById(idItemDto).map(orderItem -> mapper.toItemOrden(orderItem));
    }

    @Override
    public Order_ItemDTO save(Order_ItemDTO itemOrden) {
        Order_item orderItem = mapper.toOrderItem(itemOrden);
        orderItem.setPrice(5.0);
        return mapper.toItemOrden(orderItemCrudRepository.save(orderItem));
    }

    @Override
    public boolean edit(Order_ItemDTO idItemDto) {
        Optional<Order_ItemDTO> orden = getIdItemDto(idItemDto.getIdItemDto());
        if (orden.isPresent()) {
            Order_item orderItem = mapper.toOrderItem(idItemDto);
            orderItem.setPrice(4.0);
            orderItemCrudRepository.save(orderItem);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void delete(int idItemDto) {
        orderItemCrudRepository.deleteById(idItemDto);
    }


//    //originales
//
//
//    public List<Order_item> getAll() {
//        return (List<Order_item>) orderItemCrudRepository.findAll();
//    }
//
//    public List<Order_item> getByIdItem(int idItem) {
//        return orderItemCrudRepository.findByIdItem(idItem);
//    }
//
//    public List<Order_item> getByIdOrder(int idOrder) {
//        return orderItemCrudRepository.findByIdOrder(idOrder);
//    }
//
//    public List<Order_item> getByIdPizza(int idPizza) {
//        return orderItemCrudRepository.findByIdPizza(idPizza);
//    }
//
//    public List<Order_item> getByOrderItemsByIdItemOrderByPriceAsc(int idItem) {
//        return orderItemCrudRepository.findByIdItemOrderByPriceAsc(idItem);
//    }
//
//    public Optional<List<Order_item>> getByOrderItemsByPriceOrderByQuantityAsc(double price) {
//        return orderItemCrudRepository.findByPriceOrderByQuantityAsc(price);
//    }
//
//    public Optional<Order_item> getOrderItem(int idItem) {
//        return orderItemCrudRepository.findById(idItem);
//    }
//
//    public Order_item save(Order_item orderItem) {
//        return orderItemCrudRepository.save(orderItem);
//    }
//
//    public void delete(int idItem) {
//        orderItemCrudRepository.deleteById(idItem);
//    }
}
