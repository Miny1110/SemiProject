package com.svt;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccookat.NoticeDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.util.DBConn;
import com.util.MyPage;

@WebServlet("/NoticeServlet")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Connection conn = DBConn.getconnection();
		NoticeDAO ndao = new NoticeDAO(conn);
		
		MyPage myPage = new MyPage(); 
				
		String cp = request.getContextPath();
		String uri = request.getRequestURI();
		String url;
		
		String root = getServletContext().getRealPath("/");
		String path = root + "pds" + File.separator + "noticeFile";
		// 이미지 저장 경로는 최상위pds파일에 각자 파일만들어서 저장하는걸로

		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		if(uri.indexOf("list.do")!=-1) {

			url = "/notice/noticeMain.jsp";
			forward(request, response, url);

		}else if(uri.indexOf("write.do")!=-1) {
						
			url = "/notice/noticeUpload.jsp";
			forward(request, response, url);
			
		}else if(uri.indexOf("write_ok.do")!=-1) {

			String encType = "UTF-8";
			int maxSize = 10*1024*1024;
			
			MultipartRequest mr = 
					new MultipartRequest(request, path, maxSize, encType,
							new DefaultFileRenamePolicy());
			
			if(mr.getFile("upload.do")!=null) {
				
			
			}
		
		
		}else if(uri.indexOf("detail.do")!=-1) {
			
		}
		
	}

}
