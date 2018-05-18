package com.test003;

//(사용자 정의)자료형 클래스
public class Student {
	
	private int studentNum;
	private String name;
	
	public Student(int studentNum, String name) {
		this.studentNum = studentNum;
		this.name = name;
	}

	public int getStudentNum() {
		return studentNum;
	}

	public String getName() {
		return name;
	}

	//중복 검사용 오버라이딩 메소드
	//->학번(studentNum)이 같으면 중복 객체
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof Student) {
			Student s = (Student)obj;
			result = this.studentNum == s.getStudentNum();
		}
		return result;
	}

	//중복 검사용 오버라이딩 메소드
	//->학번(studentNum)이 같으면 중복 객체
	@Override
	public int hashCode() {
		return this.studentNum;
	}

}
