package com.test027;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//싱글톤 패턴이 적용된 클래스의 객체 생성
		//->직접 new 연산자를 이용해서 객체 생성하지 않는다.
		//->전용 static 메소드(getInstance) 호출
		//->static 메소드는 클래스이름.메소드이름(); 형태로 호출.
		
		//new 연산자 사용 불가
		Sample s1 = new Sample();
		System.out.println(s1.toString());
		
		Sample s2 = new Sample();
		System.out.println(s2.toString());

		Sample s3 = new Sample();
		System.out.println(s3.toString());

		
		//전용 메소드 호출
		Sample s = Sample.getInstance();
		System.out.println(s.toString());
		
		
		//java.util.Calendar 클래스의 객체 생성 과정
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH) + 1);
		System.out.println(c.get(Calendar.DAY_OF_MONTH));

	}

}
