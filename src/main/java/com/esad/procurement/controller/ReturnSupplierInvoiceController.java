package com.esad.procurement.controller;

import com.esad.procurement.entity.Item;
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

    @GetMapping("/returnSupplierInvoice")
    public String viewReturnSupplierInvoice(Model model) {

        ReturnSupplierInvoice returnSupplierInvoice = new ReturnSupplierInvoice();
        PurchaseOrderLine purchaseOrderLine = new PurchaseOrderLine();
        model.addAttribute("purchaseOrderLine", purchaseOrderLine);
        model.addAttribute("returnSupplierInvoice", returnSupplierInvoice);
        model.addAttribute("id", returnSupplierInvoice.getId());
        model.addAttribute("invoiceId", returnSupplierInvoice.getInvoiceId());
        model.addAttribute("poReference", returnSupplierInvoice.getPoReference());
        model.addAttribute("supplierReference", returnSupplierInvoice.getSupplierReference());
        model.addAttribute("paidBy", returnSupplierInvoice.getPaidBy());
        model.addAttribute("paidOn", returnSupplierInvoice.getPaidOn());
        model.addAttribute("totalAmount", returnSupplierInvoice.getTotalAmount());
        return findPaginated(1, "id", "asc", model);
    }

    @GetMapping("/returnSupplier")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
            int pageSize = 5;
            Page<PurchaseOrderLine> page = returnSupplierService.findPaginated(pageNo, pageSize, sortField, sortDir);
            List<PurchaseOrderLine> listPurchaseLines = page.getContent();
            model.addAttribute("currentPage", pageNo);
            model.addAttribute("totalPages", page.getTotalPages());
            model.addAttribute("totalItems", page.getTotalElements());
            model.addAttribute("sortField", sortField);
            model.addAttribute("sortDir", sortDir);
            model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
            model.addAttribute("listPurchaseLines", listPurchaseLines);

            return "return_sup_invoice";
        }

    @PostMapping("/saveSupplierInvoice")
    public String saveReturnSupplier(@ModelAttribute("returnSupplierInvoice") ReturnSupplierInvoice returnSupplierInvoice) {
        returnSupplierService.saveReturnSupplierInvoice(returnSupplierInvoice);
        return "redirect:/returnSupplierInvoice";
    }


    @PostMapping("/updatePOLine")
    public String updatePOLine(@ModelAttribute("purchaseOrderLine") PurchaseOrderLine purchaseOrderLine) {
        returnSupplierService.savepurchaseOrderLine(purchaseOrderLine);
        return "redirect:/returnSupplierInvoice";
    }
}
