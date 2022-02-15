package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.HotelService;

/**
 * ホテル検索画面と検索結果を表示する処理を行います。
 * 
 * @author kashimamiyu
 *
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
    private HotelService hotelService;
	
	/**
	 * @return hotel/search.htmlにフォワード
	 */
	@RequestMapping("/search")
	public String search() {
		return "hotel/search";
	}
	
	@RequestMapping("/searchBylessThanPrice")
	public String receiveInfo(Integer price, Model model) {
		if (price == null) {
		   System.out.println(price);
		   model.addAttribute("hotelList", hotelService.showList());
		   return "hotel/search";
		}
		model.addAttribute("hotelList", hotelService.searchBylessThanPrice(price));
		return "hotel/search";
	}

}
