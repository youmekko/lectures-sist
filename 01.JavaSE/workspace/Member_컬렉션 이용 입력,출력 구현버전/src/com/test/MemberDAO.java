package com.test;

import java.util.*;

public class MemberDAO {

	private List<Member> list = new ArrayList<Member>();

	// 회원 정보 입력 메소드
	public void memberAdd(String name, String phone, String email, String regDate, String deptId) {

		Member max = null;
		String mid = "M001";
		if (this.list.size() > 0) {
			//기존 번호 분석 -> 저장 순서가 유지되므로 마지막 값이 가장 큰 값이다.
			max = this.list.get(this.list.size()-1);
			//신규 번호 생성 -> max 변수의 값을 분석해서 +1 연산 수행
			mid = String.format("M%03d", Integer.parseInt(max.getMid().substring(1)) + 1);
		}
		
		Member m = new Member(mid, name, phone, email, regDate, deptId);
		list.add(m);

	}

	// 회원 정보 출력 메소드
	public String memberList() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("총: %d건%n", this.list.size()));
		sb.append(String.format("-----------------------------------------------------%n"));
		for (Member temp : this.list) {
			sb.append(String.format("%s%n", temp));
		}
		return sb.toString();
	}
	
}
