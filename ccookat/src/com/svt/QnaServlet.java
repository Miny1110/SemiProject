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

import com.ccookat.CartDAO;
import com.ccookat.CustomerInfo;
import com.ccookat.QnaDAO;
import com.ccookat.QnaDTO;
import com.ccookat.ReplyDAO;
import com.ccookat.ReplyDTO;
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
		String cp = request.getContextPath();
		String uri = request.getRequestURI();

		Connection conn = DBConn.getconnection();
		QnaDAO qdao = new QnaDAO(conn);
		//답변도 필요해서 추기
		ReplyDAO redao = new ReplyDAO(conn);
		//장바구니아이콘갯수 표시해야해서
		CartDAO ctdao = new CartDAO(conn);

		MyPage myPage = new MyPage(); 


		String url;

		//주소에 upload라는 이름이 있으면
		if(uri.indexOf("upload.do")!=-1) {
			
			HttpSession session = request.getSession();

			CustomerInfo customerInfo = new CustomerInfo();

			customerInfo = (CustomerInfo)session.getAttribute("customerInfo");

			if(customerInfo!=null) {
			String customerId = customerInfo.getCustomerId();

			int cartCount = ctdao.cartCount(customerId);
			request.setAttribute("cartCount", cartCount);
			}

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

			url = cp + "/main/qna/list.do";
			response.sendRedirect(url);

		} else if(uri.indexOf("list.do") != -1) {

			HttpSession session = request.getSession();

			CustomerInfo customerInfo = new CustomerInfo();

			customerInfo = (CustomerInfo)session.getAttribute("customerInfo");

			if(customerInfo==null) {
				url = "/main/customer/login.do";
				forward(request, response, url);
				return;
			}
			
			String customerId = customerInfo.getCustomerId();
			
			int cartCount = ctdao.cartCount(customerId);
			request.setAttribute("cartCount", cartCount);
			String pageNum = request.getParameter("pageNum");

			int currentPage = 1;

			if(pageNum!=null) {
				currentPage = Integer.parseInt(pageNum);
				//pageNum을 받아 currentPage에 넣어줌
			}

			//검색
			String searchKey="qnaTitle";
			String searchValue = request.getParameter("searchValue");

			if(searchValue==null){
				
				searchValue = "";

			}	

			int dataCount = qdao.getDataCount(searchKey, searchValue,customerId);
			
			int numPerPage = 5;

			int totalPage = myPage.getPageCount(numPerPage, dataCount);

			if(currentPage>totalPage) {
				currentPage=totalPage;
				//url = "/qna/qnaMain.jsp?pageNum="+currentPage;	
			}

			int start = (currentPage-1)*numPerPage+1;
			int end = currentPage * numPerPage;

			//실제 rownum가져오기
			
			
				List<QnaDTO> lists = 
						qdao.selectAll(start, end, searchKey, searchValue);

				String params = "";
				if(searchValue!=null && !searchValue.equals("")) {
					params = "?searchKey=" + searchKey; 
					params += "&searchValue=" + searchValue;
				}

				String listUrl = cp + "/main/qna/list.do";

				if(params.equals("")) {
					listUrl += "?" +params;			
				}

				String pageIndexList = 
						myPage.pageIndexList(currentPage, totalPage, listUrl);

				//글보기 주소 -> qnaDetail로 넘어가기 위한 주소
				String detailUrl = cp + "/main/qna/detail.do?pageNum=" + currentPage;

				if(!params.equals("")) {
					detailUrl += "&" + params;			
				}

				request.setAttribute("lists", lists);
				request.setAttribute("pageIndexList", pageIndexList);
				request.setAttribute("detailUrl", detailUrl);
				request.setAttribute("dataCount", dataCount);

				url = "/qna/qnaMain.jsp"+params;
				forward(request, response, url);
			
				//관리자 로그인시 뿌려주는거
				
				//관리자 답변 같이 보이게 하기
		}else if(uri.indexOf("detail.do")!=-1) {

			//변수 받을 준비해
			//int replyNum = Integer.parseInt(request.getParameter("replyNum"));
			int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
			String pageNum = request.getParameter("pageNum");
			
			
			//qna번호 매개로 조회수 업데이트 
			qdao.updateHitCount(qnaNum);
			
			//인코딩한 값을 넘겨 받음
			String searchKey = request.getParameter("searchKey");
			String searchValue = request.getParameter("searchValue");

			//인코딩한 값을 받고난 후 디코딩시키는 것
			if(searchValue!=null && !searchValue.equals("")) {
				searchValue = URLDecoder.decode(searchValue,"UTF-8");

			}
			
			//qna번호 매개로 객체 불러오는고
			QnaDTO qdto = qdao.getReadData(qnaNum);
			
			//리플번호 매체로 한놈만 불러오는고
			ReplyDTO redto = redao.getReadData(qnaNum);
			
			if(qdto==null) {
				url = cp + "/qna/qnaMain.do";
				response.sendRedirect(url);
			}
			
			List<ReplyDTO> replylists =redao.getLists();

			qdto.setQnaContent(qdto.getQnaContent().replaceAll("\r", "<br/>"));

			String params = "pageNum=" + pageNum;

			if(searchValue!=null && !searchValue.equals("")) {

				params += "&searchKey=" + searchKey;

				params += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
			}

			request.setAttribute("qdto", qdto);
			request.setAttribute("params", params);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("replylists", replylists);
			request.setAttribute("redto", redto);

			url = "/qna/qnaDetail.jsp";
			forward(request, response, url);
			
		
			//답변하기 게시판 이동
		}else if (uri.indexOf("reply.do")!=-1) {
			int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
			String pageNum = request.getParameter("pageNum");
			
			request.setAttribute("qnaNum", qnaNum);
			
			url = "/qna/qnaReply.jsp";
			forward(request, response, url);
			
		}else if (uri.indexOf("reply_ok.do")!=-1){
			//변수 받아서
	int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
		//String pageNum = request.getParameter("pageNum");
			
			ReplyDTO redto = new ReplyDTO();
			int remaxNum = redao.getMaxNum();
			
			redto.setReplyNum(remaxNum+1);
			redto.setQnaNum(Integer.parseInt(request.getParameter("qnaNum")));
			redto.setCustomerId(request.getParameter("customerId"));
			redto.setReplyContent(request.getParameter("replyContent"));
			redto.setReplyCreated(request.getParameter("replyCreated"));
			
			redao.insertData(redto);
			
			url = cp + "/main/qna/list.do";
			response.sendRedirect(url);
		}
	}
}
