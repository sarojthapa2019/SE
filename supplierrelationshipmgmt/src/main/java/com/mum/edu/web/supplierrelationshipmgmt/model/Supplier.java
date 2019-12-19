package com.mum.edu.web.supplierrelationshipmgmt.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SUPPLIERS")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int supplierId;

    @Column(name = "supplier_number", nullable = false, unique = true)
    private Integer supplierNumber;

    private String name;

    private String contactPhoneNumber;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    public Supplier() { }

    public Supplier(Integer supplierNumber, String name, String contactPhoneNumber) {
        this.supplierNumber = supplierNumber;
        this.name = name;
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(Integer supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
