package com.pizzeria.SpringApp.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
//import java.sql.Time;
import java.io.Serializable;
import java.time.*;
import java.util.List;
import lombok.*;



//@Data
@Entity
@Table(name="pizza_order")
//@Getter
//@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
public class Pizza_order{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_order", nullable = false)
    private Integer idOrder;
    
    @Column(name="id_customer",nullable = false)
    private Integer idCustomer;
    
    @Column(columnDefinition = "DATETIME" ,nullable = false)
    private LocalDateTime date;
    
    @Column(nullable = false, columnDefinition = "DECIMAL(6,2)")
    private Double total;
    
    @Column(nullable = false, columnDefinition = "CHAR(1)")
    private String method;
    
    @Column(name= "aditional_notes",columnDefinition = "VARCHAR(200)")
    private String aditionalNotes;


    @OneToMany(mappedBy = "pizzaOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<Order_item> itemsOrders;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer", insertable = false, updatable = false)
    @JsonBackReference
    @JsonIgnore
    private Customer customer;


    public String getAditionalNotes() {
        return aditionalNotes;
    }

    public void setAditionalNotes(String aditionalNotes) {
        this.aditionalNotes = aditionalNotes;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public List<Order_item> getItemsOrders() {
        return itemsOrders;
    }

    public void setItemsOrders(List<Order_item> itemsOrders) {
        this.itemsOrders = itemsOrders;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
