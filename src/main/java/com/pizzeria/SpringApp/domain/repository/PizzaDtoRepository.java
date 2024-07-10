package com.pizzeria.SpringApp.domain.repository;

import com.pizzeria.SpringApp.domain.dto.PizzaDTO;

import java.util.List;
import java.util.Optional;

public interface PizzaDtoRepository {

    public List<PizzaDTO> getAll();

    public List<PizzaDTO> getByIdPizzaDto(int idPizzaDto);

    public List<PizzaDTO> getByIdPizzaDtoOrderByNamesAsc(int idPizzaDto);

    public Optional<List<PizzaDTO>> getByPricesOrderByAvailables(double prices, boolean availables);

    public Optional<PizzaDTO> getPizzaDto(int idPizzaDto);

    public Boolean edit (PizzaDTO pizza);

    public PizzaDTO save(PizzaDTO pizza);

    public void delete(int idPizzaDto);
}
