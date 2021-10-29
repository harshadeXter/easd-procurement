package com.esad.procurement.service;

import com.esad.procurement.entity.PurchaseOrderLine;
import com.esad.procurement.entity.PurchaseRequest;
import com.esad.procurement.entity.PurchaseRequestLines;
import com.esad.procurement.entity.ReturnSupplierInvoice;
import org.springframework.data.domain.Page;

import java.util.List;


public interface ReturnSupplierService {

    List<PurchaseOrderLine> getPurchaseOrderLine();

    List<ReturnSupplierInvoice> getSupplierInvoice();

    void saveReturnSupplierInvoice(ReturnSupplierInvoice returnSupplierInvoice);

    Page<PurchaseOrderLine> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
