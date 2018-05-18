package com.test002;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Properties;

public class Main {

	public static void main(String[] args) {
		// Map 인터페이스
		// - 키와 값의 쌍으로 자료 저장.
		// - 인덱스 제공되지 않는다.
		// - 키(Set)는 중복 저장 불가.
		// - 값(List)은 중복 저장 가능.
		// - 키를 이용해서 값 접근.
		// - 대표적인 구현 클래스는 HashMap 클래스이다.

		// Properties 클래스
		// - 키와 값을 String 타입으로 제한한 컬렉션
		// - .properties 파일의 정보(환경 설정 정보)를 읽을 때 주로 사용.
		// - .properties 파일의 정보에서 정보 저장은 '키=값' 형태의 문자열로 저장된다.

		Properties prop = new Properties();
		//주의) database.properties의 물리적 위치를 Main.java와 같은 폴더에 저장한 상태에서 실행
		String path = Main.class.getResource("database.properties").getPath();
		System.out.println(path);

		try {
			path = URLDecoder.decode(path, "UTF-8");
			prop.load(new FileReader(path));
			
			String driver = prop.getProperty("driver");
			System.out.println(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
