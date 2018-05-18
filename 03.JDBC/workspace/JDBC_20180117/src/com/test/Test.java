package com.test;

//자료형 클래스 선언
//->클래스명 지정시 테이블명과 동일하게 작성
public class Test {

	// 자료형 클래스 선언시 멤버 구성은
	// 동일 자료, 동일 식별자 권장
	// ->데이터베이스 입력, 출력 액션에서 사용한 모든 식별자(특히 별칭 사용한 경우)를 멤버로 구성
	// ->테이블의 컬럼 구성시 사용한 컬럼명 및 자료형을 멤버로 구성
	// ->오라클에서 NUMBER 자료형인 경우 Java에서는 int, double 자료형
	// ->오라클에서 VARCHAR2, NVARCHAR2 자료형인 경우 Java에서는 String 자료형
	// ->오라클에서 DATE 자료형인 경우 Java에서는 Date, LocalDate 자료형
	private int id_, age_;
	private String first_, last_;
	
	
	//매개변수 있는 생성자 추가
	public Test(int id_, int age_, String first_, String last_) {
		this.id_ = id_;
		this.age_ = age_;
		this.first_ = first_;
		this.last_ = last_;
	}	

	// 문제) getter, setter 등록
	// getter
	public int getId_() {
		return id_;
	}


	public int getAge_() {
		return age_;
	}

	public String getFirst_() {
		return first_;
	}

	public String getLast_() {
		return last_;
	}

	// setter
	public void setId_(int id_) {
		this.id_ = id_;
	}

	public void setAge_(int age_) {
		this.age_ = age_;
	}

	public void setFirst_(String first_) {
		this.first_ = first_;
	}

	public void setLast_(String last_) {
		this.last_ = last_;
	}

	// 문제) toString() 메소드 오버라이딩
	// ->출력 서식 지정
	@Override
	public String toString() {
		return String.format("%d %d %s %s", id_, age_, first_, last_);
	}

}
