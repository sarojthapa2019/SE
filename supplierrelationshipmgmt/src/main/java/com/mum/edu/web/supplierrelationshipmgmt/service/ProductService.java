package com.mum.edu.web.supplierrelationshipmgmt.service;

import com.mum.edu.web.supplierrelationshipmgmt.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    public abstract Page<Product> getAllProduct(int pageNo);
    void saveProduct(Product product);
}
