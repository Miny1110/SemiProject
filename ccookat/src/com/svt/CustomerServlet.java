package com.svt;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccookat.CustomerDAO;
import com.ccookat.CustomerDTO;
import com.ccookat.CustomerInfo;

import com.util.DBConn;
import com.util.MyPage;


public class CustomerServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void forward(HttpServletRequest req, HttpServletResponse resp, String url) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(url);

		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String cp = req.getContextPath();
		String uri = req.getRequestURI();

		Connection conn = DBConn.getconnection();
		CustomerDAO cdao = new CustomerDAO(conn);

		MyPage myPage = new MyPage();

		String url;
		
		//회원정보 입력
		if(uri.indexOf("created.do")!=-1){

			url = "/customer/signUp.jsp";
			forward(req, resp, url);

		} else if(uri.indexOf("created_ok.do")!=-1) {
					
			CustomerDTO cdto = new CustomerDTO();
			
			cdto.setCustomerId(req.getParameter("customerId"));
			cdto.setCustomerPwd(req.getParameter("customerPwd"));
			cdto.setCustomerName(req.getParameter("customerName"));
			cdto.setCustomerEmail(req.getParameter("customerEmail"));
			cdto.setCustomerTel(req.getParameter("customerTel"));

			cdao.insertData(cdto);
			
			url = "/customer/login.jsp";
			forward(req, resp, url);
			
		}
		//로그인창
		else if(uri.indexOf("login.do")!=-1) {
			
			url = "/customer/login.jsp";
			forward(req, resp, url);

		}else if(uri.indexOf("login_ok.do")!=-1) {
			
			String customerId = req.getParameter("customerId");
			String customerPwd = req.getParameter("customerPwd");
			
			
			CustomerDTO cdto = cdao.getReadData(customerId);
			
			if(cdto==null||!cdto.getCustomerPwd().equals(customerPwd)) {
				
				req.setAttribute("message", "아이디 또는 비밀번호를 정확히 입력하세요.");
				
				url = "/customer/login.jsp";
				forward(req, resp, url);
				return;
			}
			
			
			//로그인 성공
			
			//세션에 올릴 데이터 객체
			CustomerInfo info = new CustomerInfo();
			
			info.setCustomerId(cdto.getCustomerId());
			info.setCustomerName(cdto.getCustomerName());
			
			
			//세션 생성
			HttpSession session = req.getSession();
			
			session.setAttribute("customerInfo", info);
			
			url = cp;
			resp.sendRedirect(url);
			
		}else if(uri.indexOf("logout.do")!=-1) {
			
			HttpSession session = req.getSession();

			session.removeAttribute("customerInfo");
			session.invalidate();
			
			url = cp;
			forward(req, resp, url);
			
		}
		
		//아이디 비번찾기 할지 말지
		
		//회원정보 수정
		
		else if(uri.indexOf("updated.do")!=-1) {
			
			CustomerDTO cdto = new CustomerDTO();
			
			cdto.setCustomerId(req.getParameter("customerId"));
			cdto.setCustomerPwd(req.getParameter("customerPwd"));
			cdto.setCustomerName(req.getParameter("customerName"));
			cdto.setCustomerEmail(req.getParameter("customerEmail"));
			cdto.setCustomerTel(req.getParameter("customerTel"));
			
			cdao.updateData(cdto);
			
			url = "/customer/updated.jsp";
			forward(req, resp, url);
			
		}

}

}
