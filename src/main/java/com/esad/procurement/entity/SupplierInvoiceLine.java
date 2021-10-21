package com.esad.procurement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "supplier_invoice_lines")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierInvoiceLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "unit_price")
    private String unitPrice;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "line_total")
    private Double lineTotal;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supplier_invoice_id", nullable = false)
    private SupplierInvoice supplierInvoice;
}
