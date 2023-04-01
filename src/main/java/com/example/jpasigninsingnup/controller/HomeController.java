package com.example.jpasigninsingnup.controller;

import com.example.jpasigninsingnup.entity.User;
import com.example.jpasigninsingnup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {


    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        return "login";
    }
    @GetMapping("/sign-up")
    public String signUp(Model model){
        model.addAttribute("user",new User());
        return "signup";
    }
    @PostMapping("/register")
    public String register(User user, BindingResult result){
        System.out.println("form------------------"+ user);
        userService.signUp(user);
        return "redirect:/login";
    }

    @GetMapping({"/","/home"})
    public String home(){
        return "home";
    }
    @GetMapping("/products")
    public String listProduct(Model model){
        List<String> fruits=List.of(
                "Apple",
                "Orange",
                "Banana"
        );
        model.addAttribute("fruits",fruits);
        return "products";
    }

}
