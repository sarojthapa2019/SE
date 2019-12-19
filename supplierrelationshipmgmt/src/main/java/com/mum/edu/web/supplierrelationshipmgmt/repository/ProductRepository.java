package com.mum.edu.web.supplierrelationshipmgmt.repository;

import com.mum.edu.web.supplierrelationshipmgmt.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
