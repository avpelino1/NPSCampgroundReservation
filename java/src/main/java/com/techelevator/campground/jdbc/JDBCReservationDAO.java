package com.techelevator.campground.jdbc;

import java.util.List;

import javax.sql.DataSource;

import com.techelevator.campground.model.Reservation;
import com.techelevator.campground.model.ReservationDAO;

public class JDBCReservationDAO implements ReservationDAO {

private DataSource dataSource;
	
	public JDBCReservationDAO (DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public void createReservation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reservation> getAllReservation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteReservation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reservation searchReservationByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation searchReservationById() {
		// TODO Auto-generated method stub
		return null;
	}

}