package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.ClothService;

/**
 * 衣類の検索画面の表示と検索結果の表示
 * 
 * @author kashimamiyu
 *
 */
@Controller
@RequestMapping("/cloth")
public class ClothController {
	
	@Autowired
	private ClothService clothService;
	
	@RequestMapping("/search")
	public String search() {
		return "cloth/search";
	}
	
	@RequestMapping("/searchByColorAndGender")
	public String searchByColorAndGender(String color, Integer gender, Model model) {
		model.addAttribute("clothList", clothService.searchBylessThanPrice(color, gender));
		return "cloth/search";
	}

}
