package com.test009;

import java.io.*;

//자식 역할 클래스 -> 직렬화 가능 클래스
//부모는 직렬화 대상이 아니고, 자식만 직렬화 가능 클래스인 경우 부모의 필드는 직렬화 대상에서 제외된다.
//->자식 클래스에서 직렬화 진행시 부모 필드를 명시적 호출하는 과정을 추가한다.
public class Sub extends Super implements Serializable {
	
	private int c;
	
	public Sub() {
	}

	public Sub(int a, int b) {
		super(a, b);
	}

	public Sub(int a, int b, int c) {
		super(a, b);
		this.c = c;
	}

	public int getC() {
		return c;
	}
	
	//직렬화 과정에서 자동 호출되는 메소드
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeInt(this.getA()); //부모 필드를 직렬화 대상에 포함
		out.writeInt(this.getB()); //부모 필드를 직렬화 대상에 포함
		out.defaultWriteObject();
	}
	
	//역직렬화 과정에서 자동 호출되는 메소드
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		this.setA(in.readInt()); //부모 필드에 역직렬화 결과를 저장
		this.setB(in.readInt()); //부모 필드에 역직렬화 결과를 저장
		in.defaultReadObject();
	}

}
