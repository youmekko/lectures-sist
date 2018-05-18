package com.test003;

public class UtilExample {

	public static void main(String[] args) {

		Pair<String, Integer> pair = new Pair<>("홍길동", 35);
		Integer age = Util.getValue(pair, "홍길동"); //O
		System.out.println(age); //35
		
		ChildPair<String, Integer> childPair = new ChildPair<>("홍삼원", 20);
		Integer childAge = Util.getValue(childPair, "홍삼순"); //O
		System.out.println(childAge); //null
		
		OtherPair<String, Integer> otherPair = new OtherPair<>("홍삼원", 20);
		//Integer otherAge = Util.getValue(otherPair, "홍삼원"); //X
		//System.out.println(otherAge);

		ChildPair<String, Integer> childPair2 = new ChildPair<>("홍삼원", 20);
		Integer childAge2 = Util.getValue(childPair2, "홍삼원"); //O
		System.out.println(childAge2); //20
		
		Pair<String, String> pair2 = new Pair<>("홍길동", "35");
		//Integer age2 = Util.getValue(pair2, "홍길동"); //X
		//System.out.println(age2);

	}

}
