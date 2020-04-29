package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.UserDao;

@Controller
public class MainController {

    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/register")
    public String registerPage()
    {
        return "register";
    }

    @PostMapping("/home")
    public String userValidation(@RequestParam("username") String name, @RequestParam("password") String pass, Model model){
        
    	String passwordFromDb = new UserDao().getPassword(name);
    			if(passwordFromDb.equals(pass)) {
    				System.out.println("password from db is " + passwordFromDb);
    				return "welcome";
    			}
        else {
            model.addAttribute("errmsg","Invalid credentials!!");
//            model.addAttribute("user",name);
            return "login";
        }
    }
    
    @PostMapping("/registration")
    public String userRegistration(@RequestParam("username") String username, @RequestParam("email") String email, @RequestParam("password") String password, Model model){
    				System.out.println(email+" "+ password);
    				boolean isSaved = new UserDao().registerUser(username, email, password);
    				if(isSaved) {
    					return "login";
    				}
    				else {
    					model.addAttribute("errMsg", "User creation Failed!");
    					return "register";
    				}
    }
}
