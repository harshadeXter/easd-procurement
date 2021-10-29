package com.esad.procurement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "approval_levels")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "level_description")
    private String levelDescription;

    @Column(name = "approval_amount")
    private Double approvalAmount;

//    @OneToOne(mappedBy = "approvalLevel")
//    private Employee employee;
}
