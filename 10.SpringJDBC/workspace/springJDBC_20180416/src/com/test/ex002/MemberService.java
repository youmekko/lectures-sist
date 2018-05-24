package com.test.ex002;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//콘솔 액션 전용 클래스
public class MemberService {

	private ApplicationContext context;
	private MemberJDBCTemplate memberJDBCTemplate;
	
	public MemberService() {
		this.context = new ClassPathXmlApplicationContext("/com/test/ex002/beans.xml");
		this.memberJDBCTemplate = (MemberJDBCTemplate) context.getBean("memberJDBCTemplate");
	}
	
	@Override
	protected void finalize() throws Throwable {
		((ClassPathXmlApplicationContext)context).close();
	}

	// 회원 정보 출력 메소드
	public void memberList() {

		List<Member> list = this.memberJDBCTemplate.memberList();
		System.out.println("--------------");
		System.out.println("회원 정보 출력");
		System.out.println("--------------");
		System.out.printf("총: %d명%n", list.size());
		System.out.println("---------------------------------");
		for (Member m : list) {
			// 콘솔 출력시 서식 지정 추가
			System.out.println(m);
		}

	}

	// 부서 정보 출력 메소드
	private String deptList() {
		String result = "";

		List<Member> list = this.memberJDBCTemplate.deptList();

		Map<String, String> map = new HashMap<String, String>();
		for (Member m : list) {
			map.put(m.getDeptId(), m.getDeptName());
		}
		result = map.toString();

		return result;
	}

	// 회원 정보 입력 메소드
	public void memberAdd(Scanner sc) {

		System.out.println("--------------");
		System.out.println("회원 정보 입력");
		System.out.println("--------------");
		System.out.print("이름:");
		String name_ = sc.nextLine();
		System.out.print("전화번호:");
		String phone = sc.nextLine();
		System.out.print("이메일:");
		String email = sc.nextLine();
		System.out.print("등록일(YYYY-MM-DD):");
		String regDate = sc.nextLine();

		// 부서 정보 출력
		System.out.println(deptList());

		System.out.print("부서번호:");
		String deptId = sc.nextLine();

		Member m = new Member();
		m.setName_(name_);
		m.setPhone(phone);
		m.setEmail(email);
		m.setRegDate(LocalDate.parse(regDate));
		m.setDeptId(deptId);
		this.memberJDBCTemplate.memberAdd(m);

		System.out.println("회원 정보 입력이 성공했습니다.");

	}

}
