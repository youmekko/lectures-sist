package com.test001;

public class Sample012 {

	public static void main(String[] args) {
		
		//Chapter10 확인문제6
		String[] strArray = {"10", "2a"};
		
		int value = 0;
		for (int i=0; i<=2; i++) {
			try {
				value = Integer.parseInt(strArray[i]);
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("인덱스 초과.");
			}catch(NumberFormatException e) {
				System.out.println("숫자로 변환 불가.");
			}finally {
				System.out.println(value);
			}
		}
		
		/*
		10
		숫자로 변환 불가.
		10
		인덱스 초과.
		10
		*/

	}

}
