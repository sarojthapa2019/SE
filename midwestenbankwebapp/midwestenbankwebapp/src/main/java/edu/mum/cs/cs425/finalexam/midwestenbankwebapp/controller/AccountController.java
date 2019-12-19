package edu.mum.cs.cs425.finalexam.midwestenbankwebapp.controller;

import edu.mum.cs.cs425.finalexam.midwestenbankwebapp.model.Account;
import edu.mum.cs.cs425.finalexam.midwestenbankwebapp.model.AccountType;
import edu.mum.cs.cs425.finalexam.midwestenbankwebapp.model.Customer;
import edu.mum.cs.cs425.finalexam.midwestenbankwebapp.service.IAccountService;
import edu.mum.cs.cs425.finalexam.midwestenbankwebapp.service.IAccountTypeService;
import edu.mum.cs.cs425.finalexam.midwestenbankwebapp.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = "/midwestenbank/secure/accounts")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IAccountTypeService accountTypeService;

    @GetMapping(value={"/list"})
    public ModelAndView listAccounts() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("accounts", accountService.getAllAccounts());
        mav.addObject("netliquidity", accountService.computeNetLiquidity());
        mav.addObject("now", LocalDate.now());
        mav.setViewName("secure/account/list");
        return mav;
    }

    @GetMapping(value = "/new")
    public String newAccountForm(Model model) {
//        loadDataToModel(model);
        List<Customer> customers = customerService.getAllCustomers();
        List<AccountType> accountTypes = accountTypeService.getAllAccountTypes();
        model.addAttribute("account", new Account());
        model.addAttribute("customers", customers);
        model.addAttribute("accountTypes", accountTypes);
        model.addAttribute("now", LocalDate.now());
        return "secure/account/new";
    }

    @PostMapping(value = "/new")
    public String addNewAccount(@Valid @ModelAttribute("account") Account account,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            List<Customer> customers = customerService.getAllCustomers();
            List<AccountType> accountTypes = accountTypeService.getAllAccountTypes();
            model.addAttribute("customers", customers);
            model.addAttribute("accountTypes", accountTypes);
            model.addAttribute("now", LocalDate.now());
//            loadDataToModel(model);
            return "secure/account/new";
        }
        accountService.addNewAccount(account);
        return "redirect:/midwestenbank/secure/accounts/list";
    }

    private void loadDataToModel(Model model) {
//        List<Customer> customers = customerService.getAllCustomers();
//        List<AccountType> accountTypes = accountTypeService.getAllAccountTypes();
//        model.addAttribute("account", new Account());
//        model.addAttribute("customers", customers);
//        model.addAttribute("accountTypes", accountTypes);
//        model.addAttribute("now", LocalDate.now());
    }
}
