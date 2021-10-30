package com.esad.procurement.repository;

import com.esad.procurement.entity.PurchaseRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRequestRepository extends JpaRepository<PurchaseRequest, Long> {
    @Query("select pr from PurchaseRequest pr where pr.id = ?1")
    List<PurchaseRequest> getAllPurchaseRequestsByUserId(long id);
}
