package com.esad.procurement.controller.restController;

import com.esad.procurement.entity.Item;
import com.esad.procurement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/item")
public class ItemRestController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getItem(@PathVariable("id") int id){
        try{
            return new ResponseEntity<Item>(itemService.getItemById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Item>(HttpStatus.BAD_REQUEST);
        }
    }
}
