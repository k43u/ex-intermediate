package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.repository.TeamRepository;

/**
 * チーム一覧と詳細を表示する業務処理を行います。
 * 
 * @author kashimamiyu
 *
 */
@Service
@Transactional
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	public List<Team> showList(){
		return teamRepository.findAll();
	}
	
	public Team showDetail(Integer id) {
		return teamRepository.load(id);
	}
}
