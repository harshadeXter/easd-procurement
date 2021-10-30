package com.esad.procurement.controller;

import com.esad.procurement.entity.Employee;
import com.esad.procurement.entity.Supplier;
import com.esad.procurement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public String viewEmployeeListPage(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return findPaginated(1, "firstName", "asc", model);
    }

    @PostMapping("/saveEmployee")
    public String saveSupplier(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployeeDetails(employee);
        return "redirect:/employees";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        this.employeeService.removeEmployee(id);
        return "redirect:/employees";
    }

    @GetMapping("/employeePage/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 15;

        Page<Employee> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Employee> listEmployees = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listEmployees", listEmployees);
        return "employees";
    }
}
