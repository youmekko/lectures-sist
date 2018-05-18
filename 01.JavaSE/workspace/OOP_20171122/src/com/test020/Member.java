package com.test020;

//데이터 모델링 테스트 클래스
public class Member {
	
	//데이터 모델링
	//현실 세계의 자료를 클래스로 표현. 예를 들어, 개인정보(이름, 전화번호, 이메일).
	//->이름, 전화번호, 이메일 항목을 개인정보 클래스로 그룹화.
	//->사용자 정의 자료형인 클래스를 이용하면 원하는대로 구성 가능.
	//->항목 구성은 필드로 한다. private 접근제한자 권장.
	//->필드당 getter, setter 구성 추가.
	
	private String name;
	private String id;
	private String password;
	private int age;
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	//개인정보 전체 출력 전용 메소드 추가
	public String memberInfo() {
		//"[홍길동, hong, 1234, 20]"
		//"홍길동/hong/1234/20"
		//"홍길동 hong 1234 20"
		//"홍길동, hong, 1234, 20"
		return String.format("[%s, %s, %s, %s]", this.name, this.id, this.password, this.age);
	}
	

}
