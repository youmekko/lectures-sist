package com.test012;

public class Main {

	public static void main(String[] args) {
		
		//메소드 오버로딩 테스트
		
		//객체 생성-> instance 메소드 호출 전제 조건 
		Calculator c = new Calculator();

		//오버로딩 메소드 호출
		int dec1 = 10;
		String bin1 = c.radixTransformation(dec1);
		System.out.printf("%d(10) -> %s(2)%n", dec1, bin1);
		
		String bin2 = "101010";
		int dec2 = c.radixTransformation(bin2);
		System.out.printf("%s(2) -> %d(10)%n", bin2, dec2);
		
		String hex = "FF";
		int dec3 = c.toHex(hex);
		System.out.printf("%s(16) -> %d(10)%n", hex, dec3);
		
		
	}

}
