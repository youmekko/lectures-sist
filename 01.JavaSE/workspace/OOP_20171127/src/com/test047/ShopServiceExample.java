package com.test047;

public class ShopServiceExample {

	public static void main(String[] args) {
		
		//ShopService 객체 요청
		//-> 싱글톤이 적용된 클래스이므로 동일한 객체가 된다.
		//-> static 메소드 호출
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();
		
		//참조주소 비교
		if (obj1 == obj2) {
			System.out.println("같은 객체입니다.");
		} else {
			System.out.println("다른 객체입니다.");
		}
		
		//new 연산자를 이용한 객체 생성->불가
		//The constructor ShopService() is not visible
		ShopService obj3 = new ShopService();
		

	}

}
