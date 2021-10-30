package com.esad.procurement.controller.restController;

import com.esad.procurement.entity.Shipment;
import com.esad.procurement.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/shipment")
public class ShipmentRestController {
    @Autowired
    private ShipmentService shipmentService;

    @RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shipment> getShipment(@PathVariable("id") int id) {
        try {
            return new ResponseEntity<Shipment>(shipmentService.getShipmentById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Shipment>(HttpStatus.BAD_REQUEST);
        }
    }

}
