package com.esad.procurement.controller.restController;

import com.esad.procurement.entity.Item;
import com.esad.procurement.entity.PurchaseOrderLine;
import com.esad.procurement.service.ItemService;
import com.esad.procurement.service.ReturnSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/poline")
public class PurchaseOrderLineRestController {
    @Autowired
    private ReturnSupplierService returnSupplierService;

    @RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<PurchaseOrderLine> getOrderLine(@PathVariable("id") int id){
        try{
            return new ResponseEntity<PurchaseOrderLine>(returnSupplierService.getPOLineById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<PurchaseOrderLine>(HttpStatus.BAD_REQUEST);
        }
    }
}
