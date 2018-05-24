package com.test.ex002;

import java.util.List;

public interface MemberDAO {
	
	public List<Member> memberList();
	
	public List<Member> deptList();
	
	public int memberAdd(Member m);

}
