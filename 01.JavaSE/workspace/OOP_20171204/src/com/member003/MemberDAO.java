package com.member003;

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
		for (Member temp : this.members) {
			if (temp == null) continue;
			//변수에 객체의 참조주소가 들어있는 경우 출력 요청하면 내부적으로 toString() 메소드를 호출한다.
			list.append(String.format("%s%n", temp));
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
				//변수에 객체의 참조주소가 들어있는 경우 출력 요청하면 내부적으로 toString() 메소드를 호출한다.
				list.append(String.format("%s%n", temp));
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
	
	
	// 회원 정보 검색 메소드
	// key : 검색 기준. 예를 들어 '이름' 기준
	// value : 검색 대상. 예를 들어, '홍길동'
	//메소드 오버로딩(Overloading)
	public String memberSearch(String key, String value) {
		StringBuilder list = new StringBuilder();

		//검색 기능 구현
		//-> 이름, 전화번호, 이메일, 등록일 기준으로 검색되도록 수정. if문 또는 switch문 이용.
		//-> 일부 내용만 일치해도 검색되도록 수정. equals() 메소드는 전체 일치. contains(), indexOf() 메소드 사용시 부분 일치하는지 확인 가능.

		int count = 0;
		for (Member temp : members) {
			if (temp == null) continue;
			String temp2 = "";
			switch(key) {
		    case "이름" : temp2 = temp.getName(); break;
		    case "전화번호" : temp2 = temp.getPhone(); break;
		    case "이메일" : temp2 = temp.getEmail(); break;
		    case "등록일" : temp2 = temp.getRegDate(); break;
		    }
			if (temp2.contains(value)) {
				//변수에 객체의 참조주소가 들어있는 경우 출력 요청하면 내부적으로 toString() 메소드를 호출한다.
				list.append(String.format("%s%n", temp));
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
