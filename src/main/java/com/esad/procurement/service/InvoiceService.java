package com.esad.procurement.service;

import com.esad.procurement.entity.SupplierInvoice;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InvoiceService {
    List<SupplierInvoice> getAllInvoice();

    void saveInvoiceDetails(SupplierInvoice invoice);

    SupplierInvoice getInvoiceById(long id);

    void removeInvoice(long id);

    Page<SupplierInvoice> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
