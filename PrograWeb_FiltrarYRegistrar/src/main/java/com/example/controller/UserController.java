package com.example.controller;

import java.text.ParseException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entities.Product;
import com.example.entities.Users;
import com.example.service.ProductoService;
import com.example.service.UserService;
import com.example.utils.Constants;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private ProductoService productService;
	private UserService userService;
	
	public UserController(ProductoService productService,UserService userService) {
		this.productService = productService;
		this.userService = userService;
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("user", new Users());
		return "register";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Users user, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			return "register";
		} else {
			Users userSave = userService.insert(user);
			if (userSave != null) {
				return "redirect:/login";
			} else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/user/irRegistrar";
			}
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
		attributes.addFlashAttribute("cateSelected", "");
		return  "redirect:/admin";
	}
	
	@PostMapping("/registerNewAdminFromAdmin")
	public String registerNewAdminFromAdmin(Model model, @ModelAttribute("admin") Users admin ,
								 RedirectAttributes attributes , HttpSession sesion) {
		try {
			if (this.userService.isValidEmail(admin.getEmail()) && this.userService.getEmailDomain(admin.getEmail()).equalsIgnoreCase(Constants.VALID_ADMIN_DOMAIN_EMAIL)) {
				this.userService.insert(this.userService.handleUserTypeByEmailDomain(admin));
				attributes.addFlashAttribute("success", "Admin account [" + admin.getEmail() +"] was created successfully.");
				return  "redirect:/admin";
			} else {
				attributes.addFlashAttribute("error", "You can only provide email domain equals to [" + Constants.VALID_ADMIN_DOMAIN_EMAIL +"].");
				return  "redirect:/admin/addadmin";
			}
		} catch (Exception e) {
			attributes.addFlashAttribute("error", e.getMessage());
			return  "redirect:/admin/addadmin";
		}
	}
}
