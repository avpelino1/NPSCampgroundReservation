package com.techelevator.campground.model;

import java.util.Date;

public class Park {

	private Long id;
	private String name;
	private String location;
	private Date established;
	private Long area;
	private Long visitors;
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getEstablished() {
		return established;
	}

	public void setEstablished(Date established) {
		this.established = established;
	}

	public Long getArea() {
		return area;
	}

	public void setArea(Long area) {
		this.area = area;
	}

	public Long getVisitors() {
		return visitors;
	}

	public void setVisitors(Long visitors) {
		this.visitors = visitors;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		String parkInfo = this.getName() + "\n" + "Location: " + this.getLocation() + "\n" + "Established: "
				+ this.getEstablished() + "\nArea: " + this.getArea() + "\nAnnual Visitors: " + this.getVisitors()
				+ "\n\n" + this.getDescription();

		return parkInfo;
	}

}
