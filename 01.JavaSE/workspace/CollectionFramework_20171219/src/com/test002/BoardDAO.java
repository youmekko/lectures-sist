package com.test002;

import java.util.ArrayList;
import java.util.List;

//(컬렉션)저장소 관리
//게시물을 가져오는 클래스
public class BoardDAO {
	
	//(컬렉션)저장소 준비
	private List<Board> list = new ArrayList<Board>();
	
	//(컬렉션)저장소에 객체 자료 저장
	public BoardDAO() {
		Board b1 = new Board("제목1", "내용1");
		Board b2 = new Board("제목2", "내용2");
		Board b3 = new Board("제목3", "내용3");
		this.list.add(b1);
		this.list.add(b2);
		this.list.add(b3);
	}

	//(컬렉션)저장소에 저장된 객체 자료를 반환
	public List<Board> getBoardList() {
		return this.list;
	}

}
