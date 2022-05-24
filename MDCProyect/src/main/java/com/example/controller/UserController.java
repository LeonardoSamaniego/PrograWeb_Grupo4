package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entities.User;
import com.example.service.ProductoService;
import com.example.service.UserService;

@Controller
public class UserController {
	
	private ProductoService productService;
	private UserService userService;
	
	public UserController(ProductoService productService,UserService userService) {
		this.productService = productService;
		this.userService = userService;
	}
	
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
	    return "login";
	}  

	@PostMapping("/login")
	public String signIn(Model model, @ModelAttribute("user") User user , 
			RedirectAttributes attributes , HttpSession sesion) {
		User userLog = this.userService.getByEmailandPass(user);
		
		if(userLog != null) {
			sesion.setAttribute("user", userLog);
			return "redirect:/home";
		}else {
			attributes.addFlashAttribute("error", "Email y/o password incorrecto.");
			return "redirect:/login";
		}
	}  
	
	@GetMapping("/logout")
	public String logout(Model model,HttpSession sesion) {
		sesion.setAttribute("user", null);
	    return "redirect:/login";
	}  
	
	@GetMapping("/signIn")
	public String signIn(Model model) {
		model.addAttribute("user", new User());
	    return "signIn";
	}  
	
	@PostMapping("/register")
	public String register(Model model , @ModelAttribute("user") User user) {
		try {
			this.userService.insert(user);
		    return "redirect:/home";
		}catch(Exception ex){
			 return "signIn";
		}
	}  
	
	@GetMapping("/myProducts")
	public String myProducts(Model model) {
		
	    return "myProducts";
	} 
}
