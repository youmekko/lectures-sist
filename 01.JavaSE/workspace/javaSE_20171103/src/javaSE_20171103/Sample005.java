package javaSE_20171103;

public class Sample005 {

	public static void main(String[] args) {
		/*
		long
		
		Long data type is a 64-bit signed two's complement integer
		Minimum value is -9,223,372,036,854,775,808(-2^63)
		Maximum value is 9,223,372,036,854,775,807 (inclusive)(2^63 -1)
		This type is used when a wider range than int is needed
		Default value is 0L
		Example: long a = 100000L, long b = -200000L
		*/
		
		long a = 100;
		
		long b = 100L;
		
		//범위 초과
		//The literal 3000000000 of type int is out of range
		long c = 3000000000;
		
		long d = 3000000000L;
		
		
	}

}
