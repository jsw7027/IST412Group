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
    public String showInvestorScreen(@ModelAttribute("user")User user, Model model) {
        model.addAttribute("user",user);
        return "InvestorScreen";
    }

    //Enables the user to view the investor screen
    @GetMapping("/InvestmentView/{id}")
    public String showInvestorView(@PathVariable(value = "id") String id, @ModelAttribute("user") User user, Model model) {
        Investment in = new Investment();
        model.addAttribute("investment", in);
        in.setInvestorId(id);
        user.setUserId(id);
        return "InvestmentView";
    }

    @GetMapping("/showInvestorData")
    public String showInvestorData(Model model){
        model.addAttribute("investorList", investmentService.getAllInvestments());
        return "InvestorDataView";
    }

    @PostMapping("/saveInvestment")
    public String saveInvestment(@ModelAttribute("investment") Investment investment, Model model) {
        {
            investmentService.saveInvestment(investment);
            model.addAttribute("investment",investment);
            String inId = investment.getInvestorId();
            return "redirect:/InvestmentView/"+inId;
        }
    }
}
