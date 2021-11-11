package com.example.kiosk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller	
public class Webcontroller {
	
		@GetMapping("login")	
		public String loginmethod() {	
			return "g";
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
