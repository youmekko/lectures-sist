package com.bank009;

//(배열)저장소 관리 클래스
//주의) 콘솔 관련 액션(입력, 출력) 넣지 않는다.
public class AccountDAO {
	
	//(배열)저장소 관련 필드, 메소드 구성
	//(배열)저장소 준비 -> 기본 크기 5로 지정
	private Account[] accountArray = new Account[5];
	//(배열)저장소 인덱스 관리용 전용 변수 준비
	private int idx;
	
	
	//계좌 생성하기 메소드
	//->클래스(객체) 외부에서 접근 가능한 메소드 선언은 public 접근제한자
	public void createAccount(String ano, String owner, int balance) {
		
		//계좌 객체 생성(Account 객체 생성) 및 (배열)저장소에 저장
		//->계좌 객체에 저장할 정보는 외부에서 매개변수를 통해서 전달 받는다.
		Account ac = new Account(ano, owner, balance);
		accountArray[idx] = ac;
		++idx;
		
	}
	
	
	// 계좌 목록보기 메소드
	public String accountList() {
		StringBuilder list = new StringBuilder();
		for (Account temp : this.accountArray) {
			if (temp == null) continue;
			list.append(temp.accountInfo());
		}
		return list.toString();
	}
	
	
	// 예금하기 메소드
	public void deposit(String ano, int balance) {

		Account account = this.findAccount(ano);
		account.setBalance(account.getBalance() + balance);

	}
	
	// 출금하기 메소드
	public void withdraw(String ano, int balance) {

		Account account = this.findAccount(ano);
		account.setBalance(account.getBalance() - balance);

	}
	
	// Account 배열에서 ano와 동일한 Account 객체 찾기
	public Account findAccount(String ano) {
		Account result = null;
		for (Account temp : this.accountArray) {
			if (temp == null)
				continue;
			if (temp.getAno().equals(ano)) {
				result = temp;
			}
		}
		return result;
	}
	 
}
