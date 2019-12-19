package com.mum.edu.web.supplierrelationshipmgmt.service.ServiceImp;

import com.mum.edu.web.supplierrelationshipmgmt.model.Supplier;
import com.mum.edu.web.supplierrelationshipmgmt.repository.SupplierRepository;
import com.mum.edu.web.supplierrelationshipmgmt.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SupplierServiceImp implements SupplierService {
    @Autowired
    SupplierRepository supplierRepository;
    @Override
    public List<Supplier> getAllSupplier() {
        return supplierRepository.findAll();
    }
}
