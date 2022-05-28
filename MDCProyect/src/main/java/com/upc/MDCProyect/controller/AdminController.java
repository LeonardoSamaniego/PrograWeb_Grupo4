package com.example.controller;

import java.util.Optional;

import com.example.entities.Product;
import com.example.service.ProductoService;

import org.apache.el.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class AdminController {

	private ProductoService productoService;
	
	@RequestMapping("/modificar/{id}")
	public String updateProducts(@PathVariable Long id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Product> objProduct = Optional.of(productoService.getById(id));
		if (objProduct == null)
		{
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/product/listar";
		}
		else
		{
			model.addAttribute("product", objProduct);
			return "product";
		}
	}
}
