package com.test001;

public class Sample001 {

	public static void main(String[] args) {
		
		//예외(Exception) 및 예외처리
		/*
		
		- 예외는 사용자의 잘못된 조작이나, 개발자의 잘못된 코딩으로 인해 발생하는 프로그램 오류.
		- 예외 발생시 비정상적인 프로그램 종료를 일으킨다. 예외 처리를 통해서 정상적인 프로그램 진행을 유지할 수 있다.
		- 예외 종류 두 가지. Checked exceptions, Unchecked exceptions(Runtime Exceptions)
		- Checked exceptions는 컴파일 과정에 발견 가능. Runtime Exceptions은 실행 과정에서 발견 가능.
		- Runtime Exceptions은 실행 과정에서만 발견되기 때문에 사전에 예외를 대비해야 한다. 예외처리는 try~catch 또는 throws 구문을 이용한다.
		- try~catch 구문 형식
		try {
			//예외발생 가능한 구문
		}catch(예외종류 변수) {
			//예외처리 구문
		}
		주의) 예외종류를 잘 모르는 경우 Exception 클래스 지정시 모든 예외 catch 가능.
		주의) main() 메소드 내에 있는 액션인 경우 try~catch 구문으로 예외 처리.
		
		try {
			//예외발생 가능한 구문
		}catch(예외종류1 변수) {
			//예외처리 구문
		}catch(예외종류2 변수) {
			//예외처리 구문
		}catch(예외종류3 변수) {
			//예외처리 구문
		}
		주의) 예외종류가 여러개인 경우 상속 계층 구조에 맞춰서 작성해야 한다.
		
		try {
			//예외발생 가능한 구문
		}catch(예외종류1 | 예외종류2 | 예외종류3 변수) {
			//예외처리 구문
		}
		주의) 자바7 이후에만 사용 가능.
		
		- throws 구문 형식
		접근제한자 반환자료형 메소드이름(매개변수 리스트) throws 예외종류1, 예외종류2, ... {
			//예외발생 가능한 구문
		}
		주의) 사용자 정의 메소드 내에 있는 액션인 경우 throws 구문으로 예외 처리.

		
		*/
		
		
		//정상적인 자료 준비한 경우
		//String a = "TEST";

		//NullPointerException
		//->참조 자료형 변수에 정상적인 값이 없는 경우 발생
		String a = null;
		
		//예외 발생 가능 구문
		//->참조 자료형 변수에 null 이 있는 상태에서 하위 멤버 접근(. 연산자) 시도하면 예외 발생
		//->예외 발생시 프로그램 비정상 종료.
		System.out.println(a.toString());

		//프로그램 비정상 종료시 이 부분은 실행되지 않는다.
		System.out.println("프로그램 정상 종료.");
		

	}

}
