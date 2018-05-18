package com.test001;

public class Sample003 {

	public static void main(String[] args) {
		
		//예외(Exception) 및 예외처리
		
		//ArrayIndexOutOfBoundException
		//배열 사용시 정상 범위를 벗어나는 인덱스 요청시 발생
		
		int[] arr = {1, 2, 3, 4, 5};
		
		try {
			//예외 발생 가능 구문
			//배열 인덱스 사용시 arr.length는 배열 크기를 반환하므로 최대인덱스-1 이다.
			for (int a=0; a<=arr.length; ++a) {
				System.out.println(arr[a]);
			}
		} catch(Exception e) {
			//e.printStackTrace();
			//System.out.println(e.getMessage());
			System.out.println(e.toString());
		}

		//위에서 예외처리를 적용했기 때문에 이 부분은 정상 실행된다.
		System.out.println("프로그램 정상 종료.");
		

	}

}
