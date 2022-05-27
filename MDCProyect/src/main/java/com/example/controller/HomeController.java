package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.Product;
import com.example.service.ProductoService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private ProductoService productService;

	@RequestMapping("")
	public String irHome(Model model) {
		model.addAttribute("products", productService.findAll());
		model.addAttribute("productBusqueda", new Product());
		return "home";
	}

	@RequestMapping("/buscarProductos")
	public String buscarProductos(@ModelAttribute Product productBusqueda, BindingResult binRes, Model model) {
		if (productBusqueda.getName().equals(""))
			model.addAttribute("products", productService.findAll());
		else
			model.addAttribute("products", productService.findByName(productBusqueda.getName()));
		model.addAttribute("productBusqueda", new Product());
		return "home";
	}

}
