package javaSE_20171103;

public class Sample001 {

	public static void main(String[] args) {
		
		//입력 -> 처리 -> 출력

		//입력 단계 -----------------
		//방법1
		//자료형 변수;
		//변수 = 값;
		//주의) 값(리터럴)은 자료형과 일치해야 한다.
		int b;
		b = 200;
		
		//방법2
		//자료형 변수 = 값;
		//주의) 값(리터럴)은 자료형과 일치해야 한다.
		int a = 100; 

		//처리 단계 -----------------
		//변수 a에 100을 더하는 연산
		a += 100;
		
		//출력 단계 -----------------
		//변수의 값을 읽어내서 콘솔에 출력
		System.out.println(a); 
		
	}

}
