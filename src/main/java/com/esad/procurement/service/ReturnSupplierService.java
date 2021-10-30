package com.esad.procurement.service;

import com.esad.procurement.entity.*;
import org.springframework.data.domain.Page;

import java.util.List;


public interface ReturnSupplierService {

    List<PurchaseOrderLine> getPurchaseOrderLine();

    List<ReturnSupplierInvoice> getSupplierInvoice();

    PurchaseOrderLine getPOLineById(long id);

    void saveReturnSupplierInvoice(ReturnSupplierInvoice returnSupplierInvoice);

    Page<PurchaseOrderLine> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
