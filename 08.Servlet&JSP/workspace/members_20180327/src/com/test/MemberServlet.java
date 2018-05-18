package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberServlet extends HttpServlet {

	private static final long serialVersionUID = -1053347790814974805L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ����� ���� �޼ҵ�
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ����� ���� �޼ҵ�
		process(req, resp);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		StringBuilder sb = new StringBuilder();
		StringBuilder dept = new StringBuilder();
		int count = 0;
		int totalCount = 0;
		String key = "ALL";
		String value = "";
		
		key = request.getParameter("key");
    	value = request.getParameter("value");
        if(key == null){
            key = "ALL";
            value = "";
        }
		
		//�����ͺ��̽� ���� �о�� ���(List<Member>)�� ���� ���̺� �±�(<table> ~ </table>)�� �����ϴ� ���� �߰�
		MemberDAO dao = new MemberDAO();
		totalCount = dao.totalCount();
		List<Member> list = dao.list(key, value);
		
		//�ο��� Ȯ��
		count = list.size();
		
		//���� ���̺� ����
		//-> <tr> ~ <tr> �±� �κи� �ۼ��Ѵ�.
		if (count == 0) {
			//��� �ڷᰡ �������� �ʴ� ���
			sb.append(String.format("<tr><td colspan=\"7\" style=\"text-align:center;\"> <strong>��� ����� �����ϴ�.</strong> </td></tr>"));
		} else {
			//��� �ڷᰡ �����ϴ� ���
			for(Member m : list){
				/* ���� ��ư�� �̺�Ʈ ��� �� ���� ��� ���� */
				sb.append(String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td><div class=\"btn-group\"><button type=\"button\" class=\"btn btn-default btn-xs\">Update</button><button type=\"button\" class=\"btn btn-default btn-xs\" onclick=\"location.assign('memberDelete.jsp?mid_=%s')\">Delete</button></div></td></tr>",m.getMid_(),m.getName_(),m.getPhone(),m.getEmail(),m.getRegDate(), m.getDeptName(), m.getMid_()));  
			}
		}
		
		List<Member> deptList = dao.deptList();
		for (Member m : deptList) {
			dept.append(String.format("<option value =\"%s\">%s</option>", m.getDeptId(), m.getDeptName()));
		}
		
		//����, ���� �޽��� ��¿� ����
		String success = request.getParameter("success");
		String msg = "";
		if (success == null) {
			//���� ����� �޽���
		} else {
			if (success.equals("1")) {
				//���� �޽���
				msg = "<span class=\"text-success\"><strong>Success!</strong> ȸ�� ������ �ԷµǾ����ϴ�.</span>";
			} else if (success.equals("0")) {
				//���� �޽���
				msg = "<span class=\"text-danger\"><strong>Fail!</strong> ȸ�� ���� �Է��� �����߽��ϴ�.</span>";
			}
		}		

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>                                                                                                                                                                                          ");
		out.println("<html>                                                                                                                                                                                                    ");
		out.println("<head>                                                                                                                                                                                                    ");
		out.println("<meta charset=\"UTF-8\">                                                                                                                                                                                    ");
		out.println("                                                                                                                                                                                                          ");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">                                                                                                                                      ");
		out.println("                                                                                                                                                                                                          ");
		out.println("<title>SIST_�ֿ뱳������</title>                                                                                                                                                                                ");
		out.println("                                                                                                                                                                                                          ");
		out.println("<link rel=\"stylesheet\"                                                                                                                                                                                    ");
		out.println("	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">                                                                                                                          ");
		out.println("                                                                                                                                                                                                          ");
		out.println("<style>                                                                                                                                                                                                   ");
		out.println("                                                                                                                                                                                                          ");
		out.println("div#input:hover, div#output:hover {                                                                                                                                                                       ");
		out.println("	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);                                                                                                                          ");
		out.println("}                                                                                                                                                                                                         ");
		out.println("                                                                                                                                                                                                          ");
		out.println("</style>                                                                                                                                                                                                  ");
		out.println("                                                                                                                                                                                                          ");
		out.println("<script                                                                                                                                                                                                   ");
		out.println("	src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>                                                                                                                       ");
		out.println("                                                                                                                                                                                                          ");
		out.println("<script                                                                                                                                                                                                   ");
		out.println("	src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>                                                                                                                    ");
		out.println("                                                                                                                                                                                                          ");
		out.println("<script>                                                                                                                                                                                                  ");
		out.println("	$(document).ready(function() {                                                                                                                                                                         ");
		out.println("                                                                                                                                                                                                          ");
		out.println("		var key = \""+key+"\";                                                                                                                                                                              ");
		out.println("		var value = \""+value+"\";                                                                                                                                                                          ");
		out.println("        $(\"select#key > option[value=\"+key+\"]\").attr(\"selected\",\"selected\");                                                                                                                              ");
		out.println("        $(\"input#value\").val(value);                                                                                                                                                                      ");
		out.println("                                                                                                                                                                                                          ");
		out.println("	});                                                                                                                                                                                                    ");
		out.println("</script>                                                                                                                                                                                                 ");
		out.println("</head>                                                                                                                                                                                                   ");
		out.println("<body>                                                                                                                                                                                                    ");
		out.println("                                                                                                                                                                                                          ");
		out.println("	<div class=\"container\">                                                                                                                                                                                ");
		out.println("                                                                                                                                                                                                          ");
		out.println("		<div class=\"panel page-header\" style=\"text-align:center;\">                                                                                                                                         ");
		out.println("			<h1 style=\"font-size:xx-large;\">                                                                                                                                                               ");
		out.println("				<a href=\"\"><img src=\"img/sist_logo.png\" alt=\"sist_logo.png\"> </a>                                                                                                                          ");
		out.println("				ȸ������ <small>v4.0</small> <span style=\"font-size:small; color: #777777;\">A website that manages personal information for members</span>                                                     ");
		out.println("			</h1>                                                                                                                                                                                          ");
		out.println("		</div>                                                                                                                                                                                             ");
		out.println("                                                                                                                                                                                                          ");
		out.println("		<div class=\"panel panel-default\" id=\"input\">                                                                                                                                                       ");
		out.println("			<div class=\"panel-heading\">ȸ������ �Է�</div>                                                                                                                                                       ");
		out.println("			<div class=\"panel-body\">                                                                                                                                                                       ");
		out.println("                                                                                                                                                                                                          ");
		out.println("				<form action=\"memberInsert.jsp\" method=\"post\">                                                                                                                                             ");
		out.println("					<div class=\"form-group\">                                                                                                                                                               ");
		out.println("						<label for=\"name_\">Name:</label> <input type=\"text\"                                                                                                                                ");
		out.println("							class=\"form-control\" id=\"name_\" name=\"name_\" placeholder=\"max:20\" required>                                                                                                    ");
		out.println("					</div>                                                                                                                                                                                 ");
		out.println("					<div class=\"form-group\">                                                                                                                                                               ");
		out.println("						<label for=\"phone\">Phone:</label> <input type=\"text\"                                                                                                                               ");
		out.println("							class=\"form-control\" id=\"phone\" name=\"phone\" placeholder=\"max:20\" required>                                                                                                    ");
		out.println("					</div>                                                                                                                                                                                 ");
		out.println("					<div class=\"form-group\">                                                                                                                                                               ");
		out.println("						<label for=\"email\">Email:</label> <input type=\"email\"                                                                                                                              ");
		out.println("							class=\"form-control\" id=\"email\" name=\"email\" placeholder=\"max:50\">                                                                                                             ");
		out.println("					</div>                                                                                                                                                                                 ");
		out.println("					                                                                                                                                                                                       ");
		out.println("					<div class=\"form-group\">                                                                                                                                                               ");
		out.println("						<label for=\"regDate\">RegDate:</label> <input type=\"date\"                                                                                                                           ");
		out.println("							class=\"form-control\" id=\"regDate\" name=\"regDate\">                                                                                                                              ");
		out.println("					</div>                                                                                                                                                                                 ");
		out.println("										                                                                                                                                                                   ");
		out.println("					<div class=\"form-group\">                                                                                                                                                               ");
		out.println("					  <label for=\"deptId\">DeptName:</label>                                                                                                                                                ");
		out.println("					  <select class=\"form-control\" id=\"deptId\" name=\"deptId\">                                                                                                                              ");
		out.println("					  	<!--                                                                                                                                                                               ");
		out.println("					    <option value=\"B01\">���ߺ�</option>                                                                                                                                                   ");
		out.println("					    <option value=\"B02\">�����ú�</option>                                                                                                                                                  ");
		out.println("					     -->                                                                                                                                                                               ");
		out.println("					    "+dept.toString()+"                                                                                                                                                               ");
		out.println("					  </select>                                                                                                                                                                            ");
		out.println("					</div>					                                                                                                                                                               ");
		out.println("					                                                                                                                                                                                       ");
		out.println("					<button type=\"submit\" class=\"btn btn-default\">Submit</button>                                                                                                                          ");
		out.println("    				"+msg+"                                                                                                                                                                            ");
		out.println("                                                                                                                                                                                                          ");
		out.println("				</form>                                                                                                                                                                                    ");
		out.println("                                                                                                                                                                                                          ");
		out.println("			</div>                                                                                                                                                                                         ");
		out.println("		</div>                                                                                                                                                                                             ");
		out.println("                                                                                                                                                                                                          ");
		out.println("		<div class=\"panel panel-default\" id=\"output\">                                                                                                                                                      ");
		out.println("			<div class=\"panel-heading\">ȸ������ ���</div>                                                                                                                                                       ");
		out.println("			<div class=\"panel-body\">                                                                                                                                                                       ");
		out.println("                                                                                                                                                                                                          ");
		out.println("				<table class=\"table table-striped\">                                                                                                                                                        ");
		out.println("					<thead>                                                                                                                                                                                ");
		out.println("						<tr>                                                                                                                                                                               ");
		out.println("							<th>Mid</th>                                                                                                                                                                   ");
		out.println("							<th>Name</th>                                                                                                                                                                  ");
		out.println("							<th>Phone</th>                                                                                                                                                                 ");
		out.println("							<th>Email</th>                                                                                                                                                                 ");
		out.println("							<th>RegDate</th>                                                                                                                                                               ");
		out.println("							<th>DeptName</th>                                                                                                                                                              ");
		out.println("							<th>Update/Delete</th>                                                                                                                                                         ");
		out.println("						</tr>                                                                                                                                                                              ");
		out.println("					</thead>                                                                                                                                                                               ");
		out.println("					<tbody>                                                                                                                                                                                ");
		out.println("						"+sb.toString()+"                                                                                                                                                                 ");
		out.println("					</tbody>                                                                                                                                                                               ");
		out.println("				</table>                                                                                                                                                                                   ");
		out.println("                                                                                                                                                                                                          ");
		out.println("				<form class=\"form-inline\" method=\"post\">                                                                                                                                                   ");
		out.println("					<div class=\"form-group\">                                                                                                                                                               ");
		out.println("						<button type=\"button\" class=\"btn btn-default\">TotalCount <span class=\"badge\">"+totalCount+"</span></button>                                                                       ");
		out.println("						<button type=\"button\" class=\"btn btn-default\">Count <span class=\"badge\">"+count+"</span></button>                                                                                 ");
		out.println("						<button	type=\"button\" class=\"btn btn-default\" ><span class=\"glyphicon glyphicon-step-backward\"></span> Previous</button>                                                           ");
		out.println("						<button	type=\"button\" class=\"btn btn-default\" >Next <span class=\"glyphicon glyphicon-step-forward\"></span></button>                                                                ");
		out.println("						                                                                                                                                                                                   ");
		out.println("						<select class=\"form-control\" id=\"key\" name=\"key\">                                                                                                                                  ");
		out.println("							<option value=\"mid_\">Mid</option>                                                                                                                                              ");
		out.println("							<option value=\"name_\">Name</option>                                                                                                                                            ");
		out.println("							<option value=\"phone\">Phone</option>                                                                                                                                           ");
		out.println("							<option value=\"email\">Email</option>                                                                                                                                           ");
		out.println("							<option value=\"regDate\">RegDate</option>                                                                                                                                       ");
		out.println("							<option value=\"deptName\">DeptName</option>                                                                                                                                     ");
		out.println("						</select>                                                                                                                                                                          ");
		out.println("					</div>                                                                                                                                                                                 ");
		out.println("					<div class=\"input-group\">                                                                                                                                                              ");
		out.println("						<input type=\"text\" class=\"form-control\" id=\"value\" name=\"value\"                                                                                                                    ");
		out.println("							placeholder=\"Search\" >                                                                                                                                                         ");
		out.println("                                                                                                                                                                                                          ");
		out.println("						<div class=\"input-group-btn\">                                                                                                                                                      ");
		out.println("							<button class=\"btn btn-default\" type=\"submit\">                                                                                                                                 ");
		out.println("								<i class=\"glyphicon glyphicon-search\"></i>                                                                                                                                 ");
		out.println("							</button>                                                                                                                                                                      ");
		out.println("						</div>                                                                                                                                                                             ");
		out.println("					</div>                                                                                                                                                                                 ");
		out.println("				</form>                                                                                                                                                                                    ");
		out.println("			</div>                                                                                                                                                                                         ");
		out.println("		</div>                                                                                                                                                                                             ");
		out.println("                                                                                                                                                                                                          ");
		out.println("	</div>                                                                                                                                                                                                 ");
		out.println("                                                                                                                                                                                                          ");
		out.println("</body>                                                                                                                                                                                                   ");
		out.println("</html>                                                                                                                                                                                                   ");
		
	}

}
