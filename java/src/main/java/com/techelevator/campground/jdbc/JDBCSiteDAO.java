package com.techelevator.campground.jdbc;

import java.util.List;

import javax.sql.DataSource;

import com.techelevator.campground.model.Site;
import com.techelevator.campground.model.SiteDAO;

public class JDBCSiteDAO implements SiteDAO {

private DataSource dataSource;
	
	public JDBCSiteDAO (DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public List<Site> getAllAvailable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> getTopFive() {
		// TODO Auto-generated method stub
		return null;
	}

}
