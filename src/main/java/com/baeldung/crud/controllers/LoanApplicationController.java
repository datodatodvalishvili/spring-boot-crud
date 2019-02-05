package com.baeldung.crud.controllers;

import javax.validation.Valid;

import com.baeldung.crud.entities.LoanApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.baeldung.crud.repositories.LoanApplicationRepository;

@Controller
public class LoanApplicationController {
    
    private final LoanApplicationRepository loanApplicationRepository;

    @Autowired
    public LoanApplicationController(LoanApplicationRepository loanApplicationRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
    }

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("users", loanApplicationRepository.findAll());
        return "index"; }

    @GetMapping("/signup")
    public String showSignUpForm(LoanApplication loanApplication) {
        return "add-loanApplication";
    }
    @PostMapping("/addLoanApplication")
    public String addUser(@Valid LoanApplication loanApplication, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-loanApplication";
        }
        
        loanApplicationRepository.save(loanApplication);

        model.addAttribute("users", loanApplicationRepository.findAll());

        return "index";
    }

    @GetMapping("/mark/{id}")
    public String markLoanApplication(@PathVariable("id") long id, Model model) {
        LoanApplication loanApplication = loanApplicationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid loanApplication Id:" + id));
        loanApplication.markStatus();
        model.addAttribute("users", loanApplicationRepository.findAll());

        return "index";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        LoanApplication loanApplication = loanApplicationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid loanApplication Id:" + id));
        loanApplicationRepository.delete(loanApplication);
        model.addAttribute("users", loanApplicationRepository.findAll());

        return "index";
    }
}
