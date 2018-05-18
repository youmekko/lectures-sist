package com.score004;

//자료형 클래스
public class Score {
	
	//화면 설계를 토대로 분석한 결과를 필드로 구성 -> getter, setter 구성
	//번호(읽기 전용), 이름, 과목1, 과목2, 과목3, 총점(읽기 전용), 평균(읽기 전용)
	//읽기 전용 멤버는 getter만 구성한다.
	
	//필드 구성
	private String sid, name;
	private int sub1, sub2, sub3, tot;
	private double avg;
	
	//석차 정보 저장용 필드 추가
	//주의) 석차 초기값은 1로 설정해야 한다.
	private int rank = 1;

	//생성자
	public Score() {
	}
	public Score(String sid, String name, int sub1, int sub2, int sub3) {
		this.sid = sid;
		this.name = name;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
	}
	
	//getter, setter 구성
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSub1() {
		return sub1;
	}
	public void setSub1(int sub1) {
		this.sub1 = sub1;
	}
	public int getSub2() {
		return sub2;
	}
	public void setSub2(int sub2) {
		this.sub2 = sub2;
	}
	public int getSub3() {
		return sub3;
	}
	public void setSub3(int sub3) {
		this.sub3 = sub3;
	}
	public String getSid() {
		return sid;
	}
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	//총점 계산용 메소드
	public int getTot() {
		return this.sub1 + this.sub2 + this.sub3;
	}
	
	//평균 계산용 메소드
	public double getAvg() {
		return this.getTot() / 3.0;
	}

	//성적 정보 출력용 메소드
	public String scoreInfo() {
		return String.format("%-5s %-5s %5d %5d %5d %5d %5.1f %2d"
				, this.sid, this.name, this.sub1, this.sub2, this.sub3
				, this.getTot(), this.getAvg(), this.rank);
	}

}
