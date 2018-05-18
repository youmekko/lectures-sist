package javaSE_20171103;

public class Sample007 {

	public static void main(String[] args) {
		/*
		double
		
		double data type is a double-precision 64-bit IEEE 754 floating point
		This data type is generally used as the default data type for decimal values, generally the default choice
		Double data type should never be used for precise values such as currency
		Default value is 0.0d
		Example: double d1 = 123.4
		
		
		부호(1bit) - 지수(11bit) - 가수(52bit)
		
		*/
		
		
		double b = 3.14;
		
		//int 자료형의 리터럴을 double 자료형에 저장
		//->암시적 형변환
		double a = 100;
		
		//접미사 D 사용 가능
		double c = 100D;
		
		//실수 리터럴 100.0
		double d = 100.0;
		
		//지수 표기 실수
		double f = 1.23E15;
		double g = 1.23E-15;

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(f);
		System.out.println(g);
		
		
	}

}
