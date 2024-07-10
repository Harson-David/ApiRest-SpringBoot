package com.pizzeria.SpringApp.persistence.mapper;


import com.pizzeria.SpringApp.domain.dto.CustomerDTO;
import com.pizzeria.SpringApp.persistence.entity.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel="spring")
public interface CustomerDtoMapper {

    @Mappings({
            @Mapping(source = "idCustomer", target = "idCustomerDto"),
            @Mapping(source = "name", target = "nameDto"),
            @Mapping(source = "address", target = "addressDto"),
            @Mapping(source = "email", target = "emailDto"),
            @Mapping(source = "phoneNumber", target = "phoneNumberDto"),
            @Mapping(source = "item", target = "items"),
    })
    //@Mapping(target="item", ignore = true)
    CustomerDTO toCliente(Customer customer);

    //@Mapping(target="item", ignore = true)
    List<CustomerDTO> toClientes(List<Customer> customers);

    @InheritInverseConfiguration
    @Mapping(target="address", ignore = true)
    Customer toCustomer(CustomerDTO cliente);
}
