package com.test002;

import java.util.List;

public class ListExample {

	public static void main(String[] args) {
		
		BoardDAO dao = new BoardDAO();
		List<Board> list = dao.getBoardList();
		for (Board board : list) {
			System.out.printf("%s-%s%n", board.getTitle(), board.getContent());
		}
		/*
		제목1-내용1
		제목2-내용2
		제목3-내용3
		*/

	}

}
