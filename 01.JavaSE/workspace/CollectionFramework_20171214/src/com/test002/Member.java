package com.test002;

//Comparable 인터페이스 구현 클래스
public class Member implements Comparable<Member> {
	
	private String name;
	private String phone;
	
	public Member() {
	}
	public Member(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	
	@Override
	public int compareTo(Member o) {
		
		//정렬 액션에 사용할 기준 제시
		//결과값이 0이면 동일한 상태, 양수 또는 음수이면 나와 상대 객체의 비교 결과.
		//->값(항목) 비교
		
		//문자열 비교시 compareTo() 메소드 사용
		return this.name.compareTo(o.getName());
		
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s", this.name, this.phone);
	}
	

	//컬렉션 저장소 운영에서 삭제 기준을 제시하기 위한 오버라이딩 구현
	//Object 클래스에서 equals() 메소드는 참조주소 비교
	//Member 클래스에서는 equals() 메소드가 이름 항목 비교하려고 한다.
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof Member) {
			Member m = (Member)obj;
			result = this.name.equals(m.getName()); 
		}
		return result;
	}
	

}
