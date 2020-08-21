package com.techelevator.campground.model;

import java.util.List;

public interface SiteDAO {

	public List<Site> getAllAvailable(Campground chosen, String[] userDates);
	
	public String getTopFiveAndConvertToString(List<Site> listOfAvailableSites);
	
	
}
