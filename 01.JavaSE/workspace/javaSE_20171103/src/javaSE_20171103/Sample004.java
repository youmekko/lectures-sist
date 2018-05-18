package javaSE_20171103;

public class Sample004 {

	public static void main(String[] args) {
		
		/*
		short
		
		Short data type is a 16-bit signed two's complement integer
		Minimum value is -32,768 (-2^15)
		Maximum value is 32,767 (inclusive) (2^15 -1)
		*/
		
		short a = 100;
		
		short b = 200;
		
		//범위 초과
		//컴파일에러:Type mismatch: cannot convert from int to short
		short c = 40000;
		
		
	}

}
