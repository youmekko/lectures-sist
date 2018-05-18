<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page
	import="java.io.*, javax.xml.transform.dom.*, javax.xml.transform.stream.*, javax.xml.parsers.*, javax.xml.transform.*, org.w3c.dom.*, org.xml.sax.*, java.net.*, org.json.*"%>
<%!
	private String convertDocumentToString(Document doc) {
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = tf.newTransformer();
			// below code to remove XML declaration
			// transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(doc), new StreamResult(writer));
			String output = writer.getBuffer().toString();
			return output;
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return null;
	}
%>
<%
	//JSP code
	request.setCharacterEncoding("UTF-8");
	String contextRoot = request.getContextPath();
	StringBuilder sb = new StringBuilder();

	//사용자 요청 수신 및 분석
	String key = "";
	String value = "";
	String start = "1";
	
 	String x = request.getParameter("x");
 	System.out.println(x);
 	
	JSONObject jobj = new JSONObject(x);
	key = jobj.getString("key");
	value = jobj.getString("value");
	start = jobj.getString("start");
 	
 	//인터파크 사이트에서 도서 요청
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = factory.newDocumentBuilder();
	Document xmlObj = null;
	String str = String.format(
			"http://book.interpark.com/api/search.api?key=7D000600C2E163DE162954A0168941F3F3509861765F0AFFE7CFDF915EF1F418&inputEncoding=utf-8&query=%s&queryType=%s&maxResults=20&start=%s",
			URLEncoder.encode(value, "UTF-8"), key, start);
	URL url = new URL(str);

	InputSource is = new InputSource(url.openStream());
	xmlObj = builder.parse(is);

	//인터파크로부터 전달받은 응답을 가지고 동적으로 XML 문자열 생성.	
	String xmlStr = convertDocumentToString(xmlObj);
	//System.out.println(xmlStr);

	//Ajax 응답 -> XML 포맷 문자열로 반환
	response.setContentType("text/xml; charset=UTF-8");
	response.getWriter().println(xmlStr);
%>