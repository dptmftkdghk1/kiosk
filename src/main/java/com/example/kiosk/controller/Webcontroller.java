package com.example.kiosk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.kiosk.Repository.MenuRepository;
import com.example.kiosk.dto.MenuDto;
import com.example.kiosk.service.MenuService;


@Controller	
public class Webcontroller {
	private MenuService menuService;
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
