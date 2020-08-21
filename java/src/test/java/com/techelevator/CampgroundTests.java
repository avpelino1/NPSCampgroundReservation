package com.techelevator;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.campground.jdbc.JDBCCampgroundDAO;
import com.techelevator.campground.jdbc.JDBCParkDAO;
import com.techelevator.campground.model.Campground;
import com.techelevator.campground.model.Park;

public class CampgroundTests {

	private static SingleConnectionDataSource dataSource;
	JDBCCampgroundDAO campground = new JDBCCampgroundDAO(dataSource);
	JDBCParkDAO park = new JDBCParkDAO(dataSource);
	JdbcTemplate jdbc = new JdbcTemplate(dataSource);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dataSource.destroy();
	}

	@After
	public void tearDown() throws Exception {
		dataSource.getConnection().rollback();
	}

	@Test
	public void getAllCampgroundsTest() {
		Park park = new Park();
		String sql = "SELECT * FROM park WHERE park_id = 1";
		SqlRowSet row = jdbc.queryForRowSet(sql);
		while (row.next()) {
			park.setArea(row.getLong("area"));
			park.setDescription(row.getString("description"));
			park.setEstablished(row.getDate("establish_date"));
			park.setId(row.getLong("park_id"));
			park.setLocation(row.getString("location"));
			park.setName(row.getString("name"));
			park.setVisitors(row.getLong("visitors"));
		}
		List<Campground> actual = campground.getAllCampground(park);
		assertEquals(3, actual.size());
		
		
	}
	
	
	
	
}
