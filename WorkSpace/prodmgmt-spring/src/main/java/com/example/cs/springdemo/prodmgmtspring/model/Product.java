package com.example.cs.springdemo.prodmgmtspring.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "products2")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public LocalDate getDateMfd() {
        return dateMfd;
    }

    public void setDateMfd(LocalDate dateMfd) {
        this.dateMfd = dateMfd;
    }

    private Long productNumber;
    private String name;
    private Float unitPrice;
    private LocalDate dateMfd;

    public Product() {
        super();
    }

    public Product( Long productNumber, String name, Float unitPrice, LocalDate dateMfd) {

        this.productNumber = productNumber;
        this.name = name;
        this.unitPrice = unitPrice;
        this.dateMfd = dateMfd;
    }

    @Override
    public String toString() {
        return "Product{" + "product id="+pid +
                "productNumber=" + productNumber +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", dateMfd=" + dateMfd +
                '}';
    }
}
