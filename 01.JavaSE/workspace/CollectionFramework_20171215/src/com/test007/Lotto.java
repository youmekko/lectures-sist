package com.test007;

import java.util.*;

public class Lotto {
	
	public static List<Integer> getNumbers() {
		List<Integer> result = null;
		
		//중복되지 않은 6개의 숫자 세트 반환하는 과정. 정렬 상태 지원.
		Set<Integer> set = new HashSet<Integer>();
		Random random = new Random();
		while(true) {
			int temp = random.nextInt(45) + 1;
			set.add(temp);
			if (set.size() == 6) break;
		}
		result = new ArrayList<Integer>(set);
		Collections.sort(result, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		return result;
	}

}
