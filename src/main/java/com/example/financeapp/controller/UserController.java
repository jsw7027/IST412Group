/**
 * COPYRIGHT (C) 2021 Group 4: David Hernandez, Jennifer Lewis, Seung Jung, Daniel O'Donnell. All Rights Reserved.
 * Group Project M04-A03
 *
 * @author Seung Jung
 * @version 1.01 2021-11-27
 */
package com.example.financeapp.controller;

import com.example.financeapp.model.Investment;
import com.example.financeapp.model.LoanApplication;
import com.example.financeapp.model.User;
import com.example.financeapp.repository.UserRepository;
import com.example.financeapp.service.UserService;
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
//UserController class handles switching and loading menu screens for the user to navigate through
public class UserController {

    //Handles accessibility to other classes
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    //Enables user to view home page
    @GetMapping("/")
    public String viewHomePage(Model model){
        User user = new User();
        model.addAttribute("listUser", userService.getAllUsers());
        model.addAttribute("user", user);
        return "index";
    }

    //Enables the user to view the employee screen
    @GetMapping("/EmployeeScreen")
    public String showEmployeeScreen(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "EmployeeScreen";
    }

    //Enables the user to view the customer screen
    @GetMapping("/CustomerScreen")
    public String showCustomerScreen(@ModelAttribute("user")User user, Model model){
        model.addAttribute("user",user);
        return "CustomerScreen";
    }

    //Displays a new user form
    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "SignUp";
    }

    //Displays loanee data as a list
    @GetMapping("/showLoaneeData")
    public String showLoaneeData(Model model){
        List<User> userList = userService.getAllUsers();
        ArrayList<User> customers = new ArrayList<User>();
        for(int i=0; i<userList.size();i++){
            if(userList.get(i).getUserType().equals("customer")){
                customers.add(userList.get(i));
            }
        }
        model.addAttribute("customerList", customers);

        return "LoaneeDataView";
    }


    @GetMapping("/showInvestorData")
    public String showInvestorData(Model model){
        List<User> userList = userService.getAllUsers();
        ArrayList<User> investors = new ArrayList<User>();
        for(int i=0; i<userList.size();i++){
            if(userList.get(i).getUserType().equals("Investor")){
                investors.add(userList.get(i));
            }
        }
        model.addAttribute("investorList", investors);

        return "InvestorDataView";
    }

    @GetMapping("/userList")
    public String viewUserPage(Model model) {
        model.addAttribute("listUser", userService.getAllUsers());
        return "user_list";
    }

//save customer accounts
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/user_list";
    }
    
    //update list of customer accounts
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value="id") String id, Model model) {
        Optional<User> user  = userService.getUserById(id);
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        model.addAttribute("user", user);
        return "update_user";
    }
    //Handles finding the user data in a list and sorts it.
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model){
        int pageSize = 5;

        Page<User> page = userService.findPaginated(pageNo, pageSize, sortField,sortDir);
        List<User> listUsers = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reserveSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listUsers", listUsers);

        return "index";


    }

}
