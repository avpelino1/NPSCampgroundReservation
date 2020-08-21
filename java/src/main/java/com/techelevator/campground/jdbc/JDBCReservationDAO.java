package com.techelevator.campground.jdbc;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.campground.model.Reservation;
import com.techelevator.campground.model.ReservationDAO;

public class JDBCReservationDAO implements ReservationDAO {

private DataSource dataSource;
private JdbcTemplate jdbc;
	
	public JDBCReservationDAO (DataSource dataSource) {
		this.dataSource = dataSource;
		jdbc = new JdbcTemplate(dataSource);
	}
	@Override
	public void createReservation(Long site_id, String[] dates) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What name should the reservation be made under? __");
		
		String name = scanner.nextLine();
		LocalDate createDate = LocalDate.now();
		LocalDate arrival = LocalDate.parse(dates[0]);
		LocalDate departure = LocalDate.parse(dates[1]);
		
		String sql = "INSERT INTO reservation (site_id, name, from_date, to_date, create_date) VALUES (?, ?, ?, ?, ?)";
		jdbc.update(sql, site_id, name, arrival, departure, createDate);	 
		
		String selectSql = "SELECT reservation_id FROM reservation WHERE name = ?";
		SqlRowSet rowset = jdbc.queryForRowSet(selectSql, name);
		Long confirmationId = 0L;
		if (rowset.next()) {
			confirmationId = rowset.getLong("reservation_id");
		}
		
		System.out.println("The reservation has been made and the confirmation id is " + confirmationId);	
		
	}

}
