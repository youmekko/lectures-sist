package com.test;

public class MovieInfo {
	
	//영화번호, 영화제목, 영화소개
	private String mid, title, summary;

	
	public MovieInfo(String mid, String title, String summary) {
		this.mid = mid;
		this.title = title;
		this.summary = summary;
	}

	public MovieInfo() {
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	

}
