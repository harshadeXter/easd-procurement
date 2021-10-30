package com.esad.procurement.controller;


import com.esad.procurement.service.PurchaseOrderService;
import com.esad.procurement.entity.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PurchaseOrderController {
    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @GetMapping("/purchaseOrder")
    public String viewItemListPage(Model model) {
       PurchaseOrder purchaseOrder= new PurchaseOrder();
        model.addAttribute("purchaseOrder", purchaseOrder);
        return findPaginated(1, "id", "asc", model);
    }

    @PostMapping("/purchaseOderSave")
    public String saveItem(@ModelAttribute("purchaseOder") PurchaseOrder purchaseOrder){
        purchaseOrderService.savePurchaseDetails(purchaseOrder);
        return "redirect:/purchaseOrder";
    }

    @GetMapping("/purchaseOderDelete/{id}")
    public String deleteItem(@PathVariable(value = "id") long id) {
        this.purchaseOrderService.removePurchase(id);
        return "redirect:/purchaseOrder";
    }

    @GetMapping("/purchaseOderPage/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<PurchaseOrder> page = purchaseOrderService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<PurchaseOrder> listPurchaseOder = page.getContent();

        System.out.println("page content " + listPurchaseOder);

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listPurchaseOder", listPurchaseOder);
        System.out.println("modal " + model);
        return "purchaseOrder";
    }



}
