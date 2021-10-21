package com.esad.procurement.controller;


import com.esad.procurement.entity.Supplier;
import com.esad.procurement.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/suppliers")
    public String viewHomePage(Model model) {
        Supplier supplier = new Supplier();
        model.addAttribute("supplier", supplier);
        return findPaginated(1, "supplierName", "asc", model);
    }

    @PostMapping("/saveSupplier")
    public String saveEmployee(@ModelAttribute("supplier") Supplier supplier) {
        System.out.println("web Sup" + supplier);
        supplierService.saveSupplierDetails(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping("/deleteSupplier/{id}")
    public String deleteSupplier(@PathVariable(value = "id") long id) {
        this.supplierService.removeSupplier(id);
        return "redirect:/suppliers";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Supplier> page = supplierService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Supplier> listSuppliers = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listSuppliers", listSuppliers);
        return "index";
    }

}
