package com.esad.procurement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "suppliers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

}
