package com.test.ex001;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		// Spring Framework �غ�
		// ->Ioc Container
		// ->��ü ����->��Ÿ������(xml)
		// ->����� ��û->���� ����(DI)->��ü ����
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/test/ex001/beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

		obj.getMessage();

		((ClassPathXmlApplicationContext)context).close();

	}

}
