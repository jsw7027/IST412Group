package com.example.financeapp.controller;

import com.example.financeapp.model.User;
import com.example.financeapp.repository.UserRepository;
import com.example.financeapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String viewHomePage(Model model){
        User user = new User();
        model.addAttribute("listUser", userService.getAllUsers());
        model.addAttribute("user", user);
        return "index";
    }


    @PostMapping("/login2")
    @ResponseBody
    public String login2(@ModelAttribute("user")User user) {
        System.out.println("asfad");
        Optional<User> optional = userService.getUserById(user.getUserId());
        String result =" ";
        User foundUser = null;
        if(optional.isPresent()){
            foundUser = optional.get();
            if (foundUser.getUserId().equals(user.getUserId())) {
                if(foundUser.getUserPw().equals(user.getUserPw())){
                    result="Login Success";
                }else{
                    result= "wrong password";
                }
            }
        }else{
            result = "Wrong User";
        }
        return result;
    }

    @GetMapping("/showNewUserForm")
    public String showNewStudentForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "SignUp";
    }


    @PostMapping("/signUp")
    @ResponseBody
    public String signUp(@ModelAttribute("user")User user) {
        userService.saveUser(user);
        return"redirect:/";
    }




}
