package com.test;

import java.util.Arrays;

public class Sample140 {

	public static void main(String[] args) {
		
		//배열의 배열에 대한 복사
		//Arrays 클래스의 copyOf(), copyOfRange() 메소드 사용.
		//System 클래스의 arraycopy() 메소드 사용.
		//얕은 복사(shallow copy), 깊은 복사(deep copy)

		
		//-------------------
		int[] arr1 = {10, 20, 30, 40, 50};

		int[] arr2 = Arrays.copyOf(arr1, arr1.length);
		
		++arr1[0];
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
		
		
		//-------------------
		int[][] arr3 = {{10, 20, 30}, {40, 50}};
		
		int[][] arr4 = Arrays.copyOf(arr3, arr3.length);
		
		++arr3[0][0];
		
		//System.out.println(Arrays.toString(arr3));
		
		for (int[] arr : arr3) {
			for (int a : arr) {
				System.out.printf("%d ", a);
			}
		}
		System.out.println();

		for (int[] arr : arr4) {
			for (int a : arr) {
				System.out.printf("%d ", a);
			}
		}
		System.out.println();
		
		
		//-------------------
		int[][] arr5 = {{10, 20, 30}, {40, 50}};
		
		int[][] arr6 = Arrays.copyOf(arr5, arr5.length);
		arr6[0] = Arrays.copyOf(arr5[0], arr5[0].length);
		arr6[1] = Arrays.copyOf(arr5[1], arr5[1].length);

		++arr5[0][0];


		for (int[] arr : arr5) {
			for (int a : arr) {
				System.out.printf("%d ", a);
			}
		}
		System.out.println();

		for (int[] arr : arr6) {
			for (int a : arr) {
				System.out.printf("%d ", a);
			}
		}
		System.out.println();

		
	}

}
