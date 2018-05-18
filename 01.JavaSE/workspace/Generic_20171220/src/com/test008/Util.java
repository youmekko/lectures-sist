package com.test008;

public class Util<T> {
	
	private T[] array;
	
	@SuppressWarnings("unchecked")
	public Util(int size) {
		
		//타입 파라미터 자료형을 가지고 배열 선언시
		//new T[크기] 형태로 선언하지 못하고,
		//(T[])(new Object[크기]) 형태로 선언해야 한다.
		this.array = (T[])(new Object[size]);
	}

	public Object[] getArray() {
		return this.array;
	}

	public void add(T item, int index) {
		this.array[index] = item;
	}
	
	public T get(int index) {
		return this.array[index];
	}
	
}
