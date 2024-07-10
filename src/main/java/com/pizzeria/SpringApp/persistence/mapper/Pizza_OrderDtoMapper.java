package com.pizzeria.SpringApp.persistence.mapper;


import com.pizzeria.SpringApp.domain.dto.Pizza_OrderDTO;
import com.pizzeria.SpringApp.persistence.entity.Pizza_order;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel="spring", uses = CustomerDtoMapper.class)
public interface Pizza_OrderDtoMapper {

    @Mappings({
            @Mapping(source = "idOrder", target = "idPizzaOrderDto"),
            @Mapping(source = "idCustomer", target = "idCustomers"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "method", target = "methods"),
            @Mapping(source = "aditionalNotes", target = "additionalNotes"),
            @Mapping(source = "customer", target = "customers"),
            @Mapping(target = "itemsOrders", ignore = true),
    })
    Pizza_OrderDTO toPizzaOrden(Pizza_order pizzaOrder);

//    @Mappings({
//            @Mapping(target = "items", ignore = true) // se ignora esto de la lista
//    })
    List<Pizza_OrderDTO> toPizzaOrdenes(List<Pizza_order> pizzaOrders);

    @InheritInverseConfiguration
    @Mapping(target = "aditionalNotes", ignore = true)
    //@Mapping(target = "itemsOrders", ignore = true)
    Pizza_order toPizzaOrder(Pizza_OrderDTO pizzaOrden);


}
