package com.esad.procurement.service;

import com.esad.procurement.entity.Supplier;
import com.esad.procurement.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public void saveSupplierDetails(Supplier supplier) {
        this.supplierRepository.save(supplier);
    }

    @Override
    public Supplier getSupplierById(long id) {
        Optional<Supplier> existSupplier = supplierRepository.findById(id);
        Supplier supplier = null;
        if (existSupplier.isPresent()) {
            supplier = existSupplier.get();
        }else {
            throw new RuntimeException(" No Supplier found for id : " + id);
        }
        return supplier;
    }

    @Override
    public void removeSupplier(long id) {
        this.supplierRepository.deleteById(id);
    }

    @Override
    public Page<Supplier> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.supplierRepository.findAll(pageable);
    }
}
