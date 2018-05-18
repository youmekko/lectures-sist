package com.test003;

public class Member  {
	
	//삭제 기능을 위한 유니크 자료 저장용 항목 추가 -> 번호
	private static int count;
	private int mid;
	private String name;
	private String phone;
	
	public Member() {
	}
	public Member(String name, String phone) {
		this.mid = ++count;
		this.name = name;
		this.phone = phone;
	}

	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}

	
	@Override
	public String toString() {
		return String.format("%s, %s, %s", this.mid, this.name, this.phone);
	}
	

	//컬렉션 저장소 운영에서 삭제 기준을 제시하기 위한 오버라이딩 구현
	//Object 클래스에서 equals() 메소드는 참조주소 비교
	//Member 클래스에서는 equals() 메소드가 번호 항목 비교하려고 한다.
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof Member) {
			Member m = (Member)obj;
			result = this.mid == m.getMid(); 
		}
		return result;
	}
	

}
