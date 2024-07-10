
package com.pizzeria.SpringApp.web.controller;

import com.pizzeria.SpringApp.domain.dto.CustomerDTO;
import com.pizzeria.SpringApp.domain.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<CustomerDTO>> getAll() {
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }


    @PutMapping("/edit")
    public ResponseEntity edit(@RequestBody CustomerDTO cliente) {
        if (customerService.edit(cliente)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

//    @PutMapping("/edit/{id}")
//    public ResponseEntity <CustomerDTO> edit(@PathVariable("id") int idCustomerDto, @RequestBody CustomerDTO cliente) {
//        if (customerService.edit(cliente)) {
//            return new ResponseEntity(HttpStatus.OK);
//        } else {
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        }
//    }


    @PostMapping("/save")
    public ResponseEntity<CustomerDTO> save(@RequestBody CustomerDTO cliente) {
        return new ResponseEntity<>(customerService.save(cliente), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getOneCliente(@PathVariable("id") int idCustomerDto) {
        return customerService.getCliente(idCustomerDto).map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int idCustomerDto) {
        if(customerService.delete(idCustomerDto)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
