package com.test.ex004;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		// Spring Framework �غ�
		// ->Ioc Container
		// ->��ü ����->��Ÿ������(xml)
		// ->����� ��û->���� ����(DI)->��ü ����
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/test/ex004/beans.xml");
		
		Member m1 = (Member) context.getBean("member");
		m1.setName("HONG");
		System.out.println(m1.memberInfo());
		
		Member m2 = (Member) context.getBean("member");
		System.out.println(m2.memberInfo());
	
		((ClassPathXmlApplicationContext)context).close();
		
	}

}
