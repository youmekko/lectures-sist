package javaSE_20171103;

public class Sample003 {

	public static void main(String[] args) {
		
		/*
		byte
		   
		Byte data type is an 8-bit signed two's complement integer
		Minimum value is -128 (-2^7)
		Maximum value is 127 (inclusive)(2^7 -1)
		*/
		
		
		//정상적인 범위
		byte a = 10;
		
		//범위 초과
		//컴파일에러:Type mismatch: cannot convert from int to byte
		byte b = 200;
		
		
	}

}
