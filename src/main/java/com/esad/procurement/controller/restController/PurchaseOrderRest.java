package com.esad.procurement.controller.restController;

import com.esad.procurement.entity.Item;
import com.esad.procurement.entity.PurchaseOrder;
import com.esad.procurement.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/purchaseOrder")
public class PurchaseOrderRest {
    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<PurchaseOrder> getItem(@PathVariable("id") int id) {
        try {
            return new ResponseEntity<PurchaseOrder>(purchaseOrderService.getPurchaseById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<PurchaseOrder>(HttpStatus.BAD_REQUEST);
        }

    }
}
