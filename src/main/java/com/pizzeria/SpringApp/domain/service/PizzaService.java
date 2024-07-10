package com.pizzeria.SpringApp.domain.service;


import com.pizzeria.SpringApp.domain.dto.PizzaDTO;
import com.pizzeria.SpringApp.domain.repository.PizzaDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    @Autowired
    private PizzaDtoRepository pizzaDtoRepository;


    public List<PizzaDTO> getAll(){
        return pizzaDtoRepository.getAll();
    }

    public List<PizzaDTO> getByIdPizzaDto(int idPizzaDto){
        return pizzaDtoRepository.getByIdPizzaDto(idPizzaDto);

    }

    public List<PizzaDTO> getByIdPizzaDtoOrderByNamesAsc(int idPizzaDto){
        return pizzaDtoRepository.getByIdPizzaDtoOrderByNamesAsc(idPizzaDto);

    }

    public Optional<List<PizzaDTO>> getByPricesOrderByAvailables(double prices, boolean availables){
        return pizzaDtoRepository.getByPricesOrderByAvailables(prices,availables);
    }

    public Optional<PizzaDTO> getPizzaDto(int idPizzaDto){
        return pizzaDtoRepository.getPizzaDto(idPizzaDto);

    }

    public Boolean edit (PizzaDTO pizza){
        return pizzaDtoRepository.edit(pizza);

    }

    public PizzaDTO save(PizzaDTO pizza){
        return pizzaDtoRepository.save(pizza);

    }

    public Boolean delete(int idPizzaDto){

        return getPizzaDto(idPizzaDto).map(pizza ->{
            pizzaDtoRepository.delete(idPizzaDto);
            return true;
        }).orElse(false);

    }


}
