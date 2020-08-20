package com.techelevator.campground.jdbc;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.campground.model.Campground;
import com.techelevator.campground.model.Park;
import com.techelevator.campground.model.Site;
import com.techelevator.campground.model.SiteDAO;

public class JDBCSiteDAO implements SiteDAO {

	private DataSource datasource;
	public JdbcTemplate jdbc;

	public JDBCSiteDAO(DataSource dataSource) {
		this.datasource = dataSource;
		jdbc = new JdbcTemplate(datasource);
	}

	@Override
	public List<Site> getAllAvailable(Campground campground) {
		Campground chosen = campground;
		System.out.println("What is the arrival date? ____-__-__");
		String arrival = findDate();

		System.out.println("What is the departure date? ____-__-__");
		String departure = findDate();

		Long campgroundId = chosen.getId();
		
		System.out.println(arrival + " " + departure);

		// this selects the site_id of all available campsites in the campground that
		// the user chose:
		String sqlSelect = "SELECT site_id FROM reservation WHERE (from_date, to_date) OVERLAPS ('?', '?') "
				+ "GROUP BY site_id ORDER BY site_id)";
		
//		String sqlSelect = "SELECT * FROM site WHERE campground_id = 1 AND site_id "
//				+ "NOT IN (SELECT site_id FROM reservation WHERE (from_date, to_date) OVERLAPS (DATE '2020-09-04', DATE '2020-09-09') "
//				+ "GROUP BY site_id ORDER BY site_id)";
				
//				"SELECT * FROM reservation " + "JOIN site ON site.site_id = reservation.site_id"
//				+ "WHERE site.campground_id = " + campgroundId + "AND site.site_id NOT IN ("
//				+ "SELECT site_id FROM reservation " + "WHERE (from_date, to_date) OVERLAPS (DATE '?', DATE '?')"
//				+ ") GROUP BY site.site_id" + "ORDER BY site.site_id";

		List<Site> siteList = new ArrayList<Site>();
		SqlRowSet rowset = jdbc.queryForRowSet(sqlSelect, arrival, departure);
		while (rowset.next()) {
			Site site = new Site();
			site.setAccessible(rowset.getBoolean("accessible"));
			site.setCampgroundId(rowset.getLong("campground_id"));
			site.setId(rowset.getLong("site_id"));
			site.setMaxOccupancy(rowset.getLong("max_occupancy"));
			site.setMaxRVSize(rowset.getLong("max_rv_length"));
			site.setSiteNumber(rowset.getLong("site_number"));
			site.setUtilities(rowset.getBoolean("utilities"));
			siteList.add(site);
		}
		
		return siteList;
	}

	@Override
	public String getTopFiveAndConvertToString(List<Site> listOfAvailableSites) {
		List<Site> sites = listOfAvailableSites;
		List<BigDecimal> cost = new ArrayList<BigDecimal>();
//		sites.get(0).isUtilities()
		System.out.println("Site No.	Max Occup.	Accessible?		Max RV Length	Utility		Cost");
		System.out.println((sites.get(0)).getSiteNumber() +	"	" + sites.get(0).getMaxOccupancy() + "	" + sites.get(0).getMaxRVSize()	 );
		String topFive = "";
		
		return null;
	}

	private String findDate() {
		Scanner scanner = new Scanner(System.in);
		String date = scanner.nextLine();
//		String date = null;
//		try {
//			date = new SimpleDateFormat("dd/MM/yyyy").parse(input);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		return date;
	}

}