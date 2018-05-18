package com.member002;

//(배열)저장소 관리 클래스
public class MemberDAO {
	
	//(배열)저장소 생성 및 관리
	private Member[] members = new Member[5];
	//(배열)저장소 인덱스 관리 변수
	private int idx;
	
	
	//회원 정보 입력 메소드
	public void memberAdd(String name, String phone, String email, String regDate) {
		
		//Member 객체 생성 및 (배열)저장소에 저장
		Member m = new Member(name, phone, email, regDate);
		this.members[this.idx] = m;
		//인덱스 증가
		++this.idx;
		
	}
	
	// 회원 정보 출력 메소드
	public String memberList() {
		StringBuilder list = new StringBuilder();
		list.append(String.format("총 : %d건%n", this.idx));
		list.append(String.format("---------------------------------------%n"));
		for (Member i : this.members) {
			if (i == null) continue;
			list.append(String.format("%s%n", i.memberInfo()));
		}
		return list.toString();
	}

	// 회원 정보 검색 메소드
	public String memberSearch(String name) {
		StringBuilder list = new StringBuilder();

		//검색 기능 구현
		int count = 0;
		for (Member temp : members) {
			if (temp == null) continue;
			if (name.equals(temp.getName())) {
				list.append(String.format("%s%n", temp.memberInfo()));
				++count;
			}
		}
		if (count == 0) {
			list.append(String.format("검색 결과가 없습니다%n"));
		}
		list.insert(0, String.format("-----------------------------------------------------%n"));
		list.insert(0, String.format("총: %d건%n", count));
		
		
		return list.toString();
	}


}
