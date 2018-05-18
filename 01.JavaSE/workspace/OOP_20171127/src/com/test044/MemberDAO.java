package com.test044;

public class MemberDAO {
	
	//(배열) 저장소 준비 및 자료 저장
	//-> 여러개의 Member 객체를 사전에 준비하고 저장한다.
	private Member[] members = new Member[5];

	//기본 생성자
	//->instance 멤버의 초기화 액션
	public MemberDAO() {
		
		Member m1 = new Member("hong", "1234");
		Member m2 = new Member("park", "p123");
		Member m3 = new Member("choi", "4321");
		
		this.members[0] = m1;
		this.members[1] = m2;
		this.members[2] = m3;
		
	}

	
	//(배열) 저장소에 등록된 id, password를 탐색해서 존재 여부를 판단하고
	//, 그 결과(true, false)를 반환하는 메소드
	public boolean memberSearch(String id, String password) {
		boolean result = false;
		
		//탐색 과정
		for (Member m : this.members) {
			//NullPointerException 주의할 것!
			if (m == null) continue;
			
			//id, password 비교
			if (id.equals(m.getId()) && password.equals(m.getPassword())) {
				result = true;
				break;
			}
		}
		
		return result;
	}
	
}
