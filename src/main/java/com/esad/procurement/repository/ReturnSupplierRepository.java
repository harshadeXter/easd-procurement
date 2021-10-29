package com.esad.procurement.repository;

import com.esad.procurement.entity.PurchaseOrderLine;
import com.esad.procurement.entity.PurchaseRequestLines;
import com.esad.procurement.entity.ReturnSupplierInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnSupplierRepository extends JpaRepository<ReturnSupplierInvoice, Long> {
}
