package edu.mum.cs.cs425.finalexam.midwestenbankwebapp.controller;

import edu.mum.cs.cs425.finalexam.midwestenbankwebapp.model.Customer;
import edu.mum.cs.cs425.finalexam.midwestenbankwebapp.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping(value = "/midwestenbank/secure/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping(value={"/list"})
    public ModelAndView listCustomers(@RequestParam(defaultValue = "0") int pageno) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("customers", customerService.getAllCustomers(pageno));
        mav.addObject("currentPageNo", pageno);
        mav.addObject("now", LocalDate.now());
        mav.setViewName("secure/customer/list");
        return mav;
    }

    @GetMapping(value={"/new"})
    public String newCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("now", LocalDate.now());
        return "secure/customer/new";
    }

    @PostMapping(value = {"/new"})
    public String registerNewCustomer(
            @Valid
            @ModelAttribute("customer")
            Customer customer,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secure/customer/new";
        }
        customerService.registerNewCustomer(customer);
        return "redirect:/midwestenbank/secure/customers/list";
    }

}
