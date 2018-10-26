package com.springlearn.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	//@RequestMapping("/showForm")				Ambigous problem
	@RequestMapping("/")

	public String showPage() {
		return "main-menu";
	}
}
