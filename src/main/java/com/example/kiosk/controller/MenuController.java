package com.example.kiosk.controller;

import java.util.List;

import com.example.kiosk.dto.MenuDto;
import com.example.kiosk.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
@AllArgsConstructor
public class MenuController {
	private MenuService menuService;
	/* 메뉴 목록 */
	@GetMapping("admin/menus")
	public String list(Model model) {
		List<MenuDto> menuList = menuService.getMenulist();
		model.addAttribute("menuList",menuList);
		return "menus";
	}
	
	@GetMapping("/conmenus")
	public String menulist(Model model) {
		List<MenuDto> conmenuList = menuService.getMenulist();
		model.addAttribute("conmenuList",conmenuList);
		return "conmenus";
	}
	
	@GetMapping("/post")
	public String write() {
		return "write";
	}
	@PostMapping("/post")
	public String write(MenuDto menuDto) {
		menuService.savePost(menuDto); 
		return "redirect:/menus";
	}
	
	@RequestMapping(value = "/post/edit/{no}" , method = RequestMethod.GET)
	public String edit(@PathVariable("no") Long no, Model model) {
		MenuDto menuDTO = menuService.getPost(no);
		model.addAttribute("menuDto",menuDTO);
		return "update";
	}
	
	@RequestMapping(value = "/post/edit/{no}",method = {RequestMethod.POST,RequestMethod.PUT})
	public String update(MenuDto menuDTO) {
		menuService.savePost(menuDTO);
		
		return "redirect:/menus";
	}
	@RequestMapping(value = "/post/{no}", method = RequestMethod.GET)
	public String detail(@PathVariable("no") Long no, Model model) {
		MenuDto menuDTO = menuService.getPost(no);
		
		model.addAttribute("menuDto",menuDTO);
		return "detail";
	}
	
	@RequestMapping(value = "/posts/{no}", method = RequestMethod.GET)
	public String condetail(@PathVariable("no") Long no, Model model) {
		MenuDto menuDTO = menuService.getPost1(no);
		model.addAttribute("menuDto",menuDTO);
		return "condetail";
	}
	
	@RequestMapping(value = "/post/{no}",method = {RequestMethod.POST,RequestMethod.DELETE})
	public String delete(@PathVariable("no") Long no) {
		menuService.deletePost(no);
		
		return "redirect:/menus";
	}
}
