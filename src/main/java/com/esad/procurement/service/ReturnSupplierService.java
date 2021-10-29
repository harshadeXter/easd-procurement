package com.esad.procurement.service;

import com.esad.procurement.entity.PurchaseOrderLine;
import com.esad.procurement.entity.PurchaseRequest;
import com.esad.procurement.entity.PurchaseRequestLines;
import org.springframework.data.domain.Page;

import java.util.List;


public interface ReturnSupplierService {

    List<PurchaseOrderLine> getAllLines();

    void saveEmployee(Employee employee);

    Page<PurchaseOrderLine> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
