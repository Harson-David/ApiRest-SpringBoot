package com.pizzeria.SpringApp.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pizzeria.SpringApp.persistence.entity.Customer;
import com.pizzeria.SpringApp.persistence.entity.Order_item;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pizza_OrderDTO {

    private Integer idPizzaOrderDto;

    private Integer idCustomers;

    private LocalDateTime date;

    private Double total;

    private String methods;

    private String additionalNotes;

    private List<Order_item> itemsOrders;

    private Customer customers;

    public Integer getIdPizzaOrderDto() {
        return idPizzaOrderDto;
    }

    public void setIdPizzaOrderDto(Integer idPizzaOrderDto) {
        this.idPizzaOrderDto = idPizzaOrderDto;
    }

    public Integer getIdCustomers() {
        return idCustomers;
    }

    public void setIdCustomers(Integer idCustomers) {
        this.idCustomers = idCustomers;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getMethods() {
        return methods;
    }

    public void setMethods(String methods) {
        this.methods = methods;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public List<Order_item> getItemsOrders() {
        return itemsOrders;
    }

    public void setItemsOrders(List<Order_item> itemsOrders) {
        this.itemsOrders = itemsOrders;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }
}
