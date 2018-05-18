package com.test002;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//시스템(운영체제) 정보 확인
		//시스템 프로퍼티는 JVM이 시작할 때 자동 설정되는 시스템의 속성값이다.
		//시스템 프로퍼티 정보를 읽고자 할때 System 클래스의 getProperty(), getProperties() 메소드 호출
		
		System.out.println("시스템 프로퍼티 정보");
		System.out.println("---------------");
		System.out.println("key | value");
		System.out.println("---------------");
		
		//컬렉션 정보
		Properties props = System.getProperties();
		Set keys = props.keySet();
		
		for (Object objKey : keys) {
			String key = (String)objKey;
			String value = System.getProperty(key);
			System.out.printf("%s | %s%n", key, value);
		}

	}

}
