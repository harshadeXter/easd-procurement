package com.esad.procurement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "return_supplier_invoices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnSupplierInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "invoice_id")
    private String invoiceId;

    @Column(name = "po_reference")
    private String poReference;

    @Column(name = "supplier_reference")
    private String supplierReference;

    @Column(name = "paid_by")
    private String paidBy;

    @Column(name = "total_amount")
    private Double totalAmount;
}
