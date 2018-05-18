package com.test.ex003;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		// Spring Framework 준비
		// ->Ioc Container
		// ->객체 관리->메타데이터(xml)
		// ->사용자 요청->의존 주입(DI)->객체 제공
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/test/ex003/beans.xml");
		
		Member m1 = (Member) context.getBean("m1");
		System.out.println(m1.memberInfo());
		
		Member m2 = (Member) context.getBean("m2");
		System.out.println(m2.memberInfo());

		Member m3 = (Member) context.getBean("m3");
		System.out.println(m3.memberInfo());

	
		((ClassPathXmlApplicationContext)context).close();
		
	}

}
