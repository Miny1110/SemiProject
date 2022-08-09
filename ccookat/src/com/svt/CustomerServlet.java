package com.svt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccookat.CustomerDAO;
import com.ccookat.CustomerDTO;
import com.ccookat.CustomerInfo;
import com.ccookat.ReviewDAO;
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
		ReviewDAO rdao = new ReviewDAO(conn);

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
			cdto.setCustomerZipcode(req.getParameter("customerZipcode"));
			cdto.setCustomerAddr1(req.getParameter("customerAddr1"));
			cdto.setCustomerAddr2(req.getParameter("customerAddr2"));

			cdao.insertData(cdto);

			url = "/customer/login.jsp";
			forward(req, resp, url);

		} else if(uri.indexOf("idcheck.do")!=-1) {
			
			String customerId = req.getParameter("customerId");
			String idDuplication = "idUncheck";
			
			int result = cdao.idChk(customerId);
			
			if(result==1) {
				req.setAttribute("msg", "이미 존재하는 아이디입니다.");
				req.setAttribute("idDuplication", idDuplication);
			}else {
				req.setAttribute("msg", "사용 가능한 아이디입니다.");
				req.setAttribute("customerIdChk", customerId);
				idDuplication = "idcheck";
				req.setAttribute("idDuplication", idDuplication);
				
			}
			url = "/customer/signUp.jsp";
			forward(req, resp, url);

		}
		else if(uri.indexOf("login.do")!=-1) {
			//로그인창

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
			CustomerInfo customerInfo = new CustomerInfo();

			customerInfo.setCustomerId(cdto.getCustomerId());
			customerInfo.setCustomerName(cdto.getCustomerName());


			//세션 생성
			HttpSession session = req.getSession();

			session.setAttribute("customerInfo", customerInfo);
			session.setMaxInactiveInterval(60*60); //60분동안 세션 유지

			url = cp+"/main";
			resp.sendRedirect(url);
			return;

		}

		//로그아웃
		else if(uri.indexOf("logout.do")!=-1) {

			HttpSession session = req.getSession();

			session.removeAttribute("customerInfo");
			session.invalidate();

			url = cp+"/main" ;
			resp.sendRedirect(url);
			return;

		}

		//회원정보수정 페이지 들어가기 전 비밀번호 확인
		else if(uri.indexOf("customerPwdChk.do")!=-1) {

			url = "/customer/mypageEnter.jsp";
			forward(req, resp, url);

		}else if(uri.indexOf("customerPwdChk_ok.do")!=-1) {

			HttpSession session = req.getSession();
			CustomerInfo customerInfo = new CustomerInfo();
			customerInfo = (CustomerInfo)session.getAttribute("customerInfo");
			String customerId = customerInfo.getCustomerId();

			String customerPwd = req.getParameter("customerPwd");

			CustomerDTO cdto = cdao.getReadData(customerId);

			if(cdto==null || !cdto.getCustomerPwd().equals(customerPwd)) {
				req.setAttribute("message", "비밀번호가 틀렸습니다.");

				url = "/customer/mypageEnter.jsp";
				forward(req, resp, url);
			}else {
				url = cp + "/main/customer/updated.do";
				resp.sendRedirect(url);
				return;
			}

		}


		//회원정보 수정
		else if(uri.indexOf("updated.do")!=-1) {

			HttpSession session = req.getSession();
			CustomerInfo customerInfo = (CustomerInfo)session.getAttribute("customerInfo");

			CustomerDTO cdto = cdao.getReadData(customerInfo.getCustomerId());

			req.setAttribute("cdto", cdto);

			url = "/customer/updated.jsp";
			forward(req, resp, url);

		}else if(uri.indexOf("updated_ok.do")!=-1) {

			CustomerDTO cdto = new CustomerDTO();

			cdto.setCustomerId(req.getParameter("customerId"));
			cdto.setCustomerPwd(req.getParameter("customerPwd"));
			cdto.setCustomerName(req.getParameter("customerName"));
			cdto.setCustomerEmail(req.getParameter("customerEmail"));
			cdto.setCustomerTel(req.getParameter("customerTel"));
			cdto.setCustomerZipcode(req.getParameter("customerZipcode"));
			cdto.setCustomerAddr1(req.getParameter("customerAddr1"));
			cdto.setCustomerAddr2(req.getParameter("customerAddr2"));

			cdao.updateData(cdto);

			url = cp + "/main";
			resp.sendRedirect(url);
			return;

		}
		//아이디 찾기
		else if(uri.indexOf("searchId.do")!=-1) {

			url = "/customer/searchId.jsp";
			forward(req, resp, url);

		}else if(uri.indexOf("searchId_ok.do")!=-1) {

			String customerName = req.getParameter("customerName");
			String customerTel = req.getParameter("customerTel");

			CustomerDTO cdto =cdao.getReadData(customerName, customerTel);

			if(cdto==null||!cdto.getCustomerTel().equals(customerTel)) {
				req.setAttribute("message", "회원정보가 존재하지 않습니다.");

				url = "/customer/searchId.jsp";
				forward(req, resp, url);

			} else {
				String customerId = cdto.getCustomerId();
				req.setAttribute("message", "아이디는["+ customerId + "]입니다");


				url = "/customer/searchId.jsp";
				forward(req, resp, url);


			}
			//비밀번호 찾기
		}else if(uri.indexOf("searchPwd.do")!=-1) {

			url = "/customer/searchPwd.jsp";
			forward(req, resp, url);



		}else if(uri.indexOf("searchPwd_ok.do")!=-1) {
			String customerId = req.getParameter("customerId");
			String customerTel = req.getParameter("customerTel");

			CustomerDTO cdto =cdao.getReadData(customerId);

			if(cdto==null||!cdto.getCustomerTel().equals(customerTel)) {
				req.setAttribute("message", "회원정보가 존재하지 않습니다.");

				url = "/customer/searchPwd.jsp";
				forward(req, resp, url);
			} else {
				String coustomerPwd = cdto.getCustomerPwd();
				req.setAttribute("message", "비밀번호는["+ coustomerPwd + "]입니다");

				url = "/customer/searchPwd.jsp";
				forward(req, resp, url);

			}
		}

		//회원탈퇴
		else if(uri.indexOf("deleted_ok.do")!=-1) {

			HttpSession session = req.getSession();
			CustomerInfo customerInfo = (CustomerInfo)session.getAttribute("customerInfo");
			String customerId = customerInfo.getCustomerId();
			System.out.println(customerId);

			//회원 탈퇴 하려면 자식클래스에 있는 데이터 먼저 삭제해야 된다고 함. 안그러면 에러 뜸. 보니까 리뷰테이블 데이터 삭제하고 하면 될거같은데 이따 같이 봐야지
			//rdao.deleteData(reviewNum)
			rdao.deleteData(customerId);
			cdao.deleteData(customerId);
			session.removeAttribute("customerId"); //데이터만 삭제
			session.invalidate(); //customerId 변수도 삭제

			url = cp + "/main";
			resp.sendRedirect(url);
			return;

		}
		
		

			
		
		
		
	}
}




