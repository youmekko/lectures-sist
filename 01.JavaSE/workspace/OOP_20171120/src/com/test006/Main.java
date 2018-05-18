package com.test006;

public class Main {

	public static void main(String[] args) {

		//매개변수 테스트용 클래스의 객체(instance) 생성
		//-> new 연산자
		//-> 객체 자신은 heap 영역
		//-> 참조주소를 가지는 변수(4byte)는 stack 영역
		//-> 로컬 변수인 경우 변수 선언시 준비되고, 변수 사용 범위를 벗어나면 소멸. 객체는 heap 영역에서 쓰레기 객체가 된다. 가비지 컬렉터의 수집 대상이 된다.
		Sample s = new Sample();
		
		//객체 생성후 에 객체가 가진 멤버(메소드) 접근 가능
		//->메소드 호출
		//->메소드 시그니처를 분석해서 매개변수와 반환값을 분석해야 한다.
	
		//매개변수, 반환값이 없는 메소드 호출
		//->메소드 시그니처->void method1()
		//->변수.메소드명()
		//->메소드 선언 위치 이동시 Ctrl + 메소드이름 클릭
		s.method1();
		
		//매개변수가 있는, 반환값이 없는 메소드 호출
		//->메소드 시그니처->void method2(int x, int y)
		//->변수.메소드명(값1, 값2)
		//->전달하는 값은 매개변수의 자료형, 순서, 개수를 맞춰서 전송해야 한다.
		s.method2(10, 20);
		
		//s.method2(); //매개변수 값이 없음.
		//s.method2(10); //매개변수 값이 1개임.
		//s.method2(10, 20, 30); //매개변수 값이 3개임.
		//s.method2(10.0, 20.0); //자료형 불일치.
		
		
		//매개변수, 반환값이 있는 메소드 호출
		//->메소드 시그니처->int method3(int x, int y)
		//->자료형 변수 = 변수.메소드명(값1, 값2);
		//->전달하는 값은 매개변수의 자료형, 순서, 개수를 맞춰서 전송해야 한다.
		int result1 = s.method3(10, 20);
		System.out.println(result1);

		//결과를 돌려받을 수 없다.
		s.method3(10, 20);
		
		System.out.println(s.method3(10, 20));

		//자동 형변환 불가
		//char result2 = s.method3(10, 20);
		
		//자동 형변환 가능
		double result3 = s.method3(10, 20);
		
		//자동 형변환 불가
		//String result4 = s.method3(10, 20);
		
		
		
	}

}
