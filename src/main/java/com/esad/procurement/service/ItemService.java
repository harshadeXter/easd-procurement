package com.esad.procurement.service;

import com.esad.procurement.entity.Item;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();

    void saveItemDetails(Item item);

    Item getItemById(long id);

    void removeItem(long id);

    Page<Item> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
