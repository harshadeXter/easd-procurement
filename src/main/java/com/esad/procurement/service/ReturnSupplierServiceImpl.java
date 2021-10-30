package com.esad.procurement.service;

import com.esad.procurement.entity.Item;
import com.esad.procurement.entity.PurchaseOrderLine;
import com.esad.procurement.entity.ReturnSupplierInvoice;
import com.esad.procurement.repository.PurchaseOrderLineRepository;
import com.esad.procurement.repository.ReturnSupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReturnSupplierServiceImpl implements ReturnSupplierService {

    @Autowired
    private ReturnSupplierRepository returnSupplierRepository;

    @Autowired
    private PurchaseOrderLineRepository purchaseOrderLineRepository;

    @Override
    public List<ReturnSupplierInvoice> getSupplierInvoice() {
        return returnSupplierRepository.findAll();
    }

    @Override
    public List<PurchaseOrderLine> getPurchaseOrderLine() {
        return purchaseOrderLineRepository.findAll();
    }

    @Override
    public PurchaseOrderLine getPOLineById(long id) {
        PurchaseOrderLine purchaseOrderLine = null;
        Optional<PurchaseOrderLine> existLine = purchaseOrderLineRepository.findById(id);

        if (existLine.isPresent()) {
            purchaseOrderLine = existLine.get();
        } else {
            throw new RuntimeException(" No Item found for id : " + id);
        }
        return purchaseOrderLine;
    }

    @Override
    public void saveReturnSupplierInvoice(ReturnSupplierInvoice returnSupplierInvoice) {
        this.returnSupplierRepository.save(returnSupplierInvoice);
    }

    @Override
    public Page<PurchaseOrderLine> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.purchaseOrderLineRepository.findAll(pageable);
    }

}


