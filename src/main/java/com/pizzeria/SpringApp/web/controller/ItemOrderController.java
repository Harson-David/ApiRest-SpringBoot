package com.pizzeria.SpringApp.web.controller;


import com.pizzeria.SpringApp.domain.dto.Order_ItemDTO;
import com.pizzeria.SpringApp.domain.service.Order_ItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemOrderController {

    @Autowired
    private Order_ItemService orderItemService;


    @GetMapping("/all")
    public ResponseEntity<List<Order_ItemDTO>> getAll() {
        return new ResponseEntity<>(orderItemService.getAll(), HttpStatus.OK);
    }


    @PutMapping("/edit")
    public ResponseEntity edit(@RequestBody Order_ItemDTO item) {
        if (orderItemService.edit(item)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/save")
    public ResponseEntity<Order_ItemDTO> save(@RequestBody Order_ItemDTO item) {
        return new ResponseEntity<>(orderItemService.save(item), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order_ItemDTO> getOne(@PathVariable("id") int idItemDto) {
        return orderItemService.getIdItemDto(idItemDto).map(items -> new ResponseEntity<>(items, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/pizza/{idPizzaDto}")
    public ResponseEntity<List<Order_ItemDTO>> getByIdPizzaEsp(@PathVariable("idPizzaDto") int idPizzaDto) {
        List<Order_ItemDTO> items = orderItemService.getByIdPizzas(idPizzaDto);
        return items != null && !items.isEmpty()
                ? new ResponseEntity<>(items, HttpStatus.OK)
                : new ResponseEntity<>(items, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/pizzaorden/{idPizzaOrderDto}")
    public ResponseEntity<List<Order_ItemDTO>> getIdPizzaOrden(@PathVariable("idPizzaOrderDto") int idPizzaOrderDto) {
        List<Order_ItemDTO> items = orderItemService.getByIdOrders(idPizzaOrderDto);
        return items != null && !items.isEmpty()
                ? new ResponseEntity<>(items, HttpStatus.OK)
                : new ResponseEntity<>(items, HttpStatus.NOT_FOUND);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int idItemDto) {
        if(orderItemService.delete(idItemDto)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
