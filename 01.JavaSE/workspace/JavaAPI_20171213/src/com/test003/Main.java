package com.test003;

import java.lang.reflect.*;

public class Main {

	public static void main(String[] args) {
		
		//특정 클래스(Sample)에 대한 리플렉션(클래스 정보 분석)
		
		try {
			//Class 클래스의 forName() 메소드를 이용해서 메모리에 클래스 로드.
			Class obj = Class.forName("com.test003.Sample");
			
			//생성자 정보 분석
			Constructor[] constructors = obj.getDeclaredConstructors();
			for (Constructor con : constructors) {
				//생성자 이름 출력
				System.out.print(con.getName() + "(");
				//생성자의 매개변수 정보 분석
				Class[] parameters = con.getParameterTypes();
				for (int i=0; i<parameters.length; ++i) {
					System.out.print(parameters[i].getName());
					if (i<parameters.length - 1) {
						System.out.print(",");
					}
				}
				System.out.println(")");
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
