package com.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
	
	@RequestMapping("/excel")
	public void excel(HttpServletResponse response) throws IOException {

		// Create blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// Create a blank sheet
		XSSFSheet spreadsheet = workbook.createSheet("Test");
		
		// Create row object
		XSSFRow row;
		
		// This data needs to be written (Object[])
		/*
		Map<String, Object[]> empinfo = new HashMap<String, Object[]>();
		empinfo.put("1", new Object[] { "EMP ID", "EMP NAME", "DESIGNATION" });
		empinfo.put("2", new Object[] { "tp01", "Gopal", "Technical Manager" });
		empinfo.put("3", new Object[] { "tp02", "Manisha", "Proof Reader" });
		empinfo.put("4", new Object[] { "tp03", "Masthan", "Technical Writer" });
		empinfo.put("5", new Object[] { "tp04", "Satish", "Technical Writer" });
		empinfo.put("6", new Object[] { "tp05", "Krishna", "Technical Writer" });
		*/
		Map<String, Object[]> empinfo = new HashMap<String, Object[]>();
		empinfo.put("1", new Object[] { "Mid", "Name", "Phone", "Email", "RegDate", "DeptName" });
		List<Member> list = this.jdbcTemplate.list("ALL", "");
		int count = list.size();
		for (int a=0; a<count; ++a) {
			Member m = list.get(a);
			empinfo.put(String.valueOf(a+2), new Object[] { m.getMid_(), m.getName_(), m.getPhone(), m.getEmail(), m.getRegDate(), m.getDeptName() });
		}

		
		// Iterate over data and write to sheet
		Set<String> keyid = empinfo.keySet();
		int rowid = 0;
		for (String key : keyid) {
			row = spreadsheet.createRow(rowid++);
			Object[] objectArr = empinfo.get(key);
			int cellid = 0;
			for (Object obj : objectArr) {
				Cell cell = row.createCell(cellid++);
				cell.setCellValue((String) obj);
			}
		}
		
		response.setHeader("Content-disposition","attachment;filename=" + "test.xlsx");
	    response.setHeader("Content-Type", "application/vnd.ms-excel; charset=MS949");
	    response.setHeader("Content-Description", "JSP Generated Data"); 
	    response.setHeader("Content-Transfer-Encoding", "binary;"); 
	    response.setHeader("Pragma", "no-cache;"); 
	    response.setHeader("Expires", "-1;");
	    
	    ServletOutputStream out = response.getOutputStream();
	    workbook.write(out);
	    out.close();
	    
	    workbook.close();		
		
	}
	
	
}
