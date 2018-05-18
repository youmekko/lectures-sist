package com.test001;

import java.util.ArrayList;
import java.util.List;

//(컬렉션)저장소 관리
//게시물을 가져오는 클래스
public class BoardDAO {

	//(컬렉션)저장소에 저장된 객체 자료를 반환
	public List<Board> getBoardList() {
		List<Board> list = new ArrayList<Board>();
		Board b1 = new Board("제목1", "내용1");
		Board b2 = new Board("제목2", "내용2");
		Board b3 = new Board("제목3", "내용3");
		list.add(b1);
		list.add(b2);
		list.add(b3);
		return list;
	}

}
