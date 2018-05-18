package com.test;

public enum Week {
	
	//열거타입(사용자 정의 자료형)
	//한정된 값 여러개를 묶어서 하나의 자료형으로 표현한 상태.
	//예를 들어, 요일명(월, 화, 수, 목, 금, 토, 일)
	//열거타입 이름은 관례적으로 첫글자는 대문자로 표기. 예를 들어, Week.
	//열거타입 안에 정의된 값은 모두 열거상수이고, 관례적으로 대문자로 표기. 예를 들어, MONDAY.
	//열거타입은 물리적으로 별도 작성(.java)하고, 별도 저장한다.
	
	/*
	
	public enum 열거타입명 {
		값1;
		값2;
		...
	}
	
	*/
	
	SUNDAY,
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY

}
