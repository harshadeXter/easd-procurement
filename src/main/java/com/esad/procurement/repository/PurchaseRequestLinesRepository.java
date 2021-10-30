package com.esad.procurement.repository;

import com.esad.procurement.entity.PurchaseRequestLines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRequestLinesRepository extends JpaRepository<PurchaseRequestLines, Long> {
}
