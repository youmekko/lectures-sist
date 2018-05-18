package javaSE_20171103;

public class Sample008 {

	public static void main(String[] args) {
		/*
		float
		
		Float data type is a single-precision 32-bit IEEE 754 floating point
		Float is mainly used to save memory in large arrays of floating point numbers
		Default value is 0.0f
		Float data type is never used for precise values such as currency
		Example: float f1 = 234.5f
		
		부호(1bit) - 지수(8bit) - 가수(23bit)
		
		*/
		

		//접미사 F 필수 사용
		float a = 3.14F;
		
		//double 자료형의 리터럴을 float 자료형 변수에 저장 불가
		//Type mismatch: cannot convert from double to float
		float b = 3.14;
		
		
		//int 자료형의 리터럴을 float 자료형 변수에 저장 가능
		//->암시적 형변환
		float c = 100;
		
		//double 자료형의 리터럴을 float 자료형 변수에 저장 불가
		//Type mismatch: cannot convert from double to float
		float d = 100.0;
		

	}

}
