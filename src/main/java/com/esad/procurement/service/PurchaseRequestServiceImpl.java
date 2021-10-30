package com.esad.procurement.service;

import com.esad.procurement.entity.PurchaseRequest;
import com.esad.procurement.repository.PurchaseRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseRequestServiceImpl implements PurchaseRequestService {
    @Autowired
    private PurchaseRequestRepository purchaseRequestRepository;

    @Override
    public List<PurchaseRequest> getAllPurchaseRequestById(long id) {
        return purchaseRequestRepository.getAllPurchaseRequestsByUserId(id);
    }

    @Override
    public List<PurchaseRequest> getAllPurchaseRequests() {
        return purchaseRequestRepository.findAll();
    }

    @Override
    public void savePurchaseRequest(PurchaseRequest purchaseRequest) {
        this.purchaseRequestRepository.save(purchaseRequest);
    }

    @Override
    public PurchaseRequest getPurchaseRequestById(long id) {
        PurchaseRequest purchaseRequest = null;
        Optional<PurchaseRequest> existPurchaseRequest = purchaseRequestRepository.findById(id);
        if (existPurchaseRequest.isPresent()){
            purchaseRequest = existPurchaseRequest.get();
        } else {
            throw new RuntimeException("No Purchase Request Details found for id " + id);
        }
        return purchaseRequest;
    }

    @Override
    public void removePurchaseRequest(long id) {
        this.purchaseRequestRepository.deleteById(id);
    }

    @Override
    public Page<PurchaseRequest> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.purchaseRequestRepository.findAll(pageable);
    }
}
