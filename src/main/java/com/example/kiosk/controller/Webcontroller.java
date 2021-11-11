package com.example.kiosk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.kiosk.Repository.MenuRepository;

@Controller	
public class Webcontroller {
	
	@Autowired
	MenuRepository menuRepository;
	
		@GetMapping("login")	
		public String loginmethod() {	
			return "login";
		}
		@GetMapping("join")	
		public String joinmethod() {	
			return "join";
		}
		@GetMapping("manage")	
		public String menumanagemethod() {	
			return "menumanage";
		}
		@GetMapping("basket")
		public String basketmethod(){
			return "basket";
		}
}
