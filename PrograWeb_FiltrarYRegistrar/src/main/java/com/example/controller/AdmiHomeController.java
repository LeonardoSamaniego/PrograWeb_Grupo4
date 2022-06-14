package com.example.controller;

import javax.servlet.http.HttpSession;

import com.example.entities.FilterSelected;
import com.example.entities.Product;
import com.example.entities.Users;
import com.example.service.ProductoService;
import com.example.service.UserService;

import com.example.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdmiHomeController {

    @Autowired
	private UserService userService;
    @Autowired
    private ProductoService productService;

    @GetMapping
    public String home(Model model, HttpSession sesion, RedirectAttributes attributes) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users user = userService.findByUsername(userDetails.getUsername());
		sesion.setAttribute("user", user);
        if (sesion != null && sesion.getAttribute(Constants.SESSION_ATTRIBUTE_FILTER_CRITERIA) != null
                && !sesion.getAttribute(Constants.SESSION_ATTRIBUTE_FILTER_CRITERIA).toString().isEmpty()
                && !sesion.getAttribute(Constants.SESSION_ATTRIBUTE_FILTER_CRITERIA).toString().equalsIgnoreCase("seleccionar")
        ) {
            List<Product> filteredProducts=  productService.findByCategory(sesion.getAttribute(Constants.SESSION_ATTRIBUTE_FILTER_CRITERIA).toString());
            model.addAttribute("products", filteredProducts);
            if (filteredProducts.isEmpty()) {
                attributes.addFlashAttribute("success", "No products with category [" + sesion.getAttribute(Constants.SESSION_ATTRIBUTE_FILTER_CRITERIA).toString() + "] were found.");
            }
        } else {
            model.addAttribute("products", productService.findAll());
        }
        model.addAttribute("filterSelected", new FilterSelected());
        return "admiHome";
    }

    @PostMapping("/filterProductsByCategory")
    public String filterProductsByCategory(@ModelAttribute("filterSelected") FilterSelected filter, Model model, HttpSession sesion) {
    	
    	sesion.setAttribute("filterListOfProductsBy", filter.getFilterValue());
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = userService.findByUsername(userDetails.getUsername());
        sesion.setAttribute("user", user);
        return "redirect:/admin";
    }

    @PostMapping("/resetFilter")
    public String resetFilter(Model model, HttpSession sesion) {
        sesion.setAttribute("filterListOfProductsBy", "seleccionar");
        return "redirect:/admin";
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

    @GetMapping("/listAdmins")
    public String listAdmins(Model model) {
        model.addAttribute("admins", userService.findByRole(Constants.ADMIN_NEW_ID));
        return "listAdmin";
    }

}