<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%-- 주의) Ajax 응답 페이지 구성시 불필요한 반환값을 작성하지 않는다. --%>
<%@ page import="java.util.*, com.test.*, org.json.*"%>
<%
	//JSP code
	request.setCharacterEncoding("UTF-8");
	String contextRoot = request.getContextPath();
	StringBuilder sb = new StringBuilder();

	//클라이언트가 전송한 데이터 수신 -> mid_
	String mid_ = request.getParameter("mid_");
	System.out.println(mid_);

	//데이터베이스에 질의 
	//-> list(String key, String value) 메소드
	//-> 반환받은 Member 객체를 이용해서 JSON 문서 동적 생성 
	//-> JSONObject, JSONArray 클래스 (json-20180130.jar 파일 필요)
	/*
	{
		"members":[{"mid_":"M01", "name_":"hong", "phone":"010-1234-1234", "email":"hong@test.com", "regDate":"2018-03-11", "deptName":"개발부"}]
	}
	*/
	MemberDAO dao = new MemberDAO();
	List<Member> list = dao.list("mid_", mid_);

	JSONArray jarray = new JSONArray();
	for (int i = 0; i < list.size(); ++i) {
		Member m = list.get(i);
		JSONObject temp = new JSONObject();
		temp.put("mid_", m.getMid_());
		temp.put("name_", m.getName_());
		temp.put("phone", m.getPhone());
		temp.put("email", m.getEmail());
		temp.put("regDate", m.getRegDate());
		temp.put("deptName", m.getDeptName());
		jarray.put(temp);
	}
	JSONObject jobj = new JSONObject();
	jobj.put("members", jarray);
	
	//Ajax 응답 처리
	out.println(String.format("myFunction(%s)",jobj.toString()));
	
%>