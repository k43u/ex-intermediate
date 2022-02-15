package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Cloth;
import com.example.repository.ClothRepository;


/**
 *  衣類の情報を表示する業務処理を行います。
 * 
 * @author kashimamiyu
 *
 */
@Service
@Transactional
public class ClothService {

	@Autowired
	private ClothRepository clothRepository;
	
	/**
	 * 色と性別での衣類の情報の取得
	 * 
	 * @return　色と性別での衣類の情報
	 */
	public List<Cloth> searchBylessThanPrice(String color, Integer gender){
		return clothRepository.findByColorAndGender(color, gender);
	}
}
