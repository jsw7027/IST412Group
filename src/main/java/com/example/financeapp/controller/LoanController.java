package com.example.financeapp.controller;


import com.example.financeapp.model.LoanApplication;
import com.example.financeapp.model.User;
import com.example.financeapp.repository.LoanRepository;
import com.example.financeapp.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private LoanService loanService;

    UserController userController;

    @GetMapping("/loanList")
    public String viewLoanPage(Model model){
        model.addAttribute("listLoans", loanService.getAllLoan());
        return "LoanAppView";
    }

    @GetMapping ("/myLoan/{id}")
    public String viewMyLoan(@PathVariable (value="id")String id, Model model) {
        List<LoanApplication> all = loanService.getAllLoan();
        List<LoanApplication> myList = new ArrayList<>();
        for(int i=0; i<all.size(); i++){
            if(all.get(i).getCustomerId().equals(id)){
                myList.add(all.get(i));
            }
        }
        System.out.println(id);
        model.addAttribute("myList", myList);
        return "myLoanList";
    }

    @GetMapping("/ViewUploadApplication")
    public String viewUploadApplication(Model model){
        LoanApplication loanApplication = new LoanApplication();
        model.addAttribute("loan", loanApplication);
        return "new_Loan";
    }

    @PostMapping("/saveLoan")
    public String saveLoan(@ModelAttribute("loan") LoanApplication loanApplication){
        int credit = Integer.parseInt(loanApplication.getCustomerCredit());
        if(credit<5){
            loanApplication.setStatus("denied(lowCredit)");
        }else if(credit<8){
            loanApplication.setStatus("pending(credit need review)");
        }else{
            loanApplication.setStatus("Approved");
        }

        loanService.saveLoan(loanApplication);
        return"redirect:/CustomerScreen";
    }

    @PostMapping("/updateLoan")
    public String updateLoan(@ModelAttribute("loan") LoanApplication loanApplication){
        loanService.saveLoan(loanApplication);
        return"redirect:/loanList";
    }

    @GetMapping("/showLoanForm")
    public String showNewUserForm(Model model){
        LoanApplication la = new LoanApplication();
        model.addAttribute("la", la);
        return "WriteLoan";
    }


    @GetMapping("/statusUpdateView/{id}")
    public String statusUpdateView(@PathVariable (value="id") long id, Model model){
        LoanApplication loanApplication = loanService.getLoanById(id);
        model.addAttribute("loan", loanApplication);
        return "update_loan";

    }




}
