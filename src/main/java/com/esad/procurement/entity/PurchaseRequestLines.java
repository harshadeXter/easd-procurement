package com.esad.procurement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.servlet.http.Part;
import java.util.Date;

@Entity
@Table(name = "purchase_request_lines")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRequestLines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "purchase_request_id")
    private long purchaseRequestId;

    @Column(name = "item_id")
    private long itemId;

    @Column(name = "item_description")
    private String itemDescription;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "supplier_id")
    private long supplierId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purchase_id", nullable = false)
    private PurchaseRequest purchaseRequest;

}
