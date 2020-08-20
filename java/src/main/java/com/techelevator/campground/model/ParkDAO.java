package com.techelevator.campground.model;

import java.util.List;

public interface ParkDAO {

	public List<Park> getAllAvailable();
	
	public String getParkInfo();
}
