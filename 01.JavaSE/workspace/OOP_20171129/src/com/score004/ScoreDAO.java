package com.score004;

import java.util.Arrays;

//(배열)저장소 관리 클래스
public class ScoreDAO {
	
	//(배열)저장소 생성 및 관리
	//(배열)저장소 인덱스 관리 변수
	private Score[] scoreArray = new Score[5];
	private int idx;
	 
	//성적 정보 입력 메소드
	//주의) 중복된 번호 사용시 입력 실패할 수 있다.
	public int scoreAdd(String sid, String name, int sub1, int sub2, int sub3) {
		
		int result = 0; //입력 실패의 경우
		
		//중복된 번호 검사 과정 추가 -> private 메소드로 구성
		if (this.sidCheck(sid)) {

			// 객체 생성 및 (배열)저장소에 저장
			Score s = new Score(sid, name, sub1, sub2, sub3);
			this.scoreArray[this.idx] = s;
			// 인덱스 증가
			++this.idx;
	
			//(배열)저장소 자동 증가 과정 추가
			//->큰 배열 준비하고, 기존 배열 요소 복사, 참조주소 연결
			if (this.idx % 5 == 0) {
				this.scoreArray = Arrays.copyOf(this.scoreArray, this.scoreArray.length + 5);
			}
			
			result = 1; //입력 성공의 경우
			
		} 
		
		return result;

	}
	
	//성적 정보 출력 메소드
	public String scoreList() {
		
		//석차 계산 메소드 호출
		this.rank();
		
		StringBuilder list = new StringBuilder();
		list.append(String.format("총 : %d건%n", this.idx));
		list.append(String.format("---------------------------------------%n"));
		list.append(String.format("번호  이름  과목1 과목2 과목3 총점 평균  석차%n"));
		list.append(String.format("---------------------------------------%n"));
		for (Score i : this.scoreArray) {
			if (i == null)	continue;
			list.append(String.format("%s%n", i.scoreInfo()));
		}
		return list.toString();
	}
	
	//석차 계산 메소드 -> private 메소드로 구성
	private void rank() {
		
		//석차 알고리즘
		//1. 배열에 성적 정보를 여러개 저장
		//2. 모든 석차 정보는 초기값 1로 설정
		//3. 기준 성적과 나머지 성적들을 비교해서 기준 성적보다 나머지 성적이 큰 경우가 있다면 기준 석차의 현재값을 +1 연산. 
		for (int a=0; a<this.scoreArray.length; ++a) {
			Score s1 = this.scoreArray[a];
			if (s1 == null) continue;
			
			for (int b=0; b<this.scoreArray.length; ++b) {
				Score s2 = this.scoreArray[b];
				if (s2 == null) continue;
				
				//기준 성적보다 나머지 성적이 큰 경우
				if (s1.getTot() < s2.getTot()) {
					//기준이 되는 성적정보에 있는 현재 석차 +1 액션
					s1.setRank(s1.getRank() + 1);
				}
				
			}
			
		}
		
	}
	
	
	//번호 중복 검사 메소드 -> private 메소드
	private boolean sidCheck(String sid) {
		boolean result = true;
		
		for (Score i : this.scoreArray) {
			if (i == null)	continue;
			
			if (sid.equals(i.getSid())) {
				result = false;
				break;
			}
		
		}
		
		return result;
	}
	

}
