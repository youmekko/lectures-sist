package com.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberJDBCTemplate jdbcTemplate;
	
	@RequestMapping("/list")
	public String list(String key, String value, Model model) {
		
		if (key == null) {
			key = "ALL";
			value = "";
		}
		
		List<Member> list = this.jdbcTemplate.list(key, value);
		int count = list.size();
		int totalCount = this.jdbcTemplate.totalCount();
		
		List<Member> deptList = this.jdbcTemplate.deptList();
		
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("key", key);
		model.addAttribute("value", value);

		model.addAttribute("deptList", deptList);

		return "member"; ///WEB-INF/views/member.jsp
	}
	
	@RequestMapping("/insert")
	public String insert(Member m) {
		
		int result = 0;
		try {
			result = this.jdbcTemplate.memberAdd(m);
		}catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		
		return "redirect:/member/list?success=" + result;
	}
	
	@RequestMapping("/delete")
	public String delete(String mid_, RedirectAttributes rttr) {
		
		int result = 0;
		try {
			result = this.jdbcTemplate.memberRemove(mid_);
		}catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		
		rttr.addAttribute("success", result);
		
		return "redirect:/member/list";
	}
	
	@RequestMapping("/update")
	public String update(Member m, RedirectAttributes rttr) {
		
		int result = 0;
		try {
			result = this.jdbcTemplate.memberModify(m);
		}catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		
		rttr.addAttribute("success", result);
		
		return "redirect:/member/list";
	}
	
}
