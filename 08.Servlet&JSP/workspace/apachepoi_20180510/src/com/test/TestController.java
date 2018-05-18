package com.test;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestController extends HttpServlet {

	private static final long serialVersionUID = -27777817186348165L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//����� ��û �ּ� �м�
		// ->��û URI + invoke() �޼ҵ� ��� �ּ� �м�
		// ->http://211.63.89.68:8090/test/excel
		String viewPage = "error";

		String uri = request.getRequestURI();
		System.out.println("uri:"+uri);
		
		if (uri.contains("/test")) {
			uri = uri.substring(request.getContextPath().length());
			uri = uri.substring("/test/".length());
			
			//�ּ� �м� ��� -> Ư�� �׼� ��û
			try {
				TestHandler handler = new TestHandler();
				Method m = TestHandler.class.getMethod(uri, HttpServletRequest.class, HttpServletResponse.class);
				viewPage = (String)m.invoke(handler, request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}

			//��û ��� -> �� ���� -> ������ �Ǵ� �����̷�Ʈ
			if (viewPage != null && viewPage.contains("redirect:")) {
				response.sendRedirect(viewPage.substring("redirect:".length()));
			} else if (viewPage != null && viewPage.contains(".jsp")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
				dispatcher.forward(request, response);
			}/* else {
				PrintWriter out = response.getWriter();
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<title></title>");
				out.println("</head>");
				out.println("<body>");
				out.println("Error:bad request!");
				out.println("</body>");
				out.println("</html>");	
			}*/
		}

	}

}