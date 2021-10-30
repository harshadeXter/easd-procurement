package com.esad.procurement.repository;

import com.esad.procurement.entity.SupplierInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<SupplierInvoice, Long> {

}
