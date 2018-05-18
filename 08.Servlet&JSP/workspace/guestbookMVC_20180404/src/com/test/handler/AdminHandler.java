package com.test.handler;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.AdminGuestBookDAO;
import com.test.domain.AdminGuestBook;
import com.test.util.Util;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;

public class AdminHandler {
	
	private AdminGuestBookDAO dao;
	
	public AdminHandler() {
		this.dao = new AdminGuestBookDAO();
	}
	
	
	///admin/booklist
	//->메소드 추가
	//->일반 사용자 접근 차단 기능 추가(로그인 필요) => LoginFilter로 대체
	public String booklist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String key = request.getParameter("key");
		String value = request.getParameter("value");

		if (key == null) {
			key = "ALL";
			value = "";
		}

		List<AdminGuestBook> gbList = this.dao.guestBookList(key, value);

		int totalCount = this.dao.totalCount();

		int gbListCount = gbList.size();
		
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("gbList", gbList);
		request.setAttribute("gbListCount", gbListCount);
		request.setAttribute("key", key);
		request.setAttribute("value", value);
		
		return "/WEB-INF/views/admin/adminbooklist.jsp";
	}
	
	
	///admin/blind
	//->메소드 추가
	public String blind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gid = request.getParameter("gid");
		String blind = request.getParameter("blind");

		//데이터베이스 액션 -> AdminGuestBookDAO클래스 blind() 메소드 호출
	 	AdminGuestBook agb = new AdminGuestBook();
		agb.setGid(gid);
		agb.setBlind(Integer.parseInt(blind));

		int result = dao.blind(agb);
		
		return String.format("redirect:%s/admin/booklist?success=%s", request.getContextPath(), result);
	}
	
	///admin/picturelist
	//->메소드 추가
	public String picturelist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<AdminGuestBook> picList = dao.picList("ALL", "");
		int picListLength = picList.size();
		
		request.setAttribute("picList", picList);
		request.setAttribute("picListLength", picListLength);
		
		return "/WEB-INF/views/admin/adminpicturelist.jsp";
	}
	
	
	///admin/pictureinsert
	//->메소드 추가
	//->파일 업로드 액션
	//->commons-fileupload-1.3.3.jar, commons-io-2.6.jar 라이브러리 필요
	public String pictureinsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//업로드된 파일에 대한 물리적 처리
		File file;
		int maxFileSize = 1 * 1024 * 1024;
		int maxMemSize = 1 * 1024 * 1024;
		//ServletContext context = pageContext.getServletContext();
		String filePath = request.getServletContext().getRealPath("resources//pictures");
		// Verify the content type
		String contentType = request.getContentType();
		String newFileName = "";
		String picContent = "";
		int result = 0;

		if ((contentType.indexOf("multipart/form-data") >= 0)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// maximum size that will be stored in memory
			factory.setSizeThreshold(maxMemSize);

			// Location to save data that is larger than maxMemSize. (임시폴더)
			factory.setRepository(new File("c:\\temp"));

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			// maximum file size to be uploaded.
			upload.setSizeMax(maxFileSize);

			try {
				// Parse the request to get file items.
				List<FileItem> fileItems = upload.parseRequest(request);

				// Process the uploaded file items
				Iterator<FileItem> i = fileItems.iterator();

				while (i.hasNext()) {
					FileItem fi = (FileItem) i.next();
					if (fi.isFormField()) {
						picContent = fi.getString("UTF-8");
					} else {
						// Get the uploaded file parameters
						String fieldName = fi.getFieldName();
						String fileName = fi.getName();
						boolean isInMemory = fi.isInMemory();
						long sizeInBytes = fi.getSize();

						// Write the file
						/* if( fileName.lastIndexOf("\\") >= 0 ) {
						   file = new File( filePath + "\\" + fileName.substring( fileName.lastIndexOf("\\"))) ;
						} else {
						   file = new File( filePath + "\\" + fileName.substring(fileName.lastIndexOf("\\")+1)) ;
						} */

						// 주의) 물리적 파일이름이 같은 파일인 경우 덮어쓰기가 된다. -> 유니크 파일 이름 생성 -> 확장자는 그대로 유지해야 한다. -> "동적 생성된 파일 이름.확장자"

						if (fileName.lastIndexOf(".") >= 0) {
							String ext = fileName.substring(fileName.lastIndexOf(".")); // 현재 파일의 확장자;
							newFileName = Util.randomFileName() + ext;//동적 생성된 이름 + 기존 확장자;
							file = new File(filePath + "\\" + newFileName);
						} else {
							newFileName = Util.randomFileName();//동적 생성된 이름 + 기존 확장자;
							file = new File(filePath + "\\" + newFileName);
						}
						System.out.println("File Insert: " + filePath + "\\" + newFileName);
						
						
						//콘텐츠 타입 검사 및 사용자 예외 발생
						//-> jpg, png만 허용하도록 설정

						fi.write(file); // 서버의 데이터를 물리적으로 기록(저장)

						//데이터 베이스에 사진 정보(파일 이름, 사진 설명) 저장
						AdminGuestBook agb = new AdminGuestBook();
						agb.setPicContent(picContent);
						agb.setPicName(newFileName);

						result = this.dao.pictureAdd(agb);
					}
				}
			} catch (Exception ex) {
				System.out.println(ex);
			}
		} else {

		}
		
		return String.format("redirect:%s/admin/picturelist?success=%s", request.getContextPath(), result);
	}
	
	
	///admin/picturedelete
	//->메소드 추가
	public String picturedelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pid = request.getParameter("pid");
	 	List<AdminGuestBook> list = this.dao.picList("pid", pid);
		
	 	int result = 0;
		//물리적 파일 삭제 -> 물리적경로명/파일이름
		if (list.size() > 0) {
			String filePath = request.getServletContext().getRealPath("resources//pictures");
			String fileName = list.get(0).getPicName();
			
			File file = new File(filePath + "\\" + fileName);
			System.out.println("File Delete: "+filePath + "\\" + fileName);
			
			if (file.exists()) {
				file.delete();
			}

			// 데이터베이스에서 정보 삭제
			result = this.dao.pictureRemove(pid);
		}

		
		return String.format("redirect:%s/admin/picturelist?success=%s", request.getContextPath(), result);
	}
	
	
}

