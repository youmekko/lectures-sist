package com.test;

public class Showing {
	
	//상영고유번호(M001001), 날짜, 시간, ...., 영화고유번호
	private String sid, date, time, mid;

	public Showing() {
	}

	public Showing(String sid, String date, String time, String mid) {
		this.sid = sid;
		this.date = date;
		this.time = time;
		this.mid = mid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}
	
	

}
