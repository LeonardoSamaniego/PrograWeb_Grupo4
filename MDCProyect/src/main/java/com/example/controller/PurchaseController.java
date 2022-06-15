package com.example.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.MyProduct;
import com.example.entities.Purchase;
import com.example.entities.Users;
import com.example.service.MyProductService;
import com.example.service.PurchaseService;
import com.example.service.UserService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private MyProductService myProductService;

	@Autowired
	private PurchaseService purchaseService;

	@Autowired
	private UserService userService;

	@RequestMapping
	public String irPurchase(Model model) throws Exception {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println(username);
		Users user = userService.findByUsername(username);
		List<Purchase> purchases = purchaseService.findByUserId(user.getId());
		model.addAttribute("purchases", purchases);
		return "purchase";
	}

	@RequestMapping("/buy")
	public String buy() throws Exception {
		try {

			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			System.out.println(username);
			Users user = userService.findByUsername(username);
			List<MyProduct> listMyProducts = myProductService.findByUserId(user.getId());

			if (listMyProducts.size() > 0) {
				Purchase purchase = new Purchase();
				purchase.setDate(new Date());
				purchase.setUser(user);
				Float total = (float) 0.0;
				for (int i = 0; i < listMyProducts.size(); i++) {
					total += listMyProducts.get(i).getProduct().getPrice();
				}
				purchase.setAmount(total);
				purchaseService.insert(purchase);
				
				for (int i = 0; i < listMyProducts.size(); i++) {
					myProductService.delete(listMyProducts.get(i).getIdMyProduct());
				}
				return "redirect:/purchase";
			}
			return "redirect:/myProducts";

		} catch (Exception e) {
			return "redirect:/myProducts";
		}
	}
}
