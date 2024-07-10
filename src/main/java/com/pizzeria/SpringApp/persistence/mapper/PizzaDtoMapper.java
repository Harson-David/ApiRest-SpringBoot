 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pizzeria.SpringApp.persistence.mapper;

import com.pizzeria.SpringApp.domain.dto.PizzaDTO;
import com.pizzeria.SpringApp.persistence.entity.Pizza;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel="spring", uses = Order_ItemDtoMapper.class)
public interface PizzaDtoMapper {

    @Mappings({
            @Mapping(source = "idPizza", target = "idPizzaDto"),
            @Mapping(source = "name", target = "names"),
            @Mapping(source = "description", target = "descriptions"),
            @Mapping(source = "price", target = "prices"),
            @Mapping(source = "vegeterian", target = "vegetarians"),
            @Mapping(source = "vegan", target = "vegans"),
            @Mapping(source = "available", target = "availables"),
            @Mapping(source = "itemsPizza", target = "itemsPizzas")
    })
    PizzaDTO toPizzaEsp(Pizza pizza);

    @InheritInverseConfiguration
    @Mapping(target = "vegan", ignore = true)
    Pizza toPizza(PizzaDTO pizzaEsp);


    // listas de mapeo
    List<PizzaDTO> toPizzas(List<Pizza> pizzas);

    //List<Pizza> toPizzaList(List<PizzaEsp> pizzaEsps);
    
}
