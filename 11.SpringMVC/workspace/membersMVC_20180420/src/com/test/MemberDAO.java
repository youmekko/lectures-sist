package com.test;

import java.util.List;

public interface MemberDAO {
	
	public List<Member> list();
	public List<Member> list(String key, String value);
	public int memberAdd(Member m);
	public List<Member> deptList();
	public int totalCount();
	public int memberRemove(String mid_);
	public int memberModify(Member m);
	
}
