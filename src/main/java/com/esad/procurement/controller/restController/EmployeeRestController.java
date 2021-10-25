package com.esad.procurement.controller.restController;

import com.esad.procurement.entity.Employee;
import com.esad.procurement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/employee")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
        try {
            return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
        }
    }

}
