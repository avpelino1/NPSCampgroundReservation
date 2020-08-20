package com.techelevator.campground.model;

import java.util.List;

public interface ReservationDAO {

	public void createReservation();
	
	public List<Reservation> getAllReservation();
	
	public void deleteReservation();
	
	public Reservation searchReservationByName();
	
	public Reservation searchReservationById();
	
}
