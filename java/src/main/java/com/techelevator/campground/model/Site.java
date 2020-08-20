package com.techelevator.campground.model;

import java.util.List;

public class Site {

	private Long id;
	private Long campgroundId;
	private Long siteNumber;
	private Long maxOccupancy;
	private boolean accessible;
	private Long maxRVSize;
	private boolean utilities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCampgroundId() {
		return campgroundId;
	}

	public void setCampgroundId(Long campgroundId) {
		this.campgroundId = campgroundId;
	}

	public Long getSiteNumber() {
		return siteNumber;
	}

	public void setSiteNumber(Long siteNumber) {
		this.siteNumber = siteNumber;
	}

	public Long getMaxOccupancy() {
		return maxOccupancy;
	}

	public void setMaxOccupancy(Long maxOccupancy) {
		this.maxOccupancy = maxOccupancy;
	}

	public boolean isAccessible() {
		return accessible;
	}

	public void setAccessible(boolean accessible) {
		this.accessible = accessible;
	}

	public Long getMaxRVSize() {
		return maxRVSize;
	}

	public void setMaxRVSize(Long maxRVSize) {
		this.maxRVSize = maxRVSize;
	}

	public boolean isUtilities() {
		return utilities;
	}

	public void setUtilities(boolean utilities) {
		this.utilities = utilities;
	}

	public String getTopFiveAndConvertToString(List<Site> listOfAvailableSites) {
		
		
		
		return null;
	}

}
