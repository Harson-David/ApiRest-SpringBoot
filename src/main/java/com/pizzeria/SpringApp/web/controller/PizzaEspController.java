package com.pizzeria.SpringApp.web.controller;


import com.pizzeria.SpringApp.domain.dto.PizzaDTO;
import com.pizzeria.SpringApp.domain.service.PizzaService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pizzeria")
public class PizzaEspController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/all")
    public ResponseEntity<List<PizzaDTO>> getAll() {
        return new ResponseEntity<>(pizzaService.getAll(), HttpStatus.OK);
    }


    @PutMapping("/edit")
    public ResponseEntity edit(@RequestBody PizzaDTO pizzaDTO) {
        if (pizzaService.edit(pizzaDTO)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/save")
    public ResponseEntity<PizzaDTO> save(@RequestBody PizzaDTO pizzaDTO) {
        return new ResponseEntity<>(pizzaService.save(pizzaDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaDTO> getOnePizza(@PathVariable("id") int idPizzaDto) {
        return pizzaService.getPizzaDto(idPizzaDto).map(pizzas -> new ResponseEntity<>(pizzas, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/pizza/{idPizzaDto}")
    public ResponseEntity<List<PizzaDTO>> getByPizza(@PathVariable("idPizzaDto") int idPizzaDto) {
        List<PizzaDTO> pizzas = pizzaService.getByIdPizzaDto(idPizzaDto);
        return pizzas != null && !pizzas.isEmpty()
                ? new ResponseEntity<>(pizzas, HttpStatus.OK)
                : new ResponseEntity<>(pizzas, HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int idPizzaDto) {
        if(pizzaService.delete(idPizzaDto)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
