package com.test;

import java.text.DecimalFormat;
import java.text.MessageFormat;

public class Sample085 {

	public static void main(String[] args) {
		
		//서식 지정 클래스
		//DecimalFormat, SimpleDateFormat, MessageFormat 클래스
		//java.text 패키지 등록 필요 -> import 구문
		
		double a = 123456.7890;
		
		DecimalFormat df = new DecimalFormat("0");
		System.out.println(df.format(a));
		
		System.out.println(new DecimalFormat("0.00").format(a));
		System.out.println(new DecimalFormat("0.0000000").format(a));
		System.out.println(new DecimalFormat("#").format(a));
		System.out.println(new DecimalFormat("#.##").format(a));
		System.out.println(new DecimalFormat("#.#######").format(a));
		System.out.println(new DecimalFormat("0,000").format(a));
		System.out.println(new DecimalFormat("#,###").format(a));
		System.out.println(new DecimalFormat("0.000E0").format(a));
		
		
		String name = "홍길동";
		String phone = "010-1234-1234";
		String email = "hong123@naver.com";
		System.out.println(name + ", " + phone + ", " + email);
		System.out.printf("%s, %s, %s %n", name, phone, email);
		System.out.println(String.format("%s, %s, %s", name, phone, email));
		System.out.println(MessageFormat.format("{0}, {1}, {2}", name, phone, email));
		
		Object[] myInfo = {"홍길동", "010-1234-1234", "hong123@naver.com"};
		System.out.println(MessageFormat.format("{0}, {1}, {2}", myInfo));

	}

}
