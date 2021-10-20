package com.esad.procurement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchase_order_lines")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "purchase_order_id")
    private long purchaseOrderId;

    @Column(name = "item_id")
    private long itemId;

    @Column(name = "item_description")
    private String itemDescription;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "received_quantity")
    private Double receivedQuantity;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "delivery_expected_date")
    private Date deliveryExpectedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "returned_quantity")
    private Double returnQuantity;

    @Column(name = "notes")
    private String notes;
}
