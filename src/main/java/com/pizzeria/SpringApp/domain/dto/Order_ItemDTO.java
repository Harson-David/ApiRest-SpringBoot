package com.pizzeria.SpringApp.domain.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pizzeria.SpringApp.persistence.entity.Pizza;
import com.pizzeria.SpringApp.persistence.entity.Pizza_order;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Order_ItemDTO {


    private Integer idItemDto;

    private Integer idOrders;

    private Integer idPizzas;

    private Double quantity;

    private Double prices;

    private Pizza_order pizzaOrders;

    private Pizza pizzas;

    public Integer getIdItemDto() {
        return idItemDto;
    }

    public void setIdItemDto(Integer idItemDto) {
        this.idItemDto = idItemDto;
    }

    public Integer getIdOrders() {
        return idOrders;
    }

    public void setIdOrders(Integer idOrders) {
        this.idOrders = idOrders;
    }

    public Integer getIdPizzas() {
        return idPizzas;
    }

    public void setIdPizzas(Integer idPizzas) {
        this.idPizzas = idPizzas;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }

    public Pizza_order getPizzaOrders() {
        return pizzaOrders;
    }

    public void setPizzaOrders(Pizza_order pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
    }

    public Pizza getPizzas() {
        return pizzas;
    }

    public void setPizzas(Pizza pizzas) {
        this.pizzas = pizzas;
    }
}
