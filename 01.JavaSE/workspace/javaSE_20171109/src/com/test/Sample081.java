package com.test;

public class Sample081 {

	public static void main(String[] args) {
		
		//String 클래스(문자열 자료형)
		
		/*
		
		문자는 char, 문자열은 String
		문자는 'A', 문자열은 "TEST"
		(참조 자료형) 클래스는 메소드를 지원한다.
		객체가 저장된 변수.메소드()
		
		*/

		char a = 'A';
		System.out.println(a);
		
		String b = "A";
		System.out.println(b.toString());
		
		
		//charAt() 메소드 : 특정 위치(Index) 문자 반환
		String s = "Strings are immutable";
		char result = s.charAt(8);
		System.out.println(result);
		
		
		//equals() 메소드 : 문자열 값 비교시 ==가 아니라 equals() 메소드 사용.
		String Str1 = new String("This is really not immutable!!");
		String Str2 = Str1;
		String Str3 = new String("This is really not immutable!!");
		boolean retVal;

		retVal = Str1 == Str3;
		System.out.println("Returned Value = " + retVal);

		retVal = Str1 == Str2;
		System.out.println("Returned Value = " + retVal);

		retVal = Str1.equals(Str3);
		System.out.println("Returned Value = " + retVal);
		
		
		//indexOf(String str) : 매개변수에 전달된 문자열이 시작되는 인덱스 반환. 검색 결과가 없으면 -1 반환.
		String Str = new String("Welcome to Tutorialspoint.com");
		String SubStr1 = new String("Tutorials");
		System.out.println("Found Index :" + Str.indexOf(SubStr1));
		
		
		//length() : 문자열의 길이(문자의 수)를 반환
		String Str4 = new String("Welcome to Tutorialspoint.com");
		System.out.print("String Length :");
		System.out.println(Str4.length());
		
		
		//substring(int beginIndex) : 문자열의 일부(beginIndex~)만 반환
		String Str5 = new String("Welcome to Tutorialspoint.com");
		System.out.print("Return Value :");
		System.out.println(Str5.substring(10));
		
		
		//substring(int beginIndex, int endIndex) : 문자열의 일부(beginIndex~endIndex)만 반환
		String Str6 = new String("Welcome to Tutorialspoint.com");
		System.out.print("Return Value :");
		System.out.println(Str6.substring(10, 15));
		
		
		//replace(char oldChar, char newChar) : 문자열 일부를 다른 문자열로 치환
		String Str7 = new String("Welcome to Tutorialspoint.com");
		System.out.print("Return Value :");
		System.out.println(Str7.replace('T', 't'));
		
		
		//주의) 동일한 문자열이 여러번 검색되는 경우
		String Str8 = new String("자바 JAVA 자바 JSP 오라클 자바");
		System.out.println("Found Index :" + Str8.indexOf("자바"));
		System.out.println("Return Value :" + Str8.replace("자바", "java"));
		
		
		//toLowerCase(), toUpperCase() : 문자열을 소문자로 변환, 대문자로 변환
		String Str9 = new String("Welcome to Tutorialspoint.com");
		System.out.println("Return Value :" + Str9.toLowerCase());
		System.out.println("Return Value :" + Str9.toUpperCase());
		
		//주의) 문자열 비교시 equals(), equalsIgnoreCase() 구분해서 사용.
		
		
		//trim() : 문자열의 앞뒤 공백 제거한 후 반환
		String Str10 = new String("   Welcome to Tutorialspoint.com   ");
		System.out.println("Return Value :[" + Str10 + "]");
		System.out.println("Return Value :[" + Str10.trim() + "]");
		System.out.println("Return Value :[" + Str10.replace(" ", "") + "]");
		
		
		//valueOf() : 기본 자료형의 값을 String 자료형으로 변환 후 반환
		int g = 10;
		double h = 12.123;
		System.out.println(g + 10);
		System.out.println(String.valueOf(g) + 10);
		
	}

}
