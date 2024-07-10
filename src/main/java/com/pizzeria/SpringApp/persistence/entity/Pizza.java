package com.pizzeria.SpringApp.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import lombok.*;



/**
 *
 * @author Administrador
 */

//@Data
@Entity
@Table(name="pizza")
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pizza {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pizza", nullable = false)
    private Integer idPizza;
    
    @Column(nullable = false, length = 30, unique = true)
    private String name;
    
    @Column(nullable = false, length = 150)
    private String description;
    
    @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
    private Double price;
    
    @Column(columnDefinition = "DECIMAL(5,2)")
    private Boolean vegeterian;
    
    @Column(columnDefinition = "TINYINT")
    private Boolean vegan;
    
    @Column(columnDefinition = "TINYINT" , nullable = false)
    private Boolean available;

    @OneToMany(mappedBy = "pizza", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<Order_item> itemsPizza;



    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(Integer idPizza) {
        this.idPizza = idPizza;
    }

    public List<Order_item> getItemsPizza() {
        return itemsPizza;
    }

    public void setItemsPizza(List<Order_item> itemsPizza) {
        this.itemsPizza = itemsPizza;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    public Boolean getVegeterian() {
        return vegeterian;
    }

    public void setVegeterian(Boolean vegeterian) {
        this.vegeterian = vegeterian;
    }
}
