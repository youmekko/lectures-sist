package com.score001;

//(배열)저장소 관리 클래스
public class ScoreDAO {
	
	//(배열)저장소 생성 및 관리
	//(배열)저장소 인덱스 관리 변수
	private Score[] scoreArray = new Score[5];
	private int idx;
	 
	//성적 정보 입력 메소드
	public void scoreAdd(String sid, String name, int sub1, int sub2, int sub3) {

		// 객체 생성 및 (배열)저장소에 저장
		Score s = new Score(sid, name, sub1, sub2, sub3);
		this.scoreArray[this.idx] = s;
		// 인덱스 증가
		++this.idx;

	}
	
	//성적 정보 출력 메소드
	public String scoreList() {
		StringBuilder list = new StringBuilder();
		list.append(String.format("총 : %d건%n", this.idx));
		list.append(String.format("---------------------------------------%n"));
		list.append(String.format("번호  이름  과목1 과목2 과목3 총점 평균%n"));
		list.append(String.format("---------------------------------------%n"));
		for (Score i : this.scoreArray) {
			if (i == null)	continue;
			list.append(String.format("%s%n", i.scoreInfo()));
		}
		return list.toString();
	}

}
