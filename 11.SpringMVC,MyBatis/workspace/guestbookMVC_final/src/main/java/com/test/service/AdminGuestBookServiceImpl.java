package com.test.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.test.domain.AdminGuestBook;
import com.test.persistence.AdminGuestBookDAO;

@Service
public class AdminGuestBookServiceImpl implements AdminGuestBookService {

	@Inject
	private AdminGuestBookDAO adminGuestBookDAO;
	
	@Override
	public List<AdminGuestBook> guestBookList(Map<String, Object> map) {
		return this.adminGuestBookDAO.guestBookList(map);
	}

	@Override
	public int totalCount() {
		return this.adminGuestBookDAO.totalCount();
	}

	@Override
	public int blind(AdminGuestBook gb) throws Exception {
		return this.adminGuestBookDAO.blind(gb);
	}

	@Override
	public List<AdminGuestBook> picList(Map<String, Object> map) {
		return this.adminGuestBookDAO.picList(map);
	}

	@Override
	public int pictureAdd(AdminGuestBook gb) throws Exception {
		return this.adminGuestBookDAO.pictureAdd(gb);
	}

	@Override
	public int pictureRemove(AdminGuestBook gb) throws Exception {
		return this.adminGuestBookDAO.pictureRemove(gb);
	}

}
