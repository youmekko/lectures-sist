package com.test006;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//LIFO, FIFO 컬렉션
		//LIFO(Last In First Out) : 나중에 넣은 자료가 먼저 빠져나올 수 있는 자료 구조 형태. 대표적으로 Stack 클래스. 1, 2, 3 순으로 넣은 경우, 3, 2, 1순으로 꺼낼 수 있다.
		//FIFO(First In First Out) : 먼저 넣은 자료가 먼저 빠져나올 수 있는 자료 구조 형태. 대표적으로 Queue 인터페이스. 1, 2, 3 순으로 넣은 경우, 1, 2, 3순으로 꺼낼 수 있다.
		
		//Stack 클래스를 이용한 LIFO 구조
		Stack<Coin> coinBox = new Stack<Coin>();
		
		//push() 메소드는 객체를 입력할 때 사용
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(50));
		
		//pop() 메소드는 객체를 꺼낼 때 사용.
		//->특정 객체를 지정해서 꺼내는 것이 아니다.
		//->나중에 넣은 객체가 먼저 빠져나온다.
		//toString() 메소드 생략 가능
		System.out.printf("꺼내온 동전:%s%n", coinBox.pop());
		System.out.printf("꺼내온 동전:%s%n", coinBox.pop());
		System.out.printf("꺼내온 동전:%s%n", coinBox.pop());
		
		
		System.out.println("-------------");
		
		//Queue 인터페이스를 이용한 FIFO 구조
		Queue<Coin> coinBox2 = new LinkedList<Coin>();
		
		//offer() 메소드는 객체를 입력할 때 사용
		coinBox2.offer(new Coin(100));
		coinBox2.offer(new Coin(500));
		coinBox2.offer(new Coin(50));
		
		//poll() 메소드는 객체를 꺼낼 때 사용.
		//->특정 객체를 지정해서 꺼내는 것이 아니다.
		//->먼저 넣은 객체가 먼저 빠져나온다.
		//toString() 메소드 생략 가능
		System.out.printf("꺼내온 동전:%s%n", coinBox2.poll());
		System.out.printf("꺼내온 동전:%s%n", coinBox2.poll());
		System.out.printf("꺼내온 동전:%s%n", coinBox2.poll());


	}

}
