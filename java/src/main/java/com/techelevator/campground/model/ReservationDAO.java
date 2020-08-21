package com.techelevator.campground.model;

import java.util.List;

public interface ReservationDAO {

	public void createReservation(Long site_id, String[] dates);
	
}
