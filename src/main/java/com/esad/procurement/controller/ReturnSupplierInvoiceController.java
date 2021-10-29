package com.esad.procurement.controller;

import com.esad.procurement.entity.PurchaseOrderLine;
import com.esad.procurement.entity.ReturnSupplierInvoice;
import com.esad.procurement.service.ReturnSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class ReturnSupplierInvoiceController {

    @Autowired
    private ReturnSupplierService returnSupplierService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, "id", "asc", model);
    }

    @PostMapping("/saveSupplierInvoice")
    public String saveReturnSupplier(@ModelAttribute("return_supplier_invoices") ReturnSupplierInvoice returnSupplierInvoice) {
        returnSupplierService.saveReturnSupplierInvoice(returnSupplierInvoice);
        return "redirect:/";
    }

    @GetMapping("/returnSupplier")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
            int pageSize = 5;

            Page<PurchaseOrderLine> page = returnSupplierService.findPaginated(pageNo, pageSize, sortField, sortDir);
            List<PurchaseOrderLine> listPurchaseLines = page.getContent();
            PurchaseOrderLine requestLines = new PurchaseOrderLine();

            model.addAttribute("requestLines", requestLines);
            model.addAttribute("currentPage", pageNo);
            model.addAttribute("totalPages", page.getTotalPages());
            model.addAttribute("totalItems", page.getTotalElements());

            model.addAttribute("sortField", sortField);
            model.addAttribute("sortDir", sortDir);
            model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

            model.addAttribute("listPurchaseLines", listPurchaseLines);
            return "return_sup_invoice";
        }
    }
