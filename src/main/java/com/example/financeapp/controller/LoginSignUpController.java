package com.example.financeapp.controller;

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

//This class handles login and sign up.
@Controller
public class LoginSignUpController {

    //Handles accessibility to other classes
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    //Handles the login and authentication
    @GetMapping ("/login2")
    public String login2(@ModelAttribute("user")User user, Model model) {
        Optional<User> optional = userService.getUserById(user.getUserId());
        String result =" ";
        User foundUser = null;
        if(optional.isPresent()){
            foundUser = optional.get();
            if (foundUser.getUserId().equals(user.getUserId())) {
                if(foundUser.getUserPw().equals(user.getUserPw())){
                    if(foundUser.getUserType().equals("eatz01") | foundUser.getUserType().equals("EATZ01") ){
                        result = "EmployeeScreen";
                    }
                    else{ result="CustomerScreen"; }
                }
                else{
                    result= "index";
                }
            }
        }else{
            result = "index";
        }
        return result;
    }

    //Enables the user to save their signup info
    @PostMapping("/signUp")
    public String signUp(@ModelAttribute("user")User user) {
        userService.saveUser(user);
        return"redirect:/";
    }

}
