package com.esad.procurement.controller.restController;

import com.esad.procurement.entity.PurchaseRequest;
import com.esad.procurement.service.PurchaseRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/purchaseRequest")
public class PurchaseRequestRestController {
    @Autowired
    private PurchaseRequestService purchaseRequestService;

    @RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<PurchaseRequest> getPurchaseRequest(@PathVariable("id") int id){
        try{
            return new ResponseEntity<PurchaseRequest>(purchaseRequestService.getPurchaseRequestById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<PurchaseRequest>(HttpStatus.BAD_REQUEST);
        }
    }
}
