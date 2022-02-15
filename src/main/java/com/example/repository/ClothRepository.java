package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.example.domain.Cloth;


/**
 * clothesテーブルを操作するリポジトリです。
 * 
 * @author kashimamiyu
 *
 */
@Repository
public class ClothRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Cloth> CLOTH_ROW_MAPPER = (rs, i) -> {
		Cloth cloth = new Cloth();
		cloth.setId(rs.getInt("id"));
		cloth.setCategory(rs.getString("category"));
		cloth.setGenre(rs.getString("genre"));
		cloth.setGender(rs.getInt("gender"));
		cloth.setColor(rs.getString("color"));
		cloth.setPrice(rs.getInt("price"));
		cloth.setSize(rs.getString("size"));
		return cloth;
	};
	
	/**
	 * 性別と色での衣服の検索
	 * @param price
	 * @return 性別と色での衣服の情報
	 */
	public List<Cloth> findByColorAndGender(String color, Integer gender) {
		String sql = "SELECT id,category,genre,gender,color,price,size FROM clothes WHERE color = :color AND gender = :gender";

		SqlParameterSource param = new MapSqlParameterSource().addValue("color", color).addValue("gender", gender);
		
		List<Cloth> clothList = template.query(sql, param, CLOTH_ROW_MAPPER);

		return clothList;
	}

	
}

