package com.test;

public class Sample065 {

	public static void main(String[] args) {
		
		//중첩 for문 테스트
		
		//4x + 5y = 60 을 만족하는 모든 해를 구해서 출력.
		//x, y는 1~10 사이의 정수.
		
		//(x, y)는 (1,1), (1,2), ...(10, 10)를 모두 대입해서 방정식을 만족하는 경우 출력.
		//-> 중첩 for문 사용
		
		for (int x=1; x<=10; ++x) {
			for (int y=1; y<=10; ++y) {
				if ((4 * x) + (5 * y) == 60) {
					System.out.println("(" + x + ", " + y + ")");
				}
			}
		}
		
	}

}
