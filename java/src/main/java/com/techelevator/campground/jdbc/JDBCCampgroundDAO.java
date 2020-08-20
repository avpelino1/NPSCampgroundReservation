package com.techelevator.campground.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.campground.model.Campground;
import com.techelevator.campground.model.CampgroundDAO;
import com.techelevator.campground.model.Park;



public class JDBCCampgroundDAO implements CampgroundDAO {
	
	private DataSource dataSource;
	
	public JDBCCampgroundDAO (DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Campground> getAllCampground(Park park) {
		List<Campground> campgrounds = new ArrayList<>();
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String sql = "SELECT * from campground where park_id = ?";
		SqlRowSet result = jdbc.queryForRowSet(sql, park.getId());
		while (result.next()) {
			Campground campground = mapRowToCampground(result);
			campgrounds.add(campground);
		}
		return campgrounds;
	}
	
	public Campground mapRowToCampground(SqlRowSet result) {
		Campground campground = new Campground();
		campground.setId(result.getLong("campground_id"));
		campground.setName(result.getString("name"));
		campground.setParkId(result.getLong("park_id"));
		campground.setOpen_mm(result.getString("open_from_mm"));
		campground.setClose_mm(result.getString("open_to_mm"));
		campground.setDailyFee(result.getBigDecimal("daily_fee"));
		
		return campground;
		
	}

}
