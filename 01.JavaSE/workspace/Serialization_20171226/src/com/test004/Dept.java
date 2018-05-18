package com.test004;

import java.util.*;

//부서 정보 관리용 클래스
public class Dept {
	
	//부서 정보는 개발부(B01), 마케팅부(B02), 총무부(B03)만 존재한다고 가정.
	private static Map<String, String> map = new HashMap<String,String>();
	
	static {
		map.put("B01", "개발부");
		map.put("B02", "마케팅부");
		map.put("B03", "총무부");
	}
	
	public static String getValue(String key) {
		return map.get(key);
	}

	//"{B01=개발부, B02=마케팅부, B03=총무부}"
	public static String getList() {
		
		//문제) 부서 정보 전체를 하나의 문자열로 만들고 반환하는 과정 추가.
		return map.toString();
		
	}
	
}
