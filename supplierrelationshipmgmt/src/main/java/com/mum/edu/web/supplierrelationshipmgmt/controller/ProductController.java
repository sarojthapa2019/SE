package com.mum.edu.web.supplierrelationshipmgmt.controller;

import com.mum.edu.web.supplierrelationshipmgmt.model.Product;
import com.mum.edu.web.supplierrelationshipmgmt.service.ProductService;
import com.mum.edu.web.supplierrelationshipmgmt.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ProductController {

    private ProductService productSetvice;
    private SupplierService supplierService;
    @Autowired
    public ProductController(ProductService productSetvice, SupplierService supplierService){
        this.productSetvice = productSetvice;
        this.supplierService = supplierService;
    }

    @GetMapping(value = {"/product/list"})
    public ModelAndView showAllProduct(@RequestParam(defaultValue="0") int pageNo){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", productSetvice.getAllProduct(pageNo));
        modelAndView.addObject("supplier", supplierService.getAllSupplier());
        modelAndView.addObject("pageNo",pageNo);
        modelAndView.setViewName("product/list");
        return modelAndView;
    }

    @GetMapping(value = {"/product/add"})
    public String displayProductForm(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("supplierList",supplierService.getAllSupplier());
        return "product/add";
    }

    @PostMapping(value = {"/product/save"})
    public String saveProduct(@Valid @ModelAttribute("product") Product product,
                              BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",bindingResult.getAllErrors());
            return "product/add";
        }
        productSetvice.saveProduct(product);
        return "redirect:/product/list";
    }
}
