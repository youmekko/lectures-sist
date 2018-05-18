package com.test;

import java.util.List;

public interface MemberDAO {
	
	public List<Member> memberList();
	
	public List<Member> memberList(String key, String value);

	public List<Member> deptList();
	
	public int memberAdd(Member m);

}
