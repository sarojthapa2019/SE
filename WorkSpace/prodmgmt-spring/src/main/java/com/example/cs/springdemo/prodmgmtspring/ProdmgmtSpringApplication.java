package com.example.cs.springdemo.prodmgmtspring;

import com.example.cs.springdemo.prodmgmtspring.model.Product;
import com.example.cs.springdemo.prodmgmtspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class ProdmgmtSpringApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(ProdmgmtSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Product p = new Product(1001L,"iPhone XS Max", 1500.00f,
                LocalDate.of(2019, Month.OCTOBER,22));
        Product savedP = saveProduct(p);
        System.out.println(savedP);
    }
    Product saveProduct(Product p){
        return this.repository.save(p);

    }
    List<Product> getSpecialProduct(Float f){
        return this.repository.findProductsByUnitPriceGreaterThan(f);
    }
}
