package com.example.controller;

import javax.servlet.http.HttpSession;

import com.example.entities.Product;
import com.example.entities.Users;
import com.example.service.ProductoService;
import com.example.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdmiHomeController {

    @Autowired
	private UserService userService;
    @Autowired
    private ProductoService productService;

    @GetMapping
    public String home(Model model, HttpSession sesion) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users user = userService.findByUsername(userDetails.getUsername());
		sesion.setAttribute("user", user);
        model.addAttribute("products", productService.findAll());
        return "admiHome";
    }

    @GetMapping("/addproduct")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @GetMapping("/deleteproduct/{id}")
    public String DeleteProducto(@PathVariable("id")Long id, Model model) {
        try {
            if(productService.getById(id) != null){
                model.addAttribute("delete", productService.delete(id));
            }
            else throw new Exception("Elemento no existe");
        } catch (Exception e){
            model.addAttribute("delete", "Error al eliminar el producto id:"+id.toString());
        }
        return "delete";
    }

    @GetMapping("/addadmin")
    public String addAdmin(Model model) {
        model.addAttribute("admin", new Users());
        return "addAdmin";
    }

}