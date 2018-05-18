package com.test002;

import java.util.*;

public class MemberDAO {

	private List<Member> list = new ArrayList<Member>();

	// 회원 정보 입력 메소드
	public void memberAdd(String name, String phone, String email, String regDate, String deptId) {

		Member m = new Member(name, phone, email, regDate, deptId);
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
	
	// 회원 정보 검색 메소드
	public String memberList(String key, String value) {
		StringBuilder sb = new StringBuilder();

		int a = 0;
		for (Member m : this.list) {
			if (key.equals("이름") && m.getName().contains(value)) {
				sb.append(String.format("%s%n", m));
				++a;
			} else if (key.equals("전화번호") && m.getPhone().contains(value)) {
				sb.append(String.format("%s%n", m));
				++a;
			} else if (key.equals("이메일") && m.getEmail().contains(value)) {
				sb.append(String.format("%s%n", m));
				++a;
			} else if (key.equals("등록일") && m.getRegDate().contains(value)) {
				sb.append(String.format("%s%n", m));
				++a;
			} else if (key.equals("부서번호") && m.getDeptId().equals(value)) {
				sb.append(String.format("%s%n", m));
				++a;
			}
		}

		if (a > 0) {
			sb.append(String.format("%s개의 결과가 있습니다.%n", a));
		} else {
			sb.append(String.format("검색 결과가 없습니다.%n"));
		}
		sb.append(String.format("---------------------%n"));

		return sb.toString();
	}

}
