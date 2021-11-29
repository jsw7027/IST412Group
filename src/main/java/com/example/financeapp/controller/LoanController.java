/**
 * COPYRIGHT (C) 2021 Group 4: David Hernandez, Jennifer Lewis, Seung Jung, Daniel O'Donnell. All Rights Reserved.
 * Group Project M04-A03
 *
 * @author Seung Jung
 * @version 1.01 2021-11-27
 */
package com.example.financeapp.controller;


import com.example.financeapp.model.LoanApplication;
import com.example.financeapp.model.User;
import com.example.financeapp.repository.LoanRepository;
import com.example.financeapp.service.LoanService;
import com.example.financeapp.service.UserServiceImpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
//LoanController class handles switching and loading loan screens
public class LoanController {

    //Handles accessibility to other classes
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private LoanService loanService;
    @Autowired
    private UserController userController;
    @Autowired
    private UserServiceImpt userServiceImpt;

    //Gets the loan list
    @GetMapping("/loanList")
    public String viewLoanPage(Model model){
        model.addAttribute("listLoans", loanService.getAllLoan());
        return "LoanAppView";
    }

    //Enables getting and viewing a list my loans
    @GetMapping ("/myLoan/{id}")
    public String viewMyLoan(@PathVariable (value="id")String id, @ModelAttribute("user")User user ,Model model) {
        List<LoanApplication> all = loanService.getAllLoan();
        List<LoanApplication> myList = new ArrayList<>();
        for(int i=0; i<all.size(); i++){
            if(all.get(i).getCustomerId().equals(id)){
                myList.add(all.get(i));
            }
        }
        System.out.println(id);
        user.setUserId(id);
        System.out.println(user.getUserId());
        model.addAttribute("myList", myList);
        return "myLoanList";
    }

    //Loads a new application
    @GetMapping("/ViewUploadApplication")
    public String viewUploadApplication(Model model){
        LoanApplication loanApplication = new LoanApplication();
        model.addAttribute("loan", loanApplication);
        return "new_Loan";
    }

    //Saves a loan and logic determines approval
    @PostMapping("/saveLoan")
    public String saveLoan(@ModelAttribute("loan") LoanApplication loanApplication, Model model){
        int credit = Integer.parseInt(loanApplication.getCustomerCredit());
        String sId = loanApplication.getCustomerId();
        if(credit<5){
            loanApplication.setStatus("denied(lowCredit)");
        }else if(credit<8){
            loanApplication.setStatus("pending(credit need review)");
        }else{
            loanApplication.setStatus("Approved");
        }

        loanService.saveLoan(loanApplication);
        model.addAttribute("loan",loanApplication);
        return"redirect:/showLoanForm/"+sId;
    }

    //Updates the loan application
    @PostMapping("/updateLoan")
    public String updateLoan(@ModelAttribute("loan") LoanApplication loanApplication){
        loanService.saveLoan(loanApplication);
        return"redirect:/loanList";
    }

    //Displays a new loan form
    @GetMapping("/showLoanForm/{id}")
    public String showNewLoanForm(@PathVariable (value="id") String id, @ModelAttribute("user")User user ,Model model){
        LoanApplication la = new LoanApplication();
        model.addAttribute("loan", la);
        la.setCustomerId(id);
        user.setUserId(id);
        return "WriteLoan";
    }

    //provides a status update view for the loan application
    @GetMapping("/statusUpdateView/{id}")
    public String statusUpdateView(@PathVariable (value="id") long id,Model model){
        LoanApplication loanApplication = loanService.getLoanById(id);
        model.addAttribute("loan", loanApplication);
        return "update_loan";

    }




}
