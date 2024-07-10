package com.pizzeria.SpringApp.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.*;


//@Data
@Entity
@Table(name="item_order")
//@Getter
//@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
public class Order_item {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_item", nullable = false)
    private Integer idItem;
    
    @Column(name="id_order", nullable = false)
    private Integer idOrder;
    
    @Column(name="pizza", nullable = false)
    private Integer idPizza;
    
    @Column(nullable = false, columnDefinition = "DECIMAL(6,2)")
    private Double quantity;
    
    @Column(nullable = false, columnDefinition = "DECIMAL(6,2)")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id_order", insertable = false, updatable = false)
    @JsonBackReference
    @JsonIgnore
    private Pizza_order pizzaOrder;

    @ManyToOne
    @JoinColumn(name = "id_pizza", referencedColumnName = "id_pizza", insertable = false, updatable = false)
    @JsonBackReference
    @JsonIgnore
    private Pizza pizza;


    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(Integer idPizza) {
        this.idPizza = idPizza;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Pizza_order getPizzaOrder() {
        return pizzaOrder;
    }

    public void setPizzaOrder(Pizza_order pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
