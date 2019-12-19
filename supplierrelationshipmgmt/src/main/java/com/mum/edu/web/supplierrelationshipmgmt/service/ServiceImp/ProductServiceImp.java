package com.mum.edu.web.supplierrelationshipmgmt.service.ServiceImp;

import com.mum.edu.web.supplierrelationshipmgmt.model.Product;
import com.mum.edu.web.supplierrelationshipmgmt.repository.ProductRepository;
import com.mum.edu.web.supplierrelationshipmgmt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Page<Product> getAllProduct(int pageNo) {
        return productRepository.findAll(PageRequest.of(pageNo,3, Sort.by("name")));
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
