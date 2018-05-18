package com.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentJDBCTemplate studentJDBCTemplate;
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		List<StudentMarks> list =  this.studentJDBCTemplate.listStudents();
		
		model.addAttribute("list", list);
		
		return "student"; ///WEB-INF/views/student.jsp
	}

	@RequestMapping("/insert")
	public String insert(StudentMarks st) {
		
		this.studentJDBCTemplate.create(st.getName(), st.getAge(), st.getMarks(), st.getYear());
		
		return "redirect:/student/list";
	}
	
}
