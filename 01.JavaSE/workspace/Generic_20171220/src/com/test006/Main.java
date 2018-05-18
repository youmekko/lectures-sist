package com.test006;

public class Main {

	public static void main(String[] args) {
		
		Box<Integer> box1 = new Box<Integer>(); //O
		
		System.out.println(Util.getString1(box1)); //<Integer>
		System.out.println(Util.getString1(new Box<Double>())); //<Double>
		System.out.println(Util.getString1(new Box<String>())); //<String>

		System.out.println(Util.getString2(box1)); //O
		System.out.println(Util.getString2(new Box<Double>())); //O
		//System.out.println(Util.getString2(new Box<String>())); //X

		System.out.println(Util.getString3(box1)); //O
		//System.out.println(Util.getString3(new Box<Double>())); //X
		//System.out.println(Util.getString3(new Box<String>())); //X

	}

}
