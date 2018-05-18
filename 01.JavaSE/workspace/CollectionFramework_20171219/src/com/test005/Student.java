package com.test005;

//Comparable 인터페이스 구현 필요
public class Student implements Comparable<Student> {
	
	private String id;
	private int score;
	
	public Student(String id, int score) {
		super();
		this.id = id;
		this.score = score;
	}
	
	public String getId() {
		return id;
	}
	public int getScore() {
		return score;
	}

	//객체(항목)와 객체(항목)의 비교
	//->int 자료형의 score 필드 비교시 - 연산자 사용
	@Override
	public int compareTo(Student o) {
		return this.score - o.getScore();
	}
	
}
