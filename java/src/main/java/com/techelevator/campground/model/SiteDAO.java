package com.techelevator.campground.model;

import java.util.List;

public interface SiteDAO {

	public List<Site> getAllAvailable(Campground chosen);
	
	public List<Site> getTopFive();
	
	
}
