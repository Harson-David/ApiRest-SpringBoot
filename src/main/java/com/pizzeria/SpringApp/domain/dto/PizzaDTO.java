/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pizzeria.SpringApp.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pizzeria.SpringApp.persistence.entity.Order_item;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PizzaDTO {

    private Integer idPizzaDto;

    private String names;

    private String descriptions;

    private Double prices;

    private Boolean vegetarians;

    private Boolean vegans;

    private Boolean availables;

    private List<Order_item> itemsPizzas;


    public Integer getIdPizzaDto() {
        return idPizzaDto;
    }

    public void setIdPizzaDto(Integer idPizzaDto) {
        this.idPizzaDto = idPizzaDto;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }

    public Boolean getVegetarians() {
        return vegetarians;
    }

    public void setVegetarians(Boolean vegetarians) {
        this.vegetarians = vegetarians;
    }

    public Boolean getVegans() {
        return vegans;
    }

    public void setVegans(Boolean vegans) {
        this.vegans = vegans;
    }

    public Boolean getAvailables() {
        return availables;
    }

    public void setAvailables(Boolean availables) {
        this.availables = availables;
    }

    public List<Order_item> getItemsPizzas() {
        return itemsPizzas;
    }

    public void setItemsPizzas(List<Order_item> itemsPizzas) {
        this.itemsPizzas = itemsPizzas;
    }
}
