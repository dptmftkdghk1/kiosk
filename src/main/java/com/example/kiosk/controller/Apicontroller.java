package com.example.kiosk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kiosk.Repository.MenuRepository;
import com.example.kiosk.data.Menu;

@RestController
@RequestMapping("/api")
public class Apicontroller {
	@Autowired
	private MenuRepository menuRepository;
	
	@GetMapping("/menus")
	public List<Menu> getMenus(){
		return menuRepository.findAll();
	}
}
