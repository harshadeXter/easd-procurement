package com.esad.procurement.service;
import com.esad.procurement.entity.Item;
import com.esad.procurement.entity.PurchaseOrder;
import org.springframework.data.domain.Page;


import java.util.List;
public interface PurchaseOrderService {
  List<PurchaseOrder> getAllPurchaseOders();

  void savePurchaseDetails(PurchaseOrder purchaseOrder);

  PurchaseOrder getPurchaseById(long id);

  void removePurchase(long id);

  Page<PurchaseOrder> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
