package com.esad.procurement.service;


import com.esad.procurement.entity.Item;
import com.esad.procurement.entity.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.esad.procurement.repository.PurchaseOrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderlmpl implements PurchaseOrderService{

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public List<PurchaseOrder> getAllPurchaseOders() {
        return purchaseOrderRepository.findAll();
    }

    @Override
    public void savePurchaseDetails(PurchaseOrder purchaseOrder) {
        this.purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public PurchaseOrder getPurchaseById(long id) {

        PurchaseOrder purchaseOrder = null;
        Optional<PurchaseOrder> existItem = purchaseOrderRepository.findById(id);
        if (existItem.isPresent()) {
            purchaseOrder = existItem.get();
        } else {
            throw new RuntimeException(" No Item found for id : " + id);
        }
        return purchaseOrder;
    }

    @Override
    public void removePurchase(long id) {
        this.purchaseOrderRepository.deleteById(id);
    }


    @Override
    public Page<PurchaseOrder> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.purchaseOrderRepository.findAll(pageable);
    }
}
