package com.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.domain.AdminGuestBook;
import com.test.domain.FileModel;
import com.test.service.AdminGuestBookService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Inject
	private AdminGuestBookService adminGuestBookService;
	
	@Autowired
	private ServletContext context;
	
	@RequestMapping("/booklist")
	public String booklist(Model model, String key, String value, String pageNum) {
		
		if (key == null) {
			key = "ALL";
			value = "";
		}
		
		if (pageNum == null) {
			pageNum = "1";
		}
		
		int limit_count = 20;
		int limit_offset = (limit_count * (Integer.parseInt(pageNum) - 1));
		int previous = Integer.parseInt(pageNum) - 1; 
		int next = Integer.parseInt(pageNum) + 1;
		
		Map<String, Object> map = new HashMap<>();
		map.put("key", key);
		map.put("value", value);
		map.put("limit_offset", limit_offset);
		map.put("limit_count", limit_count);
		
		List<AdminGuestBook> gbList =  this.adminGuestBookService.guestBookList(map);
		int gbListCount = gbList.size();
		int totalCount = this.adminGuestBookService.totalCount();
		
		model.addAttribute("gbList", gbList);
		model.addAttribute("gbListCount", gbListCount);
		model.addAttribute("key", key);
		model.addAttribute("value", value);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("previous", previous);
		model.addAttribute("next", next);
		model.addAttribute("limit_count", limit_count);	
		
		return "admin/adminbooklist";
	}

	@RequestMapping("/blind")
	public String blind(AdminGuestBook gb, RedirectAttributes rttr) {

		int result = 0;
		try {
			result = this.adminGuestBookService.blind(gb);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		rttr.addFlashAttribute("success", result);
		
		return "redirect:/admin/booklist";
	}

	@RequestMapping("/picturelist")
	public String picturelist(String key, String value, Model model) {

		if (key == null) {
			key = "ALL";
			value = "";
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("key", key);
		map.put("value", value);
		
		List<AdminGuestBook> picList =  this.adminGuestBookService.picList(map);
		model.addAttribute("picList", picList);
		
		return "admin/adminpicturelist";
	}

	@RequestMapping("/pictureinsert")
	public String pictureinsert(FileModel file, AdminGuestBook gb, RedirectAttributes rttr)  throws IOException {

		MultipartFile multipartFile = file.getFile();
		String uploadPath = context.getRealPath("") + "resources/pictures" + File.separator;
		System.out.println(uploadPath);
		String newFileName = java.util.UUID.randomUUID()+"-"+multipartFile.getOriginalFilename();
		FileCopyUtils.copy(multipartFile.getBytes(), new File(uploadPath + newFileName));
		
		gb.setPicName(newFileName);
		gb.setPicContent(file.getPicContent());
		
		int result = 0;
		try {
			result = this.adminGuestBookService.pictureAdd(gb);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		rttr.addFlashAttribute("success", result);
		

		return "redirect:/admin/picturelist";
	}

	@RequestMapping("/picturedelete")
	public String picturedelete(AdminGuestBook gb, RedirectAttributes rttr) {
		
		int result = 0;
		try {
			//사진 정보 삭제 -> 물리적 사진 정보 삭제는 제외
			result = this.adminGuestBookService.pictureRemove(gb);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		rttr.addFlashAttribute("success", result);
		
		return "redirect:/admin/picturelist";
	}

}
