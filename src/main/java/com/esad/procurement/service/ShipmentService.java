package com.esad.procurement.service;

import com.esad.procurement.entity.Shipment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ShipmentService {
    List<Shipment> getAllShipments();

    void saveShipmentDetails(Shipment shipment);

    Shipment getShipmentById(long id);

    void removeShipment(long id);

    Page<Shipment> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
