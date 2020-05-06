	package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.dao.UserDao;

@Controller
@SessionAttributes("userid")
public class MainController {

    @RequestMapping("/login")
    public String loginPage(HttpSession session){
    	if(session.getAttribute("userid") != null) {
    		return "welcome";
    	}
        return "login";
    }

    @RequestMapping("/register")
    public String registerPage()
    {
        return "register";
    }
    
    @RequestMapping("/welcome")
    public String welcomePage(HttpSession session)
    {
    	if(session.getAttribute("userid") == null) {
    		return "login";
    	}
        return "welcome";
    }

    @PostMapping("/home")
    public String userValidation(@RequestParam("username") String name, @RequestParam("password") String pass, Model model){
        
    	String passwordFromDb = new UserDao().getPassword(name);
    			if(passwordFromDb.equals(pass)) {
    				model.addAttribute("userid", name);
//    				System.out.println("password from db is " + passwordFromDb);
    				return "welcome";
    			}
        else {
            model.addAttribute("errmsg","Invalid credentials!!");
//            model.addAttribute("user",name);
            return "login";
        }
    }
    
    @PostMapping("/registration")
    public String userRegistration(@RequestParam("username") String username,@RequestParam("dob") String dob,
    		@RequestParam("gender") String gender, @RequestParam("email") String email,
    		@RequestParam("password") String password,@RequestParam("repassword") String repassword, Model model){
    	if(!password.equals(repassword)) {
    		model.addAttribute("username", username);
    		model.addAttribute("dob", dob);
    		model.addAttribute("gender", gender);
    		model.addAttribute("email", email);
    		model.addAttribute("password", password);
    		model.addAttribute("repassword", repassword);
    		model.addAttribute("errmsg", "Two password do not match");
			return "register";
    	}
    	boolean isSaved = new UserDao().registerUser(username,dob, gender, email, password);
    				if(isSaved) {
    					return "login";
    				}	
    				else {
    					model.addAttribute("errmsg", "User creation Failed!");
    					return "register";
    				}
    }
    
    @RequestMapping("/changepassword")
    public String changePassword()
    {
        return "changePassword";
    }
    
    @RequestMapping("/updatePassword")
    public String updatePassword()
    {
        return "updatePassword";
    }
    
    @RequestMapping("/studentList")
    public String stdList(HttpSession session)
    {
    	if(session.getAttribute("userid") == null) {
    		return "login";
    	}
        return "studentList";
    }
}
