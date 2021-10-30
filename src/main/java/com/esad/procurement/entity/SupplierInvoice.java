package com.esad.procurement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "supplier_invoices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "po_reference")
    private String poReference;

    @Column(name = "supplier_reference")
    private String supplierReference;

    @Column(name = "paid_by")
    private String paidBy;

    @Column(name = "total_amount")
    private Double totalAmount;

//    @OneToMany(mappedBy = "supplierInvoice", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<SupplierInvoiceLine> SupplierInvoiceLines;
}
