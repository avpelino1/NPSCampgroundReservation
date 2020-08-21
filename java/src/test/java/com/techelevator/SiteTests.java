package com.techelevator;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.campground.jdbc.JDBCCampgroundDAO;
import com.techelevator.campground.jdbc.JDBCParkDAO;
import com.techelevator.campground.jdbc.JDBCSiteDAO;
import com.techelevator.campground.model.Campground;
import com.techelevator.campground.model.Site;

public class SiteTests {

	private static SingleConnectionDataSource dataSource;
	JDBCParkDAO park = new JDBCParkDAO(dataSource);
	JDBCSiteDAO site = new JDBCSiteDAO(dataSource);
	JDBCCampgroundDAO campground = new JDBCCampgroundDAO(dataSource);
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
	public void getAllAvailableTest() {
		String sql = "SELECT * FROM site WHERE campground_id = 1";
		SqlRowSet rowset = jdbc.queryForRowSet(sql);
		Campground camp = new Campground();
		while (rowset.next()) {	
		camp = campground.mapRowToCampground(rowset);
		}
		String[] userDates = site.findDates();
		
		List<Site> actual = site.getAllAvailable(camp, userDates);
		
		assertEquals(5, actual.size());
	}

//	@Test
//	public void findDatesTest() {
//		
//	}
	
}
