package com.esad.procurement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "item_description")
    private String itemDescription;

    @Column(name = "unit_of_measure")
    private String unitOfMeasure;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "supplier_id")
    private long supplierId;
}
