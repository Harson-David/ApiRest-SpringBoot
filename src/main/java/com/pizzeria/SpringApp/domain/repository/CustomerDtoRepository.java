/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pizzeria.SpringApp.domain.repository;


import com.pizzeria.SpringApp.domain.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerDtoRepository {

    public List<CustomerDTO> getAll();

    public List<CustomerDTO> getByIdCustomerDto(int idCustomerDto);

    public List<CustomerDTO> getByIdCustomerDtoOrderByNameDtoAsc(int idCustomerDto);

//    public List<Cliente> getByIdOrden(int idPizzaOrden);

    public Optional<List<CustomerDTO>> getByEmailDtoOrderByAddressDtoAsc(String addressDto);

    public CustomerDTO save (CustomerDTO cliente);

    public Boolean edit (CustomerDTO cliente);

    public void delete(int idCustomerDto);

    
}
