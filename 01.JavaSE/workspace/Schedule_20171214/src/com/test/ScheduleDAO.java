package com.test;

import java.util.*;

//(컬렉션)저장소 관리 클래스
public class ScheduleDAO {
	
	//(컬렉션)저장소 준비
	private List<Schedule> list = new ArrayList<Schedule>();
	
	//스케줄 자료 등록
	public void scheduleAdd(String date, String content) {
		
		Schedule temp = new Schedule(date, content);
		this.list.add(temp);
		
	}
	
	//스케줄 자료 전체 출력
	public String scheduleList() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("---------------------%n"));
		sb.append(String.format("번호 날짜 내용%n"));

		for (Schedule s : this.list) {
			sb.append(String.format("%s%n", s));
		}
		
		sb.append(String.format("%s개의 일정이 있습니다.%n", this.list.size()));
		sb.append(String.format("---------------------%n"));
		
		return sb.toString();
	}
	
	
	//스케줄 자료 검색 출력
	public String scheduleList(String key, String value) {
		StringBuilder sb = new StringBuilder();
		
		//번호 검색시 일치하는 경우를 찾는다. -> == 연산자 사용
		//날짜, 내용 검색시 부분 일치하더라도 찾는다. -> contains() 메소드 사용
		
		sb.append(String.format("---------------------%n"));
		sb.append(String.format("번호 날짜 내용%n"));

		int a = 0;
		for (Schedule s : this.list) {
			if (key.equals("번호") && s.getSid() == Integer.parseInt(value)) {
				sb.append(String.format("%s%n", s));
				++a;
			} else if (key.equals("날짜") && s.getDate().contains(value)) {
				sb.append(String.format("%s%n", s));
				++a;
			} else if (key.equals("내용") && s.getContent().contains(value)) {
				sb.append(String.format("%s%n", s));
				++a;
			}
		}

		if (a > 0) {
			sb.append(String.format("%s개의 일정이 있습니다.%n", a));
		} else {
			sb.append(String.format("검색 결과가 없습니다.%n"));
		}
		sb.append(String.format("---------------------%n"));
		
		return sb.toString();
	}

}
