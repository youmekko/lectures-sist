package com.test;

import java.util.*;

public class MovieDAO {
	
	private Map<String, MovieInfo> movieInfoList = new HashMap<String, MovieInfo>();
	private List<Showing> movieShowingList = new ArrayList<Showing>();
	
	public MovieDAO() {
		
		//영화정보 등록
		MovieInfo m1 = new MovieInfo("M001", "해리포터1", "해리포터 시리즈1");
		this.movieInfoList.put("M001", m1);
		
		//상영정보 등록
		Showing s1 = new Showing("M001001", "20171225", "10", "M001");
		Showing s2 = new Showing("M001002", "20171225", "14", "M001");
		Showing s3 = new Showing("M001003", "20171226", "10", "M001");
		Showing s4 = new Showing("M001004", "20171226", "14", "M001");
		this.movieShowingList.add(s1);
		this.movieShowingList.add(s2);
		this.movieShowingList.add(s3);
		this.movieShowingList.add(s4);
		
	}

	public String showingList(String date) {
		//특정 날짜를 만족하는 영화 상영 정보 반환
		StringBuilder sb = new StringBuilder();
		
		for (Showing show : this.movieShowingList) {
			if (show.getDate().equals(date)) {
				MovieInfo mf = this.movieInfoList.get(show.getMid());
				sb.append(String.format("%s %s %s %s %s%n", show.getSid(), show.getDate(), show.getTime(), mf.getTitle(), mf.getSummary()));
			}
		}
		
		return sb.toString();
	}

}
