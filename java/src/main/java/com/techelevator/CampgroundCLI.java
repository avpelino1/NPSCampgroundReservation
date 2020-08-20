package com.techelevator;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.campground.jdbc.JDBCParkDAO;
import com.techelevator.campground.model.Park;
import com.techelevator.view.Menu;

public class CampgroundCLI {

	private static final String[] MAIN_MENU_OPTIONS = {"Acadia", "Arches", "Cuyahoga National Valley Park", "quit"};
	public JDBCParkDAO parkDAO;
	public Menu menu;
	
	public static void main(String[] args) throws NullPointerException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		Menu menu = new Menu(System.in, System.out);
		CampgroundCLI application = new CampgroundCLI(dataSource);
		application.run();
		
		
	}

	public CampgroundCLI(DataSource datasource) {
		parkDAO = new JDBCParkDAO(datasource);
	}

	public void run() {
		while(true) {
			String choice = (String)(menu.getChoiceFromOptions(MAIN_MENU_OPTIONS));
		}
		
	}
}
