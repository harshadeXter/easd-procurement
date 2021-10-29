package com.esad.procurement.service;

import com.esad.procurement.entity.PurchaseOrderLine;
import com.esad.procurement.entity.PurchaseRequestLines;
import com.esad.procurement.repository.ReturnSupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnSupplierServiceImpl implements ReturnSupplierService {

    @Autowired
    private ReturnSupplierRepository returnSupplierRepository;

    @Override
    public List<PurchaseOrderLine> getAllLines() {
        return returnSupplierRepository.findAll();
    }


    @Override
    public Page<PurchaseOrderLine> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.returnSupplierRepository.findAll(pageable);
    }

}


