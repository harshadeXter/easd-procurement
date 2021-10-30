package com.esad.procurement.controller;

import com.esad.procurement.entity.Shipment;
import com.esad.procurement.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ShipmentController {
    @Autowired
    private ShipmentService shipmentService;

    @GetMapping("/shipments")
    public String viewSupplierListPage(Model model) {
        Shipment shipment = new Shipment();
        model.addAttribute("shipment", shipment);
        return findPaginated(1, "id", "asc", model);
    }

    @PostMapping("/saveShipment")
    public String saveSupplier(@ModelAttribute("shipment") Shipment shipment) {
        shipmentService.saveShipmentDetails(shipment);
        return "redirect:/shipments";
    }

    @GetMapping("/deleteShipment/{id}")
    public String deleteShipment(@PathVariable(value = "id") long id) {
        this.shipmentService.removeShipment(id);
        return "redirect:/shipments";
    }

    @GetMapping("/shipmentPage/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 15;

        Page<Shipment> page = shipmentService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Shipment> listShipments = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listShipments", listShipments);
        return "shipments";
    }
}
