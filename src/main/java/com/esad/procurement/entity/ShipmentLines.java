package com.esad.procurement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "shipment_lines")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentLines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "received_quantity")
    private String receivedQuantity;

    @Column(name = "return_quantity")
    private String returnQuantity;

    @Column(name = "actual_quantity")
    private String actualQuantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shipment_id", nullable = false)
    private Shipment shipment;

}
