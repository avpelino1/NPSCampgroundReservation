package com.techelevator.campground.jdbc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import com.techelevator.campground.model.Campground;
import com.techelevator.campground.model.Site;
import com.techelevator.campground.model.SiteDAO;

public class JDBCSiteDAO implements SiteDAO {

private DataSource dataSource;
	
	public JDBCSiteDAO (DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public List<Site> getAllAvailable(Campground campground) {
		Campground chosen = campground;
		System.out.println("What is the arrival date? __/__/____");
		Date arrival = findDate();
		
		System.out.println("What is the departure date? __/__/____");
		Date departure = findDate();
		
		System.out.println("Results Matching Your Criteria:");
		
		Long campgroundId = chosen.getId();
		
		//this selects all the overlapping campsites, not the available ones
		String sqlSelect = "SELECT * FROM reservation "
				+ "JOIN site ON site.site_id = reservation.site_id "
				+ "WHERE site.campground_id = " + campgroundId + " AND (from_date, to_date) OVERLAPS (DATE ?, DATE ?)";
		
		
		return null;
	}

	@Override
	public List<Site> getTopFive() {
		// TODO Auto-generated method stub
		return null;
	}

	private Date findDate() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		Date date = null;
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
}
