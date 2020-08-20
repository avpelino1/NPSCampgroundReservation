package com.techelevator;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.campground.jdbc.JDBCCampgroundDAO;
import com.techelevator.campground.jdbc.JDBCParkDAO;
import com.techelevator.campground.jdbc.JDBCReservationDAO;
import com.techelevator.campground.jdbc.JDBCSiteDAO;
import com.techelevator.campground.model.Campground;
import com.techelevator.campground.model.Park;
import com.techelevator.campground.model.Site;
import com.techelevator.view.Menu;

public class CampgroundCLI {

	private static final String[] MAIN_MENU_OPTIONS = { "Acadia", "Arches", "Cuyahoga National Valley Park", "quit" };
	private static final String[] PARK_MENU = { "View Campgrounds", "Search for Reservation",
			"Return to Previous Screen" };

	public JDBCParkDAO parkDAO;
	public JDBCCampgroundDAO campgroundDAO;
	public JDBCSiteDAO siteDAO;
	public JDBCReservationDAO reservationDAO;
	public Menu menu;
	public JdbcTemplate jdbc;

	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		Menu menu = new Menu(System.in, System.out);
		CampgroundCLI application = new CampgroundCLI(dataSource, menu);
		application.run();

	}

	public CampgroundCLI(DataSource datasource, Menu menu) {
		parkDAO = new JDBCParkDAO(datasource);
		campgroundDAO = new JDBCCampgroundDAO(datasource);
		siteDAO = new JDBCSiteDAO(datasource);
		reservationDAO = new JDBCReservationDAO(datasource);
		jdbc = new JdbcTemplate(datasource);
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) (menu.getChoiceFromOptions(MAIN_MENU_OPTIONS));
			System.out.println(choice);

			if (choice.equals("Acadia")) {
				Park park = mapRowToPark("SELECT * from Park where name = 'Acadia'");
				System.out.println(park.toString());
				processParkMenu(park);

			} else if (choice.equals("Arches")) {
				Park park = mapRowToPark("SELECT * from Park where name = 'Arches'");
				System.out.println(park.toString());
				processParkMenu(park);

			} else if (choice.equals("Cuyahoga National Valley Park")) {
				Park park = mapRowToPark("SELECT * from Park where name = 'Cuyahoga National Valley Park'");
				System.out.println(park.toString());
				processParkMenu(park);

			} else if (choice.equals("quit")) {
				System.exit(0);
			}
		}

	}

	public void processParkMenu(Park park) {
		String choice = "";
		while (!choice.equals("Return to Previous Screen")) {
			choice = (String) menu.getChoiceFromOptions(PARK_MENU);
			if (choice.equals("View Campgrounds")) {
				List<Campground> campgrounds = campgroundDAO.getAllCampground(park);
				for (Campground campground : campgrounds) {
					System.out.println(campground.toString() + "\n");
				}
			} else if (choice.equals("Search for Reservation")) {
				// select a campground
				menu.displayCampgroundOptions(campgroundDAO.getAllCampground(park));
				Campground chosen = menu.getCampgroundChoice(campgroundDAO.getAllCampground(park));
				System.out.println("You have chosen: " + chosen.getName());
				// find reservation in that campground
				// findReservation(campground);
				List<Site> availableSites = siteDAO.getAllAvailable(chosen);
				if (availableSites.size() == 0) {
					System.out.println("There are no available sites.");
					choice = "Return to Previous Screen";
					//we need to ask them to input different dates
				}
				System.out.println("Results Matching Your Criteria:");
				
				
			}
		}
	}

	public void findReservation(Campground campground) {

	}

	public Park mapRowToPark(String query) {
		Park park = new Park();
		SqlRowSet rowset = jdbc.queryForRowSet(query);
		while (rowset.next()) {

			park.setArea(rowset.getLong("area"));
			park.setDescription(rowset.getString("description"));
			park.setEstablished(rowset.getDate("establish_date"));
			park.setId(rowset.getLong("park_id"));
			park.setLocation(rowset.getString("location"));
			park.setName(rowset.getString("name"));
			park.setVisitors(rowset.getLong("visitors"));
		}
		return park;
	}
}
