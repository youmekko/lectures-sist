package com.test001;

public class Member {

	//java.lang.Object 클래스의 equals() 메소드에 대한 오버라이딩(Overriding)
	//java.lang.Object 클래스의 equals() 메소드는 참조주소 비교하도록 되어 있다.
	//equals() 메소드에 대한 오버라이딩(Overriding)해서 값 비교하도록 만든다.
	
	
	private String id;
	
	public Member() {
	}

	public Member(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	//equals() 메소드에 대한 오버라이딩
	//->Member 객체 대 Member 객체를 값(id) 비교할 수 있는 메소드
	@Override
	public boolean equals(Object obj) {
		
		boolean result = false;
		
		//obj 변수에 들어있는 자료가 Member 객체인지 확인
		if (obj instanceof Member) {
			//obj 변수에 들어있는 Member 객체를 Object 자료형에서 Member 자료형으로 형변환
			Member member = (Member)obj;
			//외부에서 전달된 Member 객체의 id 값과 현재 객체의 id 값을 비교
			if (this.id.equals(member.getId())) {
				//id 값이 일치하는 경우 true 반환 준비
				result = true;
			}
		}
		return result;
		
	}
	
	
}
