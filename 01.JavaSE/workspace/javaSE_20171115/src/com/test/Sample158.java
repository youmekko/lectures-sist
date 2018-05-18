package com.test;

import java.util.Arrays;
import java.util.Scanner;

public class Sample158 {

	public static void main(String[] args) {

		//문제) 중복되지 않은 난수 여러개를 얻는 프로그램 코드 작성.
		//로또 숫자 범위의 난수(1~45) 6개를 얻을때 중복된 숫자가 없는 상태로 얻어야 한다.
		//로또 숫자 6개를 한 번에 여러개 얻는 경우도 중복되면 안된다.
		//6개 숫자를 출력시 정렬된 상태로 출력해야 한다.
		//배열의 배열 사용
		
		/*
		
		출력예)
		원하는 장수(1~10)?5
		1) [1, 2, 3, 4, 5, 6]
		2) [1, 2, 3, 4, 5, 7]
		3) [13, 14, 15, 16, 17, 18]
		4) [19, 20, 21, 22, 23, 24]
		5) [25, 26, 27, 28, 29, 30]
		
		*/
		
		//배열 항목 비교
		/*
		int[] arr1 = {1, 2, 3, 4, 5, 6};
		int[] arr2 = {1, 2, 3, 4, 5, 6};
		int[] arr3 = {1, 2, 3, 4, 5, 7};
		int[] arr4 = {6, 1, 2, 3, 4, 5};
		System.out.println(Arrays.equals(arr1, arr2));
		System.out.println(Arrays.equals(arr1, arr3));
		System.out.println(Arrays.equals(arr1, arr4));
		*/
		
		
		//외부 입력 과정 추가
		Scanner sc = new Scanner(System.in);
		
		System.out.print("원하는 장수(1~10)?");
		int size = sc.nextInt();
		sc.nextLine();
		
		if (size >= 1 && size <= 10) {

			// 배열의 배열 준비
			int[][] array2 = new int[size][6];

			// 난수 발생 및 배열 요소 생성
			for (int b = 0; b < array2.length; ++b) {

				// 난수가 채워진 1차원 배열 요소 생성
				int[] array1 = new int[6];
				for (int a = 0; a < array1.length; ++a) {
					int random = (int) (Math.random() * 45) + 1;
					array1[a] = random;

					// 1차원 배열 요소의 중복 검사 과정 추가
					for (int k = 0; k < a; k++) {
						if (array1[k] == random) {
							--a;
							break;
						}
					}

				}
				// 난수가 채워진 1차원 배열 요소 정렬
				Arrays.sort(array1);

				// 배열의 배열에 1차원 배열 저장
				array2[b] = array1;

				// 배열의 배열에 저장된 기존 1차원 배열들과 새로 생성된 1차원 배열에 대한 중복 검사 과정 추가
				for (int k = 0; k < b; k++) {
					if (Arrays.equals(array2[k], array1)) {
						--b;
						break;
					}
				}

			}

			// 배열 요소 출력
			for (int c = 0; c < array2.length; ++c) {
				System.out.printf("%02d) : %s%n", (c + 1), Arrays.toString(array2[c]));
			}

		}
		
		sc.close();
		System.out.println("프로그램 종료.");
		
	}

}
