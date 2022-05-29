package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service.ProductoService;

@Controller
public class HomeController {
	
	private ProductoService productService;
	
	public HomeController(ProductoService productService) {
		this.productService = productService;
	}
	
	@GetMapping({"/" , "home"})
	public String home(Model model) {
		model.addAttribute("products", productService.findAll());
	    return "home";
	}   

}
