package com.test004;

import java.util.*;

public class MapExample {

	public static void main(String[] args) {
		
		//Map<String, Integer>에서 키(아이디)는 String 자료형, 값(점수)은 Integer 자료형
		//키는 중복 불가, 값은 중복 가능
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("blue", 96); //int -> Integer, 암시적 형변환 지원. AutoBoxing.
		map.put("hong", new Integer(86));
		map.put("white", 92);
		map.put("park", 70);
		map.put("choi", 80);
		
		//최고점수(아이디 포함), 평균점수, 점수합계 출력
		/*
		점수합계:XXX
		평균점수:XX.X
		최고점수:XX, OOO
		*/
		String name = null;
		int maxScore = 0;
		int totalScore = 0;
		double avgScore = 0.0;
		
		
		//반복문 -> Iterator를 이용한 반복문
		Set<String> set =  map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			int val = map.get(key); //Integer -> int, AutoUnBoxing
			System.out.printf("%s:%s%n", key, val);
			
			//합계
			totalScore += val;
			
			//최고점수
			if (maxScore <= val) {
				maxScore = val;
				name = key;
			}
			
		}
		
		//평균
		avgScore = totalScore / (double)map.size();
		
		System.out.println("--------------");
		System.out.printf("점수합계:%s%n", totalScore);
		System.out.printf("평균점수:%.1f%n", avgScore);
		System.out.printf("최고점수:%s, %s%n", maxScore, name);

	}

}
