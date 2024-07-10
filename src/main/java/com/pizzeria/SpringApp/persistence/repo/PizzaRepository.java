package com.pizzeria.SpringApp.persistence.repo;

import com.pizzeria.SpringApp.domain.dto.PizzaDTO;
import com.pizzeria.SpringApp.domain.repository.PizzaDtoRepository;
import com.pizzeria.SpringApp.persistence.crud.PizzaCrudRepository;
import com.pizzeria.SpringApp.persistence.entity.Pizza;
import com.pizzeria.SpringApp.persistence.mapper.PizzaDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PizzaRepository implements PizzaDtoRepository {

    @Autowired
    private PizzaCrudRepository pizzaCrudRepository;

    @Autowired
    private PizzaDtoMapper mapper;


    @Override
    public List<PizzaDTO> getAll() {
        List<Pizza> pizzas = ( List<Pizza>) pizzaCrudRepository.findAll();
        return mapper.toPizzas(pizzas);
    }

    @Override
    public List<PizzaDTO> getByIdPizzaDto(int idPizzaDto) {
        List<Pizza> pizzas = pizzaCrudRepository.findByIdPizza(idPizzaDto);
        return mapper.toPizzas(pizzas);
    }

    @Override
    public List<PizzaDTO> getByIdPizzaDtoOrderByNamesAsc(int idPizzaDto) {
        List<Pizza> pizzas = pizzaCrudRepository.findByIdPizzaOrderByNameAsc(idPizzaDto);
        return mapper.toPizzas(pizzas);
    }

    @Override
    public Optional<List<PizzaDTO>> getByPricesOrderByAvailables(double prices, boolean availables) {
        Optional<List<Pizza>> pizzas = pizzaCrudRepository.findByPriceOrderByAvailableAsc(prices);
        return pizzas.map(pizzas1 -> mapper.toPizzas(pizzas1));
    }


    @Override
    public Optional<PizzaDTO> getPizzaDto(int idPizzaDto) {
        return pizzaCrudRepository.findById(idPizzaDto).map(pizza -> mapper.toPizzaEsp(pizza));
    }

    @Override
    public Boolean edit(PizzaDTO pizza) {
        Optional<PizzaDTO> pizzas = getPizzaDto(pizza.getIdPizzaDto());
        if (pizzas.isPresent()){
            Pizza pizza1 = mapper.toPizza(pizza);
            pizza1.setVegeterian(false);
            pizzaCrudRepository.save(pizza1);
            return true;

        } else {
            return false;
        }
    }

    @Override
    public PizzaDTO save(PizzaDTO pizza) {
        Pizza pizzas = mapper.toPizza(pizza);
        pizzas.setVegeterian(false);
        return mapper.toPizzaEsp(pizzaCrudRepository.save(pizzas));
    }

    @Override
    public void delete(int idPizzaDto) {
        pizzaCrudRepository.deleteById(idPizzaDto);
    }


//    // Originales
//
//
//    public List<Pizza> getAll() {
//        return (List<Pizza>) pizzaCrudRepository.findAll();
//    }
//
//    public List<Pizza> getByIdPizza(int idPizza) {
//        return pizzaCrudRepository.findByIdPizza(idPizza);
//    }
//
//    public List<Pizza> getByIdPizzaOrderByNameAsc(int idPizza) {
//        return pizzaCrudRepository.findByIdPizzaOrderByNameAsc(idPizza);
//    }
//
//    public Optional<List<Pizza>> getByPriceOrderByAvailable(double price, boolean available) {
//        return pizzaCrudRepository.findByPriceOrderByAvailableAsc(price, available);
//    }
//
//    public Optional<Pizza> getPizza(int idPizza) {
//        return pizzaCrudRepository.findById(idPizza);
//    }
//
//    public Pizza save(Pizza pizza) {
//        return pizzaCrudRepository.save(pizza);
//    }
//
//    public void delete(int idPizza) {
//        pizzaCrudRepository.deleteById(idPizza);
//    }
}
