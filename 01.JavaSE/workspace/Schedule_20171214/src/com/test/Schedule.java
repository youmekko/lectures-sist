package com.test;

//자료형 클래스
public class Schedule {
	
	//화면 설계를 토대로 항목 분석 및 필드, 생성자, getter, setter, 메소드 구성
	//(고유)번호, 날짜, 내용 항목
	//주의) 번호는 자동 관리되도록 한다.
	
	private static int count;
	private int sid;
	private String date;
	private String content;

	public Schedule() {
	}

	public Schedule(String date, String content) {
		this.sid = ++count;
		this.date = date;
		this.content = content;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getDate() {
		return date;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s", this.sid, this.date, this.content);
	}
	

}
