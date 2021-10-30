package com.esad.procurement.controller;


import com.esad.procurement.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PurchaseOrder {
    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @GetMapping("/items")
    public String viewItemListPage(Model model) {
       PurchaseOrder purchaseOrder= new PurchaseOrder();
        model.addAttribute("item", purchaseOrder);
        return findPaginated(1, "itemDescription", "asc", model);
    }

    @PostMapping("/saveItem")
    public String saveItem(@ModelAttribute("item") com.esad.procurement.entity.PurchaseOrder purchaseOrder) {
        purchaseOrderService.savePurchaseDetails(purchaseOrder);
        return "redirect:/items";
    }

    @GetMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable(value = "id") long id) {
        this.itemService.removeItem(id);
        return "redirect:/items";
    }

    @GetMapping("/itemPage/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Item> page = itemService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Item> listItems = page.getContent();

        System.out.println("page content " + listItems);

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listItems", listItems);
        System.out.println("modal " + model);
        return "items";
    }



}
