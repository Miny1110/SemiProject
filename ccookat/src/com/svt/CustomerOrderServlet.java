package com.svt;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.INTERNAL;

import com.ccookat.CartDAO;
import com.ccookat.CartDTO;
import com.ccookat.CustomerDAO;
import com.ccookat.CustomerDTO;
import com.ccookat.CustomerInfo;
import com.ccookat.CustomerOrderDAO;
import com.ccookat.CustomerOrderDTO;
import com.util.DBConn;

public class CustomerOrderServlet extends HttpServlet {
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
		CustomerDAO cdao = new CustomerDAO(conn);
		CartDAO ctdao = new CartDAO(conn);
		CustomerOrderDAO ordao = new CustomerOrderDAO(conn);
		CustomerDTO cdto = new CustomerDTO();
		CartDTO ctdto = new CartDTO();
		CustomerOrderDTO ordto = new CustomerOrderDTO();

		String cp = request.getContextPath();
		String uri = request.getRequestURI();
		String url;
		if(uri.indexOf("order.do")!=-1) {
			String itemImagePath = cp + "/pds/itemImageFile";
			HttpSession session = request.getSession();

			CustomerInfo customerInfo = new CustomerInfo();
			
			customerInfo = (CustomerInfo)session.getAttribute("customerInfo");
			
			if(customerInfo!=null) {

				String customerId = customerInfo.getCustomerId();

				List<CartDTO> lists = ctdao.selectAll(customerId);

				int cartCount = ctdao.cartCount(customerId);
				
				//주문하기 갈때 가지고 갈것들
				int itemNum = Integer.parseInt(request.getParameter("itemNum"));
				int cartNum = Integer.parseInt(request.getParameter("cartNum"));

					request.setAttribute("ctdto", ctdto);//장바구니상품 끌어올 데이터
					request.setAttribute("cdto", cdto);//회원정보 깔아줄 데이터
					request.setAttribute("itemImagePath", itemImagePath);//장바구니에서 이미지 끌어올 데이터
					request.setAttribute("lists", lists);
					request.setAttribute("cartCount", cartCount);
					request.setAttribute("itemnum", itemNum);
					request.setAttribute("cartNum", cartNum);
						
					

				url = "/order/orderlist.jsp";
				forward(request, response, url);	
				
				
			}else if(uri.indexOf("order_ok.do")!=-1) {
				
			//주문하기 누르면 실행되어야할것
			//1. 장바구니에서 상품 delete하기
			//2. 주문정보 테이블에 저장
			//3. 주문정보 테이블과 연결해서 주문상품 리스트 저장 
				

				
			}
		}

	}}