package com.pizzeria.SpringApp.persistence.repo;

import com.pizzeria.SpringApp.domain.dto.CustomerDTO;
import com.pizzeria.SpringApp.domain.repository.CustomerDtoRepository;
import com.pizzeria.SpringApp.persistence.crud.CustomerCrudRepository;
import com.pizzeria.SpringApp.persistence.entity.Customer;
import com.pizzeria.SpringApp.persistence.mapper.CustomerDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository implements CustomerDtoRepository {

    @Autowired
    private CustomerCrudRepository customerCrudRepository;

    @Autowired
    private CustomerDtoMapper mapper;

//    @Autowired
//    private CustomerDtoRepository clienteRepository;

//    @Override
//    public List<Cliente> findAll() {
//        return List.of();
//    }
//
//    @Override
//    public List<Cliente> findByIdOrder(int idOrder) {
//        return List.of();
//    }
//
//    @Override
//    public List<Cliente> findByIdCustomerOrderByNameAsc(int idCustomer) {
//        return List.of();
//    }
//
//    @Override
//    public Optional<List<Cliente>> findByEmailOrderByAddressAsc(String correoElectronico, String direccion) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<Cliente> findByIdCustomer(int idCustomer) {
//        return customerCrudRepository.findById(idCustomer);
//    }
//
//    @Override
//    public Cliente save(Cliente cliente) {
//        Customer customer = mapper.toCustomer(cliente);
//        customer.setPhoneNumber("2324244");
//        return mapper.toCliente(customerCrudRepository.save(customer));
//    }
//
//    @Override
//    public boolean edit(Cliente cliente) {
//        Optional<Cliente> client = getCustomer(cliente.getIdCliente());
//        if (client.isPresent()) {
//            Customer clientes = mapper.toCustomer(cliente);
//            clientes.setPhoneNumber("434345");
//            customerCrudRepository.save(clientes);
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    @Override
//    public void delete(int idCustomer) {
//        customerCrudRepository.deleteById(idCustomer);
//    }
//
//
//
//    @Override
//    public List<Cliente> getAll() {
//        List<Customer> clientes = (List<Customer>) customerCrudRepository.findAll();
//        return mapper.toCliente(clientes);
//    }
//
//    @Override
//    public List<Cliente> getByIdOrder(int idOrder) {
//        List<Customer> clientes = customerCrudRepository.findByIdOrder(idOrder);
//        return mapper.toCliente(clientes);
//    }
//
//    @Override
//    public List<Cliente> getByIdCustomerOrderByNameAsc(int idCustomer) {
//        List<Customer> clientes = customerCrudRepository.findByIdCustomerOrderByNameAsc(idCustomer);
//        return mapper.toCliente(clientes);
//      }
//
//    @Override
//    public Optional<List<Cliente>> getByEmailOrderByAddressAsc(String correoElectronico, String direccion) {
//        Optional<List<Customer>> clientes = customerCrudRepository.findByEmailOrderByAddressAsc(correoElectronico, direccion);
//        return clientes.map(prods -> mapper.toCliente(clientes));
//    }
//
//    @Override
//    public Optional<Cliente> getCustomer(int idCustomer) {
//        return customerCrudRepository.findById(idCustomer);
//    }




    //Originales

    public List<CustomerDTO> getAll() {
        List<Customer> customers = (List<Customer>) customerCrudRepository.findAll();
        return mapper.toClientes(customers);
    }


    public List<CustomerDTO> getByIdCustomerDto(int idCustomerDto) {
        List<Customer> customers = customerCrudRepository.findByIdCustomer(idCustomerDto);
        return mapper.toClientes(customers);
    }


//    public List<Cliente> getByIdOrden(int idPizzaOrden) {
//        List<Customer> customers = customerCrudRepository.findByIdOrder(idPizzaOrden);
//        return mapper.toClientes(customers);
//    }

    public List<CustomerDTO> getByIdCustomerDtoOrderByNameDtoAsc(int idCustomerDto) {
        List<Customer> customers = customerCrudRepository.findByIdCustomerOrderByNameAsc(idCustomerDto);
        return mapper.toClientes(customers);

    }

    public Optional<List<CustomerDTO>> getByEmailDtoOrderByAddressDtoAsc(String addressDto) {
        Optional<List<Customer>> customers = customerCrudRepository.findByEmailOrderByAddressAsc(addressDto);
        return customers.map(customers1 -> mapper.toClientes(customers1));
    }


    @Override
    public Boolean edit(CustomerDTO cliente) {
        Optional<CustomerDTO> cliente1 = getCustomer(cliente.getIdCustomerDto());
        if (cliente1.isPresent()){
            Customer customer = mapper.toCustomer(cliente);
            customer.setAddress(""); // se settea la direccion para observar los cambios en el edit
            customerCrudRepository.save(customer);
            return true;
        }else{
            return false;
        }

    }

    public Optional<CustomerDTO> getCustomer(int idCustomerDto) {
        return customerCrudRepository.findById(idCustomerDto).map(customer -> mapper.toCliente(customer));
    }

    @Override
    public CustomerDTO save(CustomerDTO cliente) {
        Customer customer = mapper.toCustomer(cliente); // no usar el correo para guardar, aqui ya esta siendo seteado
        customer.setAddress("Calle 72 K54, Barranquilla");
        return mapper.toCliente(customerCrudRepository.save(customer));
    }

    public void delete(int idCustomerDto) {
        customerCrudRepository.deleteById(idCustomerDto);
    }
}
