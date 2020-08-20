package com.techelevator.campground.model;

import java.util.Date;

public class Reservation {

		private String name;
		private Long id;
		private Long siteId;
		private Date startDate;
		private Date endDate;
		private Date createDate;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getSiteId() {
			return siteId;
		}
		public void setSiteId(Long siteId) {
			this.siteId = siteId;
		}
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		public Date getCreateDate() {
			return createDate;
		}
		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}
		
		public String toString() {
			return this.name;
		}
		
		
		
}
