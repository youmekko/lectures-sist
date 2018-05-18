package com.test;

public class Sample028 {

	public static void main(String[] args) {

		// 삼항(조건) 연산자
		// variable x = (expression) ? value if true : value if false

		// 짝수 -> 어떤 수를 2로 나눈 나머지가 0인 상태의 수
		int a = 20;
		System.out.println(((a % 2) == 0) ? "짝수" : "홀수");

		// 60점 이상 => 합격
		// 60점 미만 => 불합격
		int b = 60;
		System.out.println((b >= 60) ? "합격" : "불합격");

		// 세 개의 임의의 수 중에서 가장 큰 수를 얻는 과정
		int d = 40;
		int e = 30;
		int f = 10;

		int temp = (d > e) ? d : e;
		int max = (temp > f) ? temp : f;
		System.out.println(max);

		// 세 개의 임의의 수 중에서 가장 작은 수를 얻는 과정
		int g = 40;
		int h = 30;
		int i = 10;
		int temp2 = ????;
		int min = ????;
		System.out.println(min);
		
		

	}

}
