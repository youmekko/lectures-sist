package com.test.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.test.domain.AdminGuestBook;

@Repository
public class AdminGuestBookDAOImpl implements AdminGuestBookDAO {

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<AdminGuestBook> guestBookList(Map<String, Object> map) {
		return this.sqlSession.selectList("com.test.mapper.AdminGuestBookMapper.guestBookList", map);
	}

	@Override
	public int totalCount() {
		return this.sqlSession.selectOne("com.test.mapper.AdminGuestBookMapper.totalCount");
	}

	@Override
	public int blind(AdminGuestBook gb)  throws Exception {
		return this.sqlSession.update("com.test.mapper.AdminGuestBookMapper.blind", gb);
	}

	@Override
	public List<AdminGuestBook> picList(Map<String, Object> map) {
		return this.sqlSession.selectList("com.test.mapper.AdminGuestBookMapper.picList", map);
	}

	@Override
	public int pictureAdd(AdminGuestBook gb) throws Exception {
		return this.sqlSession.insert("com.test.mapper.AdminGuestBookMapper.pictureAdd", gb);
	}

	@Override
	public int pictureRemove(AdminGuestBook gb) throws Exception {
		return this.sqlSession.delete("com.test.mapper.AdminGuestBookMapper.pictureRemove", gb);
	}

}
