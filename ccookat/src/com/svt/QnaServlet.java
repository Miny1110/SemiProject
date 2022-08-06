package com.svt;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.BoardDTO;
import com.ccookat.CustomerInfo;
import com.ccookat.QnaDAO;
import com.ccookat.QnaDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
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

		request.setCharacterEncoding("UTF-8");

		Connection conn = DBConn.getconnection();
		QnaDAO qdao = new QnaDAO(conn);

		MyPage myPage = new MyPage(); 

		String cp = request.getContextPath();
		String uri = request.getRequestURI();
		String url;

		String root = getServletContext().getRealPath("/");
		String path = root + "pds" + File.separator + "qnaFile";
		// 이미지 저장 경로는 최상위pds파일에 각자 파일만들어서 저장하는걸로

		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}

		if(uri.indexOf("list.do")!=-1) {

			String pageNum = request.getParameter("pageNum");

			int currentPage = 1;

			if(pageNum!=null) {
				currentPage = Integer.parseInt(pageNum);
			}

			//검색
			String searchKey = request.getParameter("searchKey");
			String searchValue = request.getParameter("searchValue");

			if(searchValue==null){

				searchKey="qnaTitle";
				searchValue = "";
			} else {	
				if(request.getMethod().equalsIgnoreCase("GET")){
					searchValue = URLDecoder.decode(searchValue,"UTF-8");			
				}	
	
			}	

			int dataCount = qdao.getDataCount(searchKey, searchValue);
			int numPerPage = 5;

			int totalPage = myPage.getPageCount(numPerPage, dataCount);

			if(currentPage>totalPage) {
				currentPage=totalPage;
				//url = "/qna/qnaMain.jsp?pageNum="+currentPage;	
			}

			int start = (currentPage-1)*numPerPage+1;
			int end = currentPage * numPerPage;
			
			//실제 rownum가져오기
			List<QnaDTO> lists 
				= qdao.selectAll(start, end, searchKey, searchValue);

			String params = "";
			if(searchValue!=null && !searchValue.equals("")) {
				params = "searchKey=" + searchKey; 
				params = "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
			}

			String listUrl = cp + "/main/qna/list.do" + params;

			if(params.equals("")) {
				listUrl += "?" + params;			
			}

			String pageIndexList 
			= myPage.pageIndexList(currentPage, totalPage, listUrl);

			String deletePath = cp + "/main/qna/delete.do";

			String detailUrl = cp + "/main/qna/detail.do?pageNum=" + currentPage;

			if(!params.equals("")) {
				detailUrl += "&" + params;			
			}

			request.setAttribute("detailUrl", detailUrl);
			request.setAttribute("deletePath", deletePath);
			request.setAttribute("lists", lists);
			request.setAttribute("pageIndexList", pageIndexList);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("dataCount", dataCount);

			url = "/qna/qnaMain.jsp";
			forward(request, response, url);

		}else if(uri.indexOf("upload.do")!=-1) {


			url = "/qna/qnaUpload.jsp";
			forward(request, response, url);

		}else if(uri.indexOf("upload_ok.do")!=-1) {

			QnaDTO qdto = new QnaDTO();

			int maxnum = qdao.getMaxNum();

			qdto.setQnaNum(maxnum+1);
			qdto.setQnaTitle(request.getParameter("qnaTitle"));
			qdto.setCustomerId(request.getParameter("customerId"));
			qdto.setQnaContent(request.getParameter("qnaContent"));

			qdao.insertData(qdto);

			url = cp + "/main/qna/list.do?";
			response.sendRedirect(url);

		}else if(uri.indexOf("detail.do")!=-1) {
			
			//변수 받을 준비해
			int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
			String pageNum = request.getParameter("pageNum");

			//인코딩한 값을 넘겨 받음
			String searchKey = request.getParameter("searchKey");
			String searchValue = request.getParameter("searchValue");

			//인코딩한 값을 받고난 후 디코딩시키는 것
			if(searchValue!=null && !searchValue.equals("")) {
				searchValue = URLDecoder.decode(searchValue,"UTF-8");
				
			}
			
			QnaDTO qdto = QnaDAO.

			url = "/qna/qnaDetail.jsp";
			forward(request, response, url);
			
			
			
			
			

		} else if(uri.indexOf("delete.do")!=-1) {

			int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
			String pageNum = request.getParameter("pageNum");

			qdao.deleteData(qnaNum);

			url = cp + "/main/qna/list.do?pageNum=" + pageNum;
			response.sendRedirect(url);

		}

	}
}
