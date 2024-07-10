package com.pizzeria.SpringApp.domain.repository;


import com.pizzeria.SpringApp.domain.dto.Order_ItemDTO;

import java.util.List;
import java.util.Optional;

public interface Order_ItemDtoRepository {


    public List<Order_ItemDTO> getAll();

    public List<Order_ItemDTO> getByIdItemDto(int idItemDto);

    public List<Order_ItemDTO> getByIdOrders(int idOrders);

    public List<Order_ItemDTO> getByIdPizzas(int idPizzas);

    public List<Order_ItemDTO> getByIdItemDtoOrderByPricesAsc(int idItemDto);

    public Optional<List<Order_ItemDTO>> getByIdItemDtoByPricesOrderByQuantityAsc(double prices);

    public Optional<Order_ItemDTO> getIdItemDto(int idItemDto);


    public Order_ItemDTO save (Order_ItemDTO idItemDto);

    public boolean edit (Order_ItemDTO idItemDto);

    public void delete(int idItemDto);


}
