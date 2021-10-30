package com.esad.procurement.controller.restController;

import com.esad.procurement.entity.SupplierInvoice;
import com.esad.procurement.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/invoice")
public class InvoiceRestController {
    @Autowired
    private InvoiceService invocieService;

    @RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<SupplierInvoice> getInvoice(@PathVariable("id") int id) {
        try {
            return new ResponseEntity<SupplierInvoice>(invocieService.getInvoiceById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<SupplierInvoice>(HttpStatus.BAD_REQUEST);
        }
    }

}
