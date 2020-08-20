package com.techelevator.campground.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.campground.model.Park;
import com.techelevator.campground.model.ParkDAO;

public class JDBCParkDAO implements ParkDAO {

	private DataSource dataSource;
	
	public JDBCParkDAO (DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<Park> getAllAvailable() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Park> parkList = new ArrayList<Park>();
		String sqlSelect = "SELECT * FROM park";
		SqlRowSet rowset = jdbcTemplate.queryForRowSet(sqlSelect);
		
		while(rowset.next()) {
			Park park = new Park();
			park.setArea(rowset.getLong("area"));
			park.setDescription(rowset.getString("description"));
			park.setEstablished(rowset.getDate("establish_date"));
			park.setId(rowset.getLong("park_id"));
			park.setLocation(rowset.getString("location"));
			park.setName(rowset.getString("name"));
			park.setVisitors(rowset.getLong("visitors"));
			parkList.add(park);
		}
		
		return parkList;
	}

}
