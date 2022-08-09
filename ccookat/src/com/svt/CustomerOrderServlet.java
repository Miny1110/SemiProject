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
		CartDTO ctdto = new CartDTO();
		CustomerDTO cdto = new CustomerDTO();
		

		String cp = request.getContextPath();
		String uri = request.getRequestURI();
		String url;
		if(uri.indexOf("order.do")!=-1) {
			String itemImagePath = cp + "/pds/itemImageFile";
			HttpSession session = request.getSession();

			CustomerInfo customerInfo = new CustomerInfo();
			
			customerInfo = (CustomerInfo)session.getAttribute("customerInfo");
			//카트 창 참조
			if(customerInfo!=null) {

				String customerId = customerInfo.getCustomerId();

				List<CartDTO> lists = ctdao.selectAll(customerId);

				int cartCount = ctdao.cartCount(customerId);

					request.setAttribute("ctdto", ctdto);
					request.setAttribute("cdto", cdto);
					request.setAttribute("itemImagePath", itemImagePath);
					request.setAttribute("lists", lists);
					request.setAttribute("cartCount", cartCount);
					request.setAttribute("message",	"장바구니에 담긴 상품이 없습니다.");		

				url = "/order/orderlist.jsp";
				forward(request, response, url);	
				
			}
		}

	}}