package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

/**
 * hotelsテーブルを操作するリポジトリです。
 * 
 * @author kashimamiyu
 *
 */
@Repository
public class HotelRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));
		return hotel;

	};

	/**
	 * 全件検索
	 * 
	 * @return ホテル一覧情報
	 */
	public List<Hotel> findAll() {
		String sql = "SELECT id,area_name,hotel_name,address,nearest_station,price,parking  FROM hotels ORDER BY price DESC";

		List<Hotel> hotelList = template.query(sql, HOTEL_ROW_MAPPER);

		return hotelList;
	}

	/**
	 * 予算以内のホテル一覧表示
	 * @param price
	 * @return 予算以内のホテル情報
	 */
	public List<Hotel> findByprice(Integer price) {
		String sql = "SELECT id,area_name,hotel_name,address,nearest_station,price,parking FROM hotels WHERE price <= :price ORDER BY price DESC";

		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);

		List<Hotel> hotelList = template.query(sql, param, HOTEL_ROW_MAPPER);

		return hotelList;
	}

}
