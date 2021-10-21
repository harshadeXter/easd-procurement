package com.esad.procurement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "purchase_orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "supplier_id")
    private long supplierId;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "receipt_date")
    private Date receiptDate;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "phone")
    private String phone;

    @Column(name = "status")
    private String status;

    @Column(name = "site_location_id")
    private long siteLocationId;

    @Column(name = "created_date")
    private Date createDate;

    @Column(name = "created_by")
    private String createBy;

    @OneToOne(mappedBy = "purchaseOrder")
    private Shipment shipment;

    @OneToMany(mappedBy = "purchaseOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PurchaseOrderLine> purchaseOrderLines;

}
