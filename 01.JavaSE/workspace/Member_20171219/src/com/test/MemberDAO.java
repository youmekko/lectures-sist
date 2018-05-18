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
	
	// 회원 정보 출력 메소드 -> 정렬 기능 지원
	public String memberList(String key) {
		StringBuilder sb = new StringBuilder();
		
		Collections.sort(list, new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				int result = 0;
				if (key.equals("회원번호")) {
					result = o1.getMid().compareTo(o2.getMid());
				} else if (key.equals("이름")) {
					result = o1.getName().compareTo(o2.getName());
				} else if (key.equals("전화번호")) {
					result = o1.getPhone().compareTo(o2.getPhone());
				} else if (key.equals("이메일")) {
					result = o1.getEmail().compareTo(o2.getEmail());
				} else if (key.equals("등록일")) {
					result = o1.getRegDate().compareTo(o2.getRegDate());
				} else if (key.equals("부서명")) {
					result = Dept.getValue(o1.getDeptId()).compareTo(Dept.getValue(o2.getDeptId()));
				}
				return result;
			}
		});
		
		sb.append(String.format("총: %d건%n", this.list.size()));
		sb.append(String.format("-----------------------------------------------------%n"));
		for (Member temp : this.list) {
			sb.append(String.format("%s%n", temp));
		}
		return sb.toString();
	}
	
	
	// 회원 정보 검색 메소드
	public String memberSearch(String key, String value) {
		StringBuilder sb = new StringBuilder();

		int a = 0;
		for (Member m : this.list) {
			if (key.equals("회원번호") && m.getMid().equals(value)) {
				sb.append(String.format("%s%n", m));
				++a;
			} else if (key.equals("이름") && m.getName().contains(value)) {
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
	
	
	//회원 정보 삭제
	public void memberRemove(Member m) {
		this.list.remove(m);
	}

}
