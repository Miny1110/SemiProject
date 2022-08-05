package com.svt;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccookat.NoticeDAO;
import com.ccookat.QnaDAO;
import com.util.DBConn;
import com.util.MyPage;

@WebServlet("/QnaServlet")
public class QnaServlet extends HttpServlet {
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
		QnaDAO qdao = new QnaDAO(conn);

		MyPage myPage = new MyPage(); 

		String cp = request.getContextPath();
		String uri = request.getRequestURI();
		String url;
		
		if(uri.indexOf("list.do")!=-1) {
						
			url = "/qna/qnaMain.jsp";
			forward(request, response, url);	
		}

	}
}
