package edu.mum.se.demo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name ="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pid;
    private long productNumber;
    private String name;

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(long productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public LocalDate getDateMfd() {
        return dateMfd;
    }

    public void setDateMfd(LocalDate dateMfd) {
        this.dateMfd = dateMfd;
    }

    private float unitPrice;
    private LocalDate dateMfd;

    public Product(){
        super();
    }

    public Product( long productNumber, String name, float unitPrice, LocalDate dateMfd) {
        this.productNumber = productNumber;
        this.name = name;
        this.unitPrice = unitPrice;
        this.dateMfd = dateMfd;
    }

    @Override
    public String toString() {
        return "Product{ productNumber=" + productNumber +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", dateMfd=" + dateMfd +
                '}';
    }
}
