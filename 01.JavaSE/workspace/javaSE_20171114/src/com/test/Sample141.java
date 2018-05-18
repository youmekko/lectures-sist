package com.test;

import java.util.Arrays;

public class Sample141 {

	public static void main(String[] args) {

		//배열 복사
		//Arrays 클래스의 copyOf(), copyOfRange() 메소드 사용.
		//System 클래스의 arraycopy() 메소드 사용.
		//얕은 복사(shallow copy), 깊은 복사(deep copy)
		
		int[] arr1 = {10, 20, 30, 40, 50};
		System.out.println(Arrays.toString(arr1));
		
		//-------------------
		int[] arr2 = Arrays.copyOf(arr1, arr1.length);
		System.out.println(Arrays.toString(arr2));
		
		//-------------------
		int[] arr3 = new int[arr1.length];
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);
		System.out.println(Arrays.toString(arr3));
		
	}

}
