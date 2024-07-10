/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pizzeria.SpringApp.domain.service;

import com.pizzeria.SpringApp.domain.dto.CustomerDTO;
import com.pizzeria.SpringApp.persistence.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDTO> getAll(){
        return customerRepository.getAll();
    }

    public Optional<CustomerDTO> getCliente(int idCustomerDto){
        return customerRepository.getCustomer(idCustomerDto);
    }

    public List<CustomerDTO> getByIdCustomerDto(int idCustomerDto){
        return customerRepository.getByIdCustomerDto(idCustomerDto);}

    public List<CustomerDTO> getByIdCustomerDtoOrderByNameDtoAsc(int idCustomerDto){
        return customerRepository.getByIdCustomerDtoOrderByNameDtoAsc(idCustomerDto);
    }

//    public List<Cliente> getByPizzaOrden(int idPizzaOrden){
//        return customerRepository.getByIdOrden(idPizzaOrden);
//
//    }

    public Optional<List<CustomerDTO>> getByEmailDtoOrderByAddressDtoAsc(String addressDto){
        return customerRepository.getByEmailDtoOrderByAddressDtoAsc(addressDto);
    }

    public CustomerDTO save (CustomerDTO cliente){
        return customerRepository.save(cliente);
    }

    public boolean edit (CustomerDTO cliente){
        return customerRepository.edit(cliente);
    }

    public boolean delete(int idCustomerDto){
        return getCliente(idCustomerDto).map(cliente -> {
            customerRepository.delete(idCustomerDto);
            return true;
        }).orElse(false);
    }

}
