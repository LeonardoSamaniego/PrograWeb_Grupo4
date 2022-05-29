package com.example.controller;

import com.example.entities.Product;
import com.example.entities.User;
import com.example.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdmiHomeController {

    private ProductoService productService;

    public AdmiHomeController(ProductoService productService) {
        this.productService = productService;
    }

    @GetMapping({"/" , "admiHome"})
    public String home(Model model) {
        model.addAttribute("products", productService.findAll());
        return "admiHome";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @GetMapping("/addAdmin")
    public String addAdmin(Model model) {
        model.addAttribute("admin", new User());
        return "addAdmin";
    }

}