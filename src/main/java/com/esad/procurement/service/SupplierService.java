package com.esad.procurement.service;

import com.esad.procurement.entity.Supplier;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SupplierService {
    List<Supplier> getAllSuppliers();

    void saveSupplierDetails(Supplier supplier);

    Supplier getSupplierById(long id);

    void removeSupplier(long id);

    Page<Supplier> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
