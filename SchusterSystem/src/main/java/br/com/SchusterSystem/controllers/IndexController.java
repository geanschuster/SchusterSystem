package br.com.SchusterSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	
	@GetMapping("/index")
	public String index(Model model) {
		
		return "/index";
	}
}