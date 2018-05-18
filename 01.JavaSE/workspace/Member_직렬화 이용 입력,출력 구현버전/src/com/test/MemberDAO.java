package com.test;

import java.util.*;
import java.io.*;

public class MemberDAO {

	//컬렉션 저장소
	private List<Member> list = new ArrayList<Member>();
	private static final String FILENAME = "members.data";
	
	//생성자 -> 역직렬화 시도 -> 물리적 저장된 정보를 확인한 후 메모리로 읽어들인다.
	public MemberDAO() {

		//물리적으로 파일이 존재하는지 확인 필요
		File file = new File(FILENAME);
		if (file.exists()) {
			
			//역직렬화 시도
			FileInputStream fs = null;
			ObjectInputStream os = null;
			try {
				fs = new FileInputStream(FILENAME);
				os = new ObjectInputStream(fs);
				Object temp = os.readObject();
				
				//역직렬화 결과물을 컬렉션 저장소에 대입한다.
				this.list = (List<Member>)temp;
				
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					os.close();
					fs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		
	}
	

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
		this.list.add(m);
		
		
		//직렬화 시도
		//->컬렉션에 저장된 Member 객체들에 대한 물리적 저장
		//->주의) 같은 프로그램을 동시 실행하는 경우 A 작업자의 결과를 B 작업자의 결과가 덮어쓰기하게 된다.
		//->직렬화와 역직렬화를 감시하는 과정 추가 필요
		FileOutputStream fs = null;
		ObjectOutputStream os = null;
		try {
			fs = new FileOutputStream(FILENAME);
			os = new ObjectOutputStream(fs);
			
			//컬렉션 저장소에 저장된 모든 정보를 직렬화 시도
			os.writeObject(this.list);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
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
