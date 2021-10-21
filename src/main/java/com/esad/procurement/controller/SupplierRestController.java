package com.esad.procurement.controller;

import com.esad.procurement.entity.Supplier;
import com.esad.procurement.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/supplier")
public class SupplierRestController {
    @Autowired
    private SupplierService supplierService;

    @RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Supplier> getSupplier(@PathVariable("id") int id){
        try{
            return new ResponseEntity<Supplier>(supplierService.getSupplierById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Supplier>(HttpStatus.BAD_REQUEST);
        }
    }
}
