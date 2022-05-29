package com.example.controller;

import com.example.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.service.ProductoService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	private ProductoService productService;
	
	public ProductController(ProductoService productService) {
		this.productService = productService;
	}
	
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productService.findAll());
        return "home";
    }    

	@GetMapping("/details/{id}")
	public String DetailProducto(@PathVariable("id")Long id , Model model) {
		model.addAttribute("product", productService.getById(id));
	    return "product";
	}

}
