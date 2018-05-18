package com.test.ex002;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		// Spring Framework �غ�
		// ->Ioc Container
		// ->��ü ����->��Ÿ������(xml)
		// ->����� ��û->���� ����(DI)->��ü ����
		ApplicationContext context = new FileSystemXmlApplicationContext("C://temp//beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

		obj.getMessage();
		
		((FileSystemXmlApplicationContext)context).close();

	}

}
