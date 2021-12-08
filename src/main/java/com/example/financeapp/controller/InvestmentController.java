package com.example.financeapp.controller;

import com.example.financeapp.model.Investment;
import com.example.financeapp.model.User;
import com.example.financeapp.repository.InvestmentRepository;
import com.example.financeapp.service.InvestmentService;
import com.example.financeapp.service.UserServiceImpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;
    @Autowired
    private InvestmentRepository investmentRepository;
    @Autowired
    private UserController userController;
    @Autowired
    private UserServiceImpt userServiceImpt;

    //Enables the user to view the investor screen
    @GetMapping("/InvestorScreen")
    public String showInvestorScreen(Model model){
        //Investment investment = new Investment();
        //model.addAttribute("investment",investment);
        return "InvestorScreen";
    }

    //Enables the user to view the investor screen
    @GetMapping("/InvestmentView")
    public String showInvestorView( Model model){
        Investment investment = new Investment();
        model.addAttribute("investment",investment);
        return "InvestmentView";
    }

    @PostMapping("/saveInvestment")
    public String saveInvestment(@ModelAttribute("investment") Investment investment, Model model){
        //int credit = Integer.parseInt(loanApplication.getCustomerCredit());
        //String sId = investment.getInvestorId();

        investmentService.saveInvestment(investment);
        model.addAttribute("investment",investment);
        return"redirect:/InvestorScreen";
    }
}
