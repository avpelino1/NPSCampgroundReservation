package com.techelevator.campground.model;

import java.math.BigDecimal;

public class Campground {

		private Long id;
		private Long parkId;
		private String name;
		private String open_mm;
		private String close_mm;
		private BigDecimal dailyFee;
		
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getParkId() {
			return parkId;
		}
		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getOpen_mm() {
			return open_mm;
		}
		public void setOpen_mm(String open_mm) {
			this.open_mm = open_mm;
		}
		public String getClose_mm() {
			return close_mm;
		}
		public void setClose_mm(String close_mm) {
			this.close_mm = close_mm;
		}
		public BigDecimal getDailyFee() {
			return dailyFee;
		}
		public void setDailyFee(BigDecimal dailyFee) {
			this.dailyFee = dailyFee;
		}
		
		
		
}
