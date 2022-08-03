package com.svt;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccookat.ReviewDAO;
import com.ccookat.ReviewDTO;
//import com.join.CustomInfo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.util.DBConn;
import com.util.FileManager;
import com.util.MyPage;

public class ReviewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void forward(HttpServletRequest request, HttpServletResponse response, String url)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(url);

		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		
		Connection conn = DBConn.getconnection();
		ReviewDAO rdao = new ReviewDAO(conn);
		
		MyPage myPage = new MyPage();
		
		String cp = req.getContextPath();
		String uri = req.getRequestURI();
		
		String url;
		
		// 이미지 파일저장경로
		String root = getServletContext().getRealPath("/"); 
		String path = root + "pds" + File.separator + "imageFile";
		
		File f =  new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}
	if(uri.indexOf("main/review/created.do")!=-1) {
		
		url = "/review/created.jsp";
		forward(req, resp, url);
		
	}else if(uri.indexOf("main/review/list.do")!=-1) {
		//페이징 작업
		String pageNum = req.getParameter("pageNum");
		
		int currentPage = 1;
		if(pageNum!=null) 
			currentPage = Integer.parseInt(pageNum);
		
		//처음 전체 데이터 갯수 구하기
		int dataCount = rdao.getDataCount();
		//하나의 페이지에 보일 페이지 갯수
		int numPerPage = 5;
		int totalPage = myPage.getPageCount(numPerPage, dataCount);
		
		//삭제시 페이지수가 줄었을때 처리하는 방법 
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}

		//데이터베이스에서 가져올 rownum의 시작과 끝 구하기
		int start = (currentPage-1)*numPerPage+1;
		int end = currentPage*numPerPage; 
		
						
		start = (currentPage-1) * numPerPage + 1;
		end = currentPage * numPerPage;
		
		String listUrl = cp + "/main/review/list.do";
		String pageIndexList = myPage.pageIndexList(currentPage, totalPage, listUrl);
		//리스트 나오게 하기
		List<ReviewDTO> lists = rdao.getLists(start, end);
		String deletePath = cp + "/main/review/delete.do";
		String imagePath = cp + "/pds/imageFile";
		
		int totalArticle = rdao.getDataCount();
		
		req.setAttribute("imagePath", imagePath);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("deletePath", deletePath);
		req.setAttribute("lists", lists);
		req.setAttribute("pageIndexList", pageIndexList);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("totalArticle", totalArticle);
		req.setAttribute("currentPage", currentPage);
		
		System.out.println();
		url = "/review/list.jsp";
		forward(req, resp, url);
	
	}else if(uri.indexOf("created.do") != -1) {
	/*		HttpSession session = req.getSession();
			CustomInfo info = //이렇게 받을준비해서
					(CustomInfo)session.getAttribute("customInfo");
					
					if(info==null) {
				//여기 작성하기
				forward(req, resp, url);
				return;
				
			
			
					*/
		url = "/review/created.jsp";
		forward(req, resp, url);
	} else if (uri.indexOf("created_ok.do") != -1) {

		//파일업로드
		String encType = "UTF-8";
		int maxSize = 10 * 1024 * 1024;
		
		
		MultipartRequest mr = 
				new MultipartRequest(req, path, maxSize, encType,
						new DefaultFileRenamePolicy()); 
		
		ReviewDTO rdto = new ReviewDTO();
		int maxNum = rdao.getMaxNum();
		
		rdto.setReviewNum(maxNum+1);
		rdto.setCustomerId(req.getParameter("customerId"));
		rdto.setReviewTitle(req.getParameter("reviewTitle"));
		rdto.setReviewContent(req.getParameter("reviewContent"));
		rdto.setReviewImage(req.getParameter("reviewImage"));
		//rdto.setItemNum(Integer.parseInt(req.getParameter("itemNum")));
		rdto.setReviewCreated(req.getParameter("reviewCreated"));
		
		rdao.insertData(rdto);
		
		url = cp + "/main/review/list.do"; // 리다이렉트는 가상의주소로
		resp.sendRedirect(url);
		
	} else if (uri.indexOf("updated.do") != -1) {
		int reviewNum =Integer.parseInt(req.getParameter("reviewNum"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
	
			ReviewDTO rdto = rdao.getReadData(reviewNum);
			if (rdto == null) {
				url = cp + "main/review/list.do";
				resp.sendRedirect(url);}
			

			url = "/review/updated.jsp";
			forward(req, resp, url);
	
	
	} else if (uri.indexOf("updated_ok.do") != -1) {
		
		int reviewNum =Integer.parseInt(req.getParameter("reviewNum"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		
		ReviewDTO rdto = new ReviewDTO();
		
		rdto.setReviewNum(Integer.parseInt(req.getParameter("reviewNum")));
		rdto.setCustomerId(req.getParameter("custocmerId"));
		rdto.setReviewTitle(req.getParameter("reviewTitle"));
		rdto.setReviewContent(req.getParameter("reviewContent"));
		rdto.setReviewImage(req.getParameter("reviewImage"));
		
		rdao.updateData(rdto);
		
		url = cp + "/main/review/list.dopageNum="+pageNum ;
		resp.sendRedirect(url);
	} else if (uri.indexOf("deleted.do") != -1) {
		
		int reviewNum = Integer.parseInt(req.getParameter("reviewNum"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		
		ReviewDTO rdto = rdao.getReadData(reviewNum);
		
		rdao.deleteData(reviewNum);
		
		url = cp + "/main/review/list.do?pageNum="+pageNum ;
		resp.sendRedirect(url);
	}
		
}
	}

	
