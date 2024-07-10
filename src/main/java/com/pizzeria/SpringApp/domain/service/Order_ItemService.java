package com.pizzeria.SpringApp.domain.service;


import com.pizzeria.SpringApp.domain.dto.Order_ItemDTO;
import com.pizzeria.SpringApp.persistence.repo.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Order_ItemService {

    @Autowired
    private OrderItemRepository itemRepository;

    public List<Order_ItemDTO> getAll(){
        return itemRepository.getAll();
    }

    public List<Order_ItemDTO> getByIdItemDto(int idItemDto){
        return itemRepository.getByIdItemDto(idItemDto);
    }

    public List<Order_ItemDTO> getByIdOrders(int idOrders){
        return itemRepository.getByIdOrders(idOrders);
    }

    public List<Order_ItemDTO> getByIdPizzas(int idPizzas){
        return itemRepository.getByIdPizzas(idPizzas);
    }

    public List<Order_ItemDTO> getByIdItemDtoOrderByPricesAsc(int idItemDto){
        return itemRepository.getByIdItemDtoOrderByPricesAsc(idItemDto);
    }

    public Optional<List<Order_ItemDTO>> getByIdItemDtoByPricesOrderByQuantityAsc(double prices){
        return itemRepository.getByIdItemDtoByPricesOrderByQuantityAsc(prices);
    }

    public Optional<Order_ItemDTO> getIdItemDto(int idItemDto){
        return itemRepository.getIdItemDto(idItemDto);
    }


    public Order_ItemDTO save (Order_ItemDTO itemOrden){
        return itemRepository.save(itemOrden);
    }

    public boolean edit (Order_ItemDTO itemOrden){
        return itemRepository.edit(itemOrden);
    }

    public Boolean delete(int idItemDto){
        return getIdItemDto(idItemDto).map(item ->{
            itemRepository.delete(idItemDto);
            return true;
        }).orElse(false);
    }
    
}
