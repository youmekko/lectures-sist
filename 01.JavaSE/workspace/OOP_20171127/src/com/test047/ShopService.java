package com.test047;

public class ShopService {
	
	//chapter6. 확인문제18.
	
	//싱글톤(singleton)
	//Gof 디자인 패턴 중 하나.
	//객체 생성시 한 개 객체만 생성되도록 제한하는 방법.
	//->private 생성자에 의해 사용자 객체 생성 요청 제한
	//->전용 메소드(getInstance)에 의한 객체 생성 요청
	
	private static ShopService temp = new ShopService();
	
	private ShopService() {
	}
	
	public static ShopService getInstance() {
		//이미 생성된 객체의 참조주소 반환
		return temp;
	}

}
