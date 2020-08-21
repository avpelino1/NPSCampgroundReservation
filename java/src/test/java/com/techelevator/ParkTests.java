package com.techelevator;

import static org.junit.Assert.*;

import java.util.ArrayList;
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

import com.techelevator.campground.jdbc.JDBCParkDAO;
import com.techelevator.campground.model.Park;

public class ParkTests extends DAOIntegrationTest {

	private static SingleConnectionDataSource dataSource;
	JDBCParkDAO park = new JDBCParkDAO(dataSource);
	JdbcTemplate jdbc = new JdbcTemplate();

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
		super.rollback();
	}

	@Test
	public void getAllAvailableTest() {
		List<Park> actual = park.getAllAvailable();
		assertEquals(3, actual.size());
	}

}
