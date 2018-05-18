package com.bank003;

//(배열)저장소 관리 클래스
public class DAO {
	
	//계좌 객체 저장용 저장소(배열) 준비. 기본 크기는 5.
	private Account[] accountArray = new Account[5];
	//인덱스 관리용 임시 변수
	private int idx;

	//매개변수를 통해서 전달되는 계좌 객체를 저장소에 저장하는 메소드
	//instance 메소드
	public void accountAdd(Account account) {
		
		//두 개 이상의 객체 저장을 위해서 인덱스 관리 필요
		//->저장소 부족시 크기 자동 증가 액션 필요
		this.accountArray[this.idx] = account;

		//인덱스 자동 증가
		++this.idx;
	}
	
	//계좌 목록 정보를 반환하는 메소드
	public Account[] accountList() {
		//참조주소 반환
		return this.accountArray;
	}
	
}
