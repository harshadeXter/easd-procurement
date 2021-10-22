package com.esad.procurement.service;

import com.esad.procurement.entity.Item;
import com.esad.procurement.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public void saveItemDetails(Item item) {
        this.itemRepository.save(item);
    }

    /*Optional<Supplier> existSupplier = supplierRepository.findById(id);
        Supplier supplier = null;
        if (existSupplier.isPresent()) {
            supplier = existSupplier.get();
        }else {
            throw new RuntimeException(" No Supplier found for id : " + id);
        }
        return supplier;*/

    @Override
    public Item getItemById(long id) {
        Item item = null;
        Optional<Item> existItem = itemRepository.findById(id);
        if (existItem.isPresent()) {
            item = existItem.get();
        } else {
            throw new RuntimeException(" No Item found for id : " + id);
        }
        return item;
    }

    @Override
    public void removeItem(long id) {
        this.itemRepository.deleteById(id);
    }

    @Override
    public Page<Item> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.itemRepository.findAll(pageable);
    }
}
