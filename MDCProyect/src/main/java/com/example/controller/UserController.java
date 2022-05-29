package com.example.controller;

import javax.servlet.http.HttpSession;

import com.example.entities.Product;
import com.example.utils.Constants;
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
	public String register(Model model , @ModelAttribute("user") User user, RedirectAttributes attributes, HttpSession sesion) {
		try {
			if (this.userService.isValidEmail(user.getEmail())) {
				User newUser = this.userService.insert(this.userService.handleUserTypeByEmailDomain(user));
				sesion.setAttribute("user", newUser);
				if (this.userService.getEmailDomain(user.getEmail()).equalsIgnoreCase(Constants.VALID_ADMIN_DOMAIN_EMAIL)) {
					return "redirect:/admiHome";
				} else {
					return "redirect:/home";
				}
			} else {
				attributes.addFlashAttribute("error",
						"The provided email domain is not suppported from [ " + Constants.VALID_ADMIN_DOMAIN_EMAIL + ", " + Constants.VALID_CUSTOMER_DOMAIN_EMAIL + "]");
				return "redirect:/signIn";
			}
		}catch(Exception ex){
			 return "signIn";
		}
	}  
	
	@GetMapping("/myProducts")
	public String myProducts(Model model) {
	    return "myProducts";
	}

	@PostMapping("/saveNewProduct")
	public String saveNewProduct(Model model, @ModelAttribute("product") Product product ,
						 RedirectAttributes attributes , HttpSession sesion) {
		this.productService.insert(product);
		attributes.addFlashAttribute("success", "Product with name [" + product.getName() + "] was created successfully.");
		return  "redirect:admiHome";
	}

	@PostMapping("/registerNewAdminFromAdmin")
	public String registerNewAdminFromAdmin(Model model, @ModelAttribute("admin") User admin ,
								 RedirectAttributes attributes , HttpSession sesion) {
		try {
			if (this.userService.isValidEmail(admin.getEmail()) && this.userService.getEmailDomain(admin.getEmail()).equalsIgnoreCase(Constants.VALID_ADMIN_DOMAIN_EMAIL)) {
				this.userService.insert(this.userService.handleUserTypeByEmailDomain(admin));
			} else {
				attributes.addFlashAttribute("error", "You can only provide email domain equals to [" + Constants.VALID_ADMIN_DOMAIN_EMAIL +"].");
			}
		} catch (Exception e) {
			attributes.addFlashAttribute("error", "The email [" + admin.getEmail() + "] is already registered. Try with a new one.");
			return  "redirect:addAdmin";
		}
		attributes.addFlashAttribute("success", "Admin account [" + admin.getEmail() +"] was created successfully.");
		return  "redirect:admiHome";
	}
}
