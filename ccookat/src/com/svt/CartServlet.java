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

import com.ccookat.CartDAO;
import com.ccookat.CartDTO;
import com.ccookat.CustomerInfo;
import com.util.DBConn;

public class CartServlet extends HttpServlet {
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
		CartDAO ctdao = new CartDAO(conn);

		String cp = request.getContextPath();
		String uri = request.getRequestURI();
		String url;


		if(uri.indexOf("list.do")!=-1) {
			
			String itemImagePath = cp + "/pds/itemImageFile";
			
			HttpSession session = request.getSession();
			
			CustomerInfo customerInfo = new CustomerInfo();
			
			customerInfo = (CustomerInfo)session.getAttribute("customerInfo");
			
			String customerId = customerInfo.getCustomerId();
				
			System.out.println(customerId);
			List<CartDTO> lists = ctdao.selectAll(customerId);
			
			if(lists==null) {				
				
				request.setAttribute("message",	"장바구니에 담긴 상품이 없습니다.");				
				url = "/cart/cartMain.jsp";
				forward(request, response, url);	
				return;
			}
			request.setAttribute("itemImagePath", itemImagePath);
			request.setAttribute("lists", lists);
					
			url = "/cart/cartMain.jsp";
			forward(request, response, url);	
		}
	}

}
