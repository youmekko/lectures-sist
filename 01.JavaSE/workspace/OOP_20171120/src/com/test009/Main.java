package com.test009;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		//by value, by reference 테스트
		
		Sample s = new Sample();
		
		//by value
		//-> 값 복사
		int a = 10;
		s.method1(a);
		System.out.printf("outer:%d%n",a);
		
		//by value + return
		int result = s.method3(a);
		System.out.printf("result:%d%n",result);
		
		//by reference
		//-> 참조주소 복사
		int[] arr = {10};
		s.method2(arr);
		System.out.printf("outer:%d%n",arr[0]);
		
		
		//자바에서의 by reference 상황
		//->Arrays.sort()
		int[] temp = {4, 3 , 5, 2, 1};
		Arrays.sort(temp);
		System.out.println(Arrays.toString(temp));
		

	}

}
