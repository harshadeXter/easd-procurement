package com.esad.procurement.controller;

import com.esad.procurement.entity.PurchaseRequest;
import com.esad.procurement.service.PurchaseRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PurchaseRequestController {
    @Autowired
    private PurchaseRequestService purchaseRequestService;

    @GetMapping("/purchaseRequests")
    public String viewPurchaseRequestPage(Model model) {
        PurchaseRequest purchaseRequest = new PurchaseRequest();
        model.addAttribute("purchaseRequest", purchaseRequest);
        return findPaginated(1, "id", "asc", model);
    }

    @PostMapping("/savePurchaseRequest")
    public String savePurchaseRequest(@ModelAttribute("purchaseRequest") PurchaseRequest purchaseRequest) {
        purchaseRequestService.savePurchaseRequest(purchaseRequest);
        return "redirect:/purchaseRequests";
    }

    @GetMapping("/deletePurchaseRequest/{id}")
    public String deletePurchaseRequests(@PathVariable(value = "id") long id) {
        this.purchaseRequestService.removePurchaseRequest(id);
        return "redirect:/purchaseRequests";
    }

    @GetMapping("/purchaseRequestPage/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 15;

        Page<PurchaseRequest> page = purchaseRequestService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<PurchaseRequest> listPurchaseRequest = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listPurchaseRequest", listPurchaseRequest);
        return "purchaseRequests";
    }
}
