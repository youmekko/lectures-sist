package com.polymorphism001;

//실행 테스트 클래스
public class Main {

	public static void main(String[] args) {

		
		//다형성(Polymorphism)
		/*
		
		- 사전적 의미 : <생물> 같은 종(種)의 생물이면서도 어떤 형태나 형질이 다양하게 나타나는 현상. 예를 들면 암수에 따라 크기, 형태, 색깔 따위가 차이 나는 것이다. 
		- OOP 의미 : 같은 자료형이면서도 형질(객체)이 다양하게 나타나는 현상.
		- IS-A 관계인 경우 자식 객체를 조상 객체의 자료형 변수에 저장할 수 있다.
		- 예를 들어, '남자' 또는 '여자'라는 개념을 상위 개념인 '사람'으로 묶어서 표현할 수 있다.
		- 상위 개념의 변수에 하위 개념을 저장시 자동(암시적) 타입 변환이 일어난다.
		- 하위 개념의 변수에 상위 개념을 저장시 강제(명시적) 타입 변환이 필요하다.
		- 객체의 부품화 구현 가능. 타이어 자료형에 한국타이어 객체 또는 금호타이어 객체를 선택적으로 대입할 수 있다.
		- 주의) 상위 개념의 변수에 하위 개념의 객체 저장시 상위 개념의 능력 범위만 사용 가능하다. 부모 클래스의 메소드만 호출된다는 의미이다. 단, 오버라이딩(Overriding) 상태인 경우는 자식 메소드가 호출될 수 있다.
		
		*/
		
		//객체의 자료형과 변수의 자료형이 일치
		SuperClass sup1 = new SuperClass();
		 
		//객체의 자료형과 변수의 자료형이 불일치
		//->자동 타입 변환
		//->IS-A 관계인 경우만 허용
		//->다형성 
		//->객체의 부품화
		//->하위 자료형의 객체를 상위 자료형의 변수에 대입 가능
		SuperClass sup2 = new SubClass01();
		SuperClass sup3 = new SubClass02();
		
		//sup2, sup3 변수는 자료형이 SuperClass 이지만 
		//내부적으로 하위 자료형 객체를 저장하고 있다.
		System.out.println(sup2.toString()); //SubClass01
		System.out.println(sup3.toString()); //SubClass02
		

		//상위 자료형의 객체를 하위 자료형 변수에 저장 불가
		//Type mismatch: cannot convert from SuperClass to SubClass01
		//SubClass01 sub1 = new SuperClass();
		
		
		//sup2, sup3 변수는 자료형이 SuperClass 이지만 
		//내부적으로 하위 자료형 객체를 저장하고 있다.
		//SuperClass 자료형 변수에 저장된 하위 자료형 객체를 원래의 자료형 변수에 저장 가능
		//->강제(명시적) 형변환 필요
		SubClass01 sub1 = (SubClass01)sup2;
		
		//원래의 자료형 변수가 아닌 다른 자료형 변수에는 저장 불가
		//SubClass02 sub2 = (SubClass02)sup2; //ClassCastException
		
		
		//하위 자료형의 객체를 최상위 자료형(Object)의 변수에 대입 가능
		Object obj1 = new SubClass01();
		Object obj2 = new SubClass02();
		
	}

}
