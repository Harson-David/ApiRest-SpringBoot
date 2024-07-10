package com.pizzeria.SpringApp.web.controller;


import com.pizzeria.SpringApp.domain.dto.Pizza_OrderDTO;
import com.pizzeria.SpringApp.domain.service.Pizza_OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzaOrden")
public class PizzaOrderController {

    @Autowired
    private Pizza_OrderService pizzaOrderService;

    @GetMapping("/all")
    public ResponseEntity<List<Pizza_OrderDTO>> getAll() {
        return new ResponseEntity<>(pizzaOrderService.getAll(), HttpStatus.OK);
    }


    @PutMapping("/edit")
    public ResponseEntity edit(@RequestBody Pizza_OrderDTO pizzaOrden) {
        if (pizzaOrderService.edit(pizzaOrden)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/save")
    public ResponseEntity<Pizza_OrderDTO> save(@RequestBody Pizza_OrderDTO pizzaOrden) {
        return new ResponseEntity<>(pizzaOrderService.save(pizzaOrden), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza_OrderDTO> getOnePizzaOrder(@PathVariable("id") int idPizzaOrderDto) {
        return pizzaOrderService.getPizzaOrder(idPizzaOrderDto).map(pizza -> new ResponseEntity<>(pizza, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/customer/{idCustomers}")
    public ResponseEntity<List<Pizza_OrderDTO>> getAllCustomers(@PathVariable("idCustomers") int idCustomers) {
        List<Pizza_OrderDTO> pizzas = pizzaOrderService.getByIdCustomers(idCustomers);
        return pizzas != null && !pizzas.isEmpty()
                ? new ResponseEntity<>(pizzas, HttpStatus.OK)
                : new ResponseEntity<>(pizzas, HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int idPizzaOrderDto) {
        if(pizzaOrderService.delete(idPizzaOrderDto)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
