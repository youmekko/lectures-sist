package com.test002;

//제네릭 지원 클래스
public class Container<K, V> {
	
	private K k;
	private V v;
	
	public void set(K k, V v) {
		this.k = k;
		this.v = v;
	}
	
	public K getKey() {
		return this.k;
	}
	
	public V getValue() {
		return this.v;
	}

}
