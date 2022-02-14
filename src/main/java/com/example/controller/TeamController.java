package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Team;
import com.example.service.TeamService;

/**
 * チーム情報を検索します。
 * 
 * @author kashimamiyu
 *
 */
@Controller
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService teamservice;
	
	/**
	 * チーム一覧を取得
	 * @param model
	 * @return チーム一覧
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		model.addAttribute("teamList", teamservice.showList());
		return "team/list";
	}
	
	/**
	 * @param id
	 * @param model
	 * @return チーム詳細
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {
		Team team = teamservice.showDetail(Integer.parseInt(id));
	    model.addAttribute("team", team);
	    return "team/detail";
	}
	
}
