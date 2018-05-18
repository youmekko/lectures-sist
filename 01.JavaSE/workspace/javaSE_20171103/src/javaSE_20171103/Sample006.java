package javaSE_20171103;

public class Sample006 {

	public static void main(String[] args) {
		/*
		char
		
		char data type is a single 16-bit Unicode character
		Minimum value is '\u0000' (or 0)
		Maximum value is '\uffff' (or 65,535 inclusive)
		Char data type is used to store any character
		Example: char letterA = 'A'
		
		
		0 -> 48
		1 -> 49
		...
		A -> 65 -> 0x41
		B -> 66
		...
		a -> 97
		b -> 98
		...
		
		*/
		
		char a = 'A';
		
		char b = '0';
		
		//int 자료형의 리터럴을 char 자료형 변수에 저장
		//->암시적 형변환
		char c = 65;
		
		//16진수 리터럴을 char 자료형 변수에 저장
		char d = '\u0041';
		
		//범위 초과
		//컴파일에러:Invalid character constant
		//char e = 'AB';
		
		//잘못된 빈문자 표기
		//컴파일에러:Invalid character constant
		char f = '';
		
		//올바른 빈문자 표기
		char g = ' ';
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
	}

}
