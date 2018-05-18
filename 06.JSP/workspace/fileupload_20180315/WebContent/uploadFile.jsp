<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*, java.text.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.disk.*"%>
<%@ page import="org.apache.commons.fileupload.servlet.*"%>
<%@ page import="org.apache.commons.io.output.*"%>
<%!
	/* 사용자 정의 메소드 추가 */
	private String randomFileName() {
	
	    long currentTime = System.currentTimeMillis();
	    SimpleDateFormat simDf = new SimpleDateFormat("HHMMmmyyyyssdd");
	    Random r = new Random();
	    String uniqueFileName = String.format("%04d%s", r.nextInt(1000), simDf.format(new Date(currentTime)));
	    
	    return uniqueFileName; 
	}
%>
<%
	request.setCharacterEncoding("UTF-8");

	String newFileName = "";

	File file;
	int maxFileSize = 5 * 1024 * 1024;
	int maxMemSize = 5 * 1024 * 1024;
	/* 
	ServletContext context = pageContext.getServletContext();
	String filePath = context.getInitParameter("file-upload");
 	*/
 	String filePath = request.getServletContext().getRealPath("data");
 	
	// Verify the content type
	String contentType = request.getContentType();

	if ((contentType.indexOf("multipart/form-data") >= 0)) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);

		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File("c:\\temp"));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// maximum file size to be uploaded.
		upload.setSizeMax(maxFileSize);

		try {
			// Parse the request to get file items.
			List fileItems = upload.parseRequest(request);

			// Process the uploaded file items
			Iterator i = fileItems.iterator();

			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>JSP File upload</title>");
			out.println("</head>");
			out.println("<body>");

			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				if (fi.isFormField()) {
					String content = fi.getString("UTF-8");
					System.out.println("content:"+content);
					out.println("content:" + content + "<br>");
				} else {
					// Get the uploaded file parameters
					String fieldName = fi.getFieldName();
					
					String fileName = fi.getName();
					System.out.println("original FileName:"+fileName + "<br>");
					out.println("original FileName:"+fileName + "<br>");
					
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();

					// Write the file
					/* 
					if (fileName.lastIndexOf("\\") >= 0) {
						file = new File(filePath + "\\" + fileName.substring(fileName.lastIndexOf("\\")));
					} else {
						file = new File(filePath + "\\" + fileName.substring(fileName.lastIndexOf("\\") + 1));
					}
					 */
					String ext = fileName.substring(fileName.lastIndexOf("."));
					newFileName = randomFileName() + ext;
					 
					 
					file = new File(filePath + "\\" + newFileName);
					System.out.println("new FilePath + FileName:"+(filePath + "\\" + newFileName));
					
					//주의) 물리적 파일이름이 같은 파일인 경우 덮어쓰기가 된다. -> 유니크 파일 이름 생성 -> 확장자는 그대로 유지해야 한다. -> "동적생성된파일이름.확장자"
					fi.write(file);
					
					out.println("new Filename: " + filePath + "\\" + newFileName + " (" + sizeInBytes + ")<br>");
				}
			}
			out.println("</body>");
			out.println("</html>");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	} else {
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet upload</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>No file uploaded</p>");
		out.println("</body>");
		out.println("</html>");
	}
%>

<img src="data/<%=newFileName%>" alt="">

