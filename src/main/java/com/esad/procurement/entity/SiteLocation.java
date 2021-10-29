package com.esad.procurement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "site_locations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "company_namr")
    private String companyName;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @OneToMany(mappedBy = "siteLocation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PurchaseRequest> purchaseRequests;
}
