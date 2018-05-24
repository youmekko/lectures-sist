package com.test.sts;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/test")
	public String test() {
		
		return "test";
	}
	
	@RequestMapping("/excel")
	public void excel(HttpServletResponse response) throws ServletException, IOException {
		
		// Create blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// Create a blank sheet
		XSSFSheet spreadsheet = workbook.createSheet("Test");
		
		// Create row object
		XSSFRow row;
		
		// This data needs to be written (Object[])
		Map<String, Object[]> empinfo = new HashMap<String, Object[]>();
		empinfo.put("1", new Object[] { "EMP ID", "EMP NAME", "DESIGNATION" });
		empinfo.put("2", new Object[] { "tp01", "Gopal", "Technical Manager" });
		empinfo.put("3", new Object[] { "tp02", "Manisha", "Proof Reader" });
		empinfo.put("4", new Object[] { "tp03", "Masthan", "Technical Writer" });
		empinfo.put("5", new Object[] { "tp04", "Satish", "Technical Writer" });
		empinfo.put("6", new Object[] { "tp05", "Krishna", "Technical Writer" });
		
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
