package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.MyProduct;
import com.example.entities.Product;
import com.example.entities.Users;
import com.example.service.MyProductService;
import com.example.service.ProductoService;
import com.example.service.UserService;

@Controller
@RequestMapping("/myProducts")
public class MyProductsController {
	
	@Autowired
	private ProductoService productService;

	@Autowired
	private MyProductService myProductService;

	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String irMyProducts(Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println(username);
		Users user = userService.findByUsername(username);
		model.addAttribute("myProducts", myProductService.findByUserId(user.getId()));
		return "myProducts";
	}

	@RequestMapping("/add/{id}")
	public String addProduct(@PathVariable("id") Long id, Model model) throws Exception {
		try {
			Product product = productService.getById(id);
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			System.out.println(username);
			Users user = userService.findByUsername(username);
			MyProduct myProduct = new MyProduct();
			myProduct.setUser(user);
			myProduct.setProduct(product);
			myProductService.insert(myProduct);
			return "redirect:/myProducts";
		} catch (Exception e) {
			return "redirect:/product/details/" + id;
		}
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long id, Model model) throws Exception {
		try {
			myProductService.delete(id);
			return "redirect:/myProducts";
		} catch (Exception e) {
			return "redirect:/myProducts";
		}
	}
}
