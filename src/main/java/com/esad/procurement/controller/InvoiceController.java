package com.esad.procurement.controller;

import com.esad.procurement.entity.SupplierInvoice;
import com.esad.procurement.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/invoices")
    public String viewSupplierListPage(Model model) {
        SupplierInvoice invoice = new SupplierInvoice();
        model.addAttribute("invoice", invoice);
        return findPaginated(1, "id", "asc", model);
    }

    @PostMapping("/saveInvoice")
    public String saveInvoices(@ModelAttribute("invoice") SupplierInvoice invoice) {
        invoiceService.saveInvoiceDetails(invoice);
        return "redirect:/invoices";
    }

    @GetMapping("/deleteInvoice/{id}")
    public String deleteInvoice(@PathVariable(value = "id") long id) {
        this.invoiceService.removeInvoice(id);
        return "redirect:/invoices";
    }

    @GetMapping("/invoicePage/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 15;

        Page<SupplierInvoice> page = invoiceService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<SupplierInvoice> listInvoices = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listInvoices", listInvoices);
        return "invoices";
    }
}
