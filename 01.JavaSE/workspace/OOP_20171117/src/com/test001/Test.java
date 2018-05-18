package com.test001;

//클래스 선언 과정과 객체 생성 과정 테스트
public class Test {
	
	//주의) toString() 메소드 멤버가 존재한다.
	
	//main() 메소드는 프로그램 실행시 JVM에 의해 자동 호출된다.
	public static void main(String[] args) {
		
		//객체 생성 과정 추가
		//클래스 변수 = new 클래스();
		Test t = new Test();

		//객체 정보 확인
		//객체 생성 후 변수를 통해서 객체의 멤버(필드, 메소드)를 접근할 수 있다. -> dot(.) 연산자
		System.out.println(t.toString());
		
		//존재하지 않는 멤버 접근시 에러.
		//The method test() is undefined for the type Test
		System.out.println(t.test());
		
	}

}
