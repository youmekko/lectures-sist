package com.test;

public class Sample111 {

	public static void main(String[] args) {
		
		//배열 요소 정렬
		
		//정렬 : 요소를 크기순으로 나열하는 행위. 오름차순, 내림차순
		//정렬 알고리즘(Bubble-두 인접한 원소를 검사하여 정렬하는 방법)을 적용한 정렬
		
		/*
		1. 배열 요소에 정렬되지 않은 기본자료형 요소 준비 -> 5개
		2. 두 인접한 요소 비교
		3. (오름차순인 경우)왼쪽 요소가 크고, 오른쪽 요소가 작은 경우 교환. 그렇지 않은 경우 통과.
		4. 비교와 교환 액션을 배열 요소 전체에 대해서 적용할 때까지 반복. 0-1, 1-2, 2-3, 3-4, ...
		5. 배열 요소 전체에 대한 비교, 교환 액션 한 번 진행한 상태를 1회전.
		6. 배열 요소 중에서 가장 큰 값이 가장 오른쪽에 위치한다.
		7. 2번~6번 과정을 반복. 단, 정렬이 끝난 요소는 제외.
		8. 비교 대상이 없어지면 반복 종료.
		*/
		
		String[] arr = {"java", "oracle", "html", "javascript", "css"};
		
		//정렬 전 출력
		for (String a : arr) {
			System.out.printf("%s ", a);
		}
		System.out.print("\n");

		//정렬 과정

		//아래 액션을 여러번 반복. 단, 정렬이 끝난 요소는 제외.
		//n은 0, 1, 2, 3, ..., 마지막값(배열요소의 갯수 - 2)으로 진행하기 위해서 반복문 사용
		//비교 및 교환(치환) 액션
		//주의) 문자열(String 자료형) 비교는 > 연산자로 비교 불가. compareTo() 메소드 사용.
		/*
		if (arr[n].compareTo(arr[n+1]) > 0) {
			int temp = arr[n+1];
			arr[n+1] = arr[n];
			arr[n] = temp;
		}
		*/
		for (int m = 1; m < arr.length; ++m) {
			for (int n = 0; n < arr.length - m; ++n) {
				if (arr[n].compareTo(arr[n+1]) > 0) {
					String temp = arr[n+1];
					arr[n+1] = arr[n];
					arr[n] = temp;
				}
			}
		}
		
		
		//정렬 후 출력
		for (String a : arr) {
			System.out.printf("%s ", a);
		}
		System.out.println();
		
		
	}

}
