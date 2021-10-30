package com.esad.procurement.service;

import com.esad.procurement.entity.Item;
import com.esad.procurement.entity.PurchaseRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PurchaseRequestService {
    List<PurchaseRequest> getAllPurchaseRequestById(long id);

    List<PurchaseRequest> getAllPurchaseRequests();

    void savePurchaseRequest(PurchaseRequest purchaseRequest);

    PurchaseRequest getPurchaseRequestById(long id);

    void removePurchaseRequest(long id);

    Page<PurchaseRequest> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
