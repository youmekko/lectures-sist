package com.test001;

//(사용자 정의)자료형 클래스
public class Board {
	
	private String title, content;
	
	public Board() {
	}

	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

}
