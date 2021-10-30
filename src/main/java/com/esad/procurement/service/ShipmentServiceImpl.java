package com.esad.procurement.service;

import com.esad.procurement.entity.Shipment;
import com.esad.procurement.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentServiceImpl implements ShipmentService {
    @Autowired
    private ShipmentRepository shipmentRepository;

    @Override
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    @Override
    public void saveShipmentDetails(Shipment shipment) {
        this.shipmentRepository.save(shipment);
    }

    @Override
    public Shipment getShipmentById(long id) {
        Shipment shipment = null;
        Optional<Shipment> existShipment = shipmentRepository.findById(id);
        if (existShipment.isPresent()) {
            shipment = existShipment.get();
        } else {
            throw new RuntimeException(" No Shipment detail found for id : " + id);
        }
        return shipment;
    }

    @Override
    public void removeShipment(long id) {
        shipmentRepository.deleteById(id);
    }

    @Override
    public Page<Shipment> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.shipmentRepository.findAll(pageable);
    }
}
