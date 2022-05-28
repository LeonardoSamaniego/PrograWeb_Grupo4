<<<<<<< Updated upstream
<<<<<<< Updated upstream
package com.example.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.Users;
import com.example.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("user", new Users());
		return "register";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Users user, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			return "register";
		} else {
			Users userSave = userService.insert(user);
			if (userSave != null) {
				return "redirect:/login";
			} else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/user/irRegistrar";
			}
		}
	}
}
=======
package com.example.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.Users;
import com.example.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("user", new Users());
		return "register";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Users user, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			return "register";
		} else {
			Users userSave = userService.insert(user);
			if (userSave != null) {
				return "redirect:/login";
			} else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/user/irRegistrar";
			}
		}
	}
}
>>>>>>> Stashed changes
=======
package com.example.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.Users;
import com.example.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("user", new Users());
		return "register";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Users user, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			return "register";
		} else {
			Users userSave = userService.insert(user);
			if (userSave != null) {
				return "redirect:/login";
			} else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/user/irRegistrar";
			}
		}
	}
}
>>>>>>> Stashed changes
