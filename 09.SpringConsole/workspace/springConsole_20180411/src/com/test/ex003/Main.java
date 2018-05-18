package com.test.ex003;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		// Spring Framework �غ�
		// ->Ioc Container
		// ->��ü ����->��Ÿ������(xml)
		// ->����� ��û->���� ����(DI)->��ü ����
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
