package com.esad.procurement.service;

import com.esad.procurement.entity.Employee;
import com.esad.procurement.entity.Item;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployeeDetails(Employee employee);

    Employee getEmployeeById(long id);

    void removeEmployee(long id);

    Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
