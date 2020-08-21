package com.techelevator;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.campground.jdbc.JDBCParkDAO;
import com.techelevator.campground.jdbc.JDBCReservationDAO;
import com.techelevator.campground.model.Reservation;

public class ReservationTests {
	
	private static SingleConnectionDataSource dataSource;
	JDBCParkDAO park = new JDBCParkDAO(dataSource);
	JDBCReservationDAO res = new JDBCReservationDAO(dataSource);
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
	public void createReservationTest() {
		
		String sql1 = "INSERT INTO site (site_id, campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities) VALUES (-1, 1, -1, 66, true, 100, true)";
		jdbc.update(sql1);
		
		String[] dates = new String[2];
		dates[0] = "2222-02-22";
		dates[1] = "2222-02-23";
		
		res.createReservation(-1L, dates);
		
		String sql = "SELECT * FROM reservation WHERE site_id = -1";
		SqlRowSet row = jdbc.queryForRowSet(sql);
		
		List<Reservation> res = new ArrayList<Reservation>();
		
		while (row.next()) {
			Reservation res1 = new Reservation();
			res1.setCreateDate(row.getDate("create_date"));
			res1.setEndDate(row.getDate("to_date"));
			res1.setId(row.getLong("reservation_id"));
			res1.setName(row.getString("name"));
			res1.setSiteId(row.getLong("site_id"));
			res1.setStartDate(row.getDate("from_date"));
			res.add(res1);
		}
		
		assertEquals(1, res.size());
		
	}

}
