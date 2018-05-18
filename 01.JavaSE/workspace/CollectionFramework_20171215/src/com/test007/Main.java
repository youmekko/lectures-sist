package com.test007;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//문제) 중복되지 않은 난수 여러개를 얻는 프로그램 코드 작성.
		//로또 숫자 범위의 난수(1~45) 6개를 얻을때 중복된 숫자가 없는 상태로 얻어야 한다.
		//로또 숫자 6개를 한 번에 여러개 얻는 경우도 중복되면 안된다.
		//6개 숫자를 출력시 정렬된 상태로 출력해야 한다.
		//Random 클래스, List, Set 컬렉션 사용
		
		/*
		
		출력예)
		원하는 장수(1~10)?5
		1) [1, 2, 3, 4, 5, 6]
		2) [1, 2, 3, 4, 5, 7]
		3) [13, 14, 15, 16, 17, 18]
		4) [19, 20, 21, 22, 23, 24]
		5) [25, 26, 27, 28, 29, 30]
		
		*/
		
		
		//중복되지 않은 6개의 숫자 세트 반환 받으면 그 자료를 출력, 반복 호출
		
		
		
		//1단계. 난수 발생
		/*
		Random random = new Random();
		for (int i=0; i<6; ++i) {
			System.out.println(random.nextInt(45) + 1);
		}
		*/
		
		//2단계. 중복되지 않은 6개의 숫자 세트
		/*
		Set<Integer> set = new HashSet<Integer>();
		Random random = new Random();
		while(true) {
			int temp = random.nextInt(45) + 1;
			set.add(temp);
			if (set.size() == 6) break;
		}
		for (Integer i : set) {
			System.out.println(i);
		}
		*/
		
		//3단계. 중복되지 않은 6개의 숫자 세트에 대한 정렬 
		/*
		Set<Integer> set = new HashSet<Integer>();
		Random random = new Random();
		while(true) {
			int temp = random.nextInt(45) + 1;
			set.add(temp);
			if (set.size() == 6) break;
		}
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		for (Integer i : list) {
			System.out.println(i);
		}
		*/
		
		//4단계. 중복되지 않은 6개의 숫자 세트에 대한 정렬 -> 메소드로 등록 및 호출
		/*
		for (int i=1; i<=10; ++i) {
			System.out.printf("%d) %s%n", i, Lotto.getNumbers().toString());
		}
		*/
		
		//5단계. 사용자가 원하는 장수 출력.
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 장수(1~10)?");
		int count = sc.nextInt();
		for (int i=1; i<=count; ++i) {
			System.out.printf("%d) %s%n", i, Lotto.getNumbers().toString());
		}
		sc.close();
		
	}

}
