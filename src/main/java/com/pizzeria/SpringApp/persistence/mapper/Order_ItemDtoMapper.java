package com.pizzeria.SpringApp.persistence.mapper;



import com.pizzeria.SpringApp.domain.dto.Order_ItemDTO;
import com.pizzeria.SpringApp.persistence.entity.Order_item;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel="spring", uses = PizzaDtoMapper.class)
public interface Order_ItemDtoMapper {

    @Mappings({
            @Mapping(source = "idItem", target = "idItemDto"),
            @Mapping(source = "idOrder", target = "idOrders"),
            @Mapping(source = "idPizza", target = "idPizzas"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "price", target = "prices"),
            @Mapping(source = "pizzaOrder", target = "pizzaOrders"),
            @Mapping(source = "pizza", target = "pizzas"),
    })
    Order_ItemDTO toItemOrden(Order_item orderItem);

    //@Mapping(target = "pizzaOrder", ignore = true)
    List<Order_ItemDTO> toItem_Orders(List<Order_item> orderItems);

    @InheritInverseConfiguration
    @Mapping(target = "price", ignore = true)
    //@Mapping(target = "pizzaOrder", ignore = true)
    Order_item toOrderItem(Order_ItemDTO itemOrden);
}
