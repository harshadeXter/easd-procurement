package com.esad.procurement.service;

import com.esad.procurement.entity.SupplierInvoice;
import com.esad.procurement.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<SupplierInvoice> getAllInvoice() {
        return invoiceRepository.findAll();
    }

    @Override
    public void saveInvoiceDetails(SupplierInvoice invoice) {
        this.invoiceRepository.save(invoice);
    }

    @Override
    public SupplierInvoice getInvoiceById(long id) {
        SupplierInvoice invoice = null;
        Optional<SupplierInvoice> existInvoice = invoiceRepository.findById(id);
        if (existInvoice.isPresent()) {
            invoice = existInvoice.get();
        } else {
            throw new RuntimeException(" No Invoice detail found for id : " + id);
        }
        return invoice;
    }

    @Override
    public void removeInvoice(long id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public Page<SupplierInvoice> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.invoiceRepository.findAll(pageable);
    }
}
