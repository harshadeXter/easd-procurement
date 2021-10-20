package com.esad.procurement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "purchase_requests")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "created_date")
    private Date createDate;

    @Column(name = "created_by")
    private String createBy;

    @Column(name = "status")
    private String status;

    @Column(name = "total_amount")
    private String totalAmount;

    @Column(name = "site_location_id")
    private long siteLocationId;

    @Column(name = "approved_date")
    private Date approvedDate;

    @Column(name = "approved_by")
    private String approvedBy;

    @Column(name = "notes")
    private String notes;

    @Column(name = "deliver_address")
    private String deliverAddress;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employe_id", nullable = false)
    private Employee employee;

    @OneToMany(mappedBy = "purchaseRequest", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PurchaseRequestLines> purchaseRequestLines;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "site_id", nullable = false)
    private SiteLocation siteLocation;


}
