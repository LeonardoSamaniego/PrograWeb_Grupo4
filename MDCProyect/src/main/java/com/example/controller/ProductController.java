package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.ProductoService;

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

	@GetMapping("/delete/{id}")
	public String DeleteProducto(@PathVariable("id")Long id, Model model) {
		try {
			if(productService.getById(id) != null){
				model.addAttribute("delete", productService.delete(id));
			}
			else throw new Exception("Elemento no existe");
		}catch (Exception e){
			model.addAttribute("delete", "Error al eliminar el producto id:"+id.toString());
		}
		return "delete";
	}
}
