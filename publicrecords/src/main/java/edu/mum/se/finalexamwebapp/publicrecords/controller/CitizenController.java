package edu.mum.se.finalexamwebapp.publicrecords.controller;

import edu.mum.se.finalexamwebapp.publicrecords.model.Citizen;
import edu.mum.se.finalexamwebapp.publicrecords.service.CitizenService;
import edu.mum.se.finalexamwebapp.publicrecords.service.StateService;
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
public class CitizenController {
    private CitizenService citizenService;
    private StateService stateService;

    @Autowired
    public CitizenController(CitizenService citizenService, StateService stateService){
        this.citizenService = citizenService;
        this.stateService = stateService;
    }

    @GetMapping(value = {"/citizen/list"})
    public ModelAndView showList(@RequestParam(defaultValue = "0") int pageNo ){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("citizens", citizenService.getAllCitizenPaged(pageNo));
        modelAndView.addObject("total",citizenService.getTotalIncome());
        modelAndView.addObject("currentPageNo", pageNo);
        modelAndView.setViewName("citizen/list");
        return modelAndView;

    }

    @GetMapping(value = {"/citizen/add"})
    public String showAddForm(Model model){
        model.addAttribute("citizen", new Citizen());
        model.addAttribute("stateList", stateService.getAllState());
        return "citizen/add";
    }

    @PostMapping(value = {"/citizen/register"})
    public String registerCitizen(@Valid @ModelAttribute("citizen") Citizen citizen,
                                  BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "citizen/add";
        }
        citizenService.registerCitizen(citizen);
        return  "redirect:/citizen/list";
    }
}
