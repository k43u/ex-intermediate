package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * ホテル情報を表示する業務処理を行います。
 * 
 * @author kashimamiyu
 *
 */
@Service
@Transactional
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	/**
	 * ホテル情報の全件取得
	 * 
	 * @return ホテル情報全件
	 */
	public List<Hotel> showList(){
		return hotelRepository.findAll();
	}
	
	/**
	 * 予算以内のホテル情報の取得
	 * 
	 * @return 予算以内のホテル情報
	 */
	public List<Hotel> searchBylessThanPrice(Integer price){
		return hotelRepository.findByprice(price);
	}
}
