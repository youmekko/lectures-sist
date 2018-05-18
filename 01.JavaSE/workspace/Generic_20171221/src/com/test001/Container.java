package com.test001;

//제네릭 지원 클래스
public class Container<T> {
	
	private T t;
	
	public void set(T t) {
		this.t = t;
	}
	
	public T get() {
		return this.t;
	}
	
}
