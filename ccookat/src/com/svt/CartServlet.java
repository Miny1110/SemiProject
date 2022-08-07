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

		}else if(uri.indexOf("cartin.do")!=-1) {

			//아이템 넘버랑, 데이터 카운트랑, 세션에 올라가 있는 아이디 받아서 
			//카트에 인서트 시켜야함
			HttpSession session = request.getSession();

			CustomerInfo customerInfo = new CustomerInfo();

			customerInfo = (CustomerInfo)session.getAttribute("customerInfo");

			if(customerInfo!=null) {
			String customerId = customerInfo.getCustomerId();

			CartDTO ctdto = new CartDTO();

			int maxnum = ctdao.getMaxNum();

			ctdto.setCartNum(maxnum+1);
			ctdto.setCustomerId(customerId);
			int itemNum = Integer.parseInt(request.getParameter("itemNum"));
			ctdto.setItemNum(itemNum);
			String str = request.getParameter("itemPrice");
			int indexNum = str.indexOf(".");
			int itemPrice =  Integer.parseInt(str.substring(0 , indexNum));
			 (request.getParameter("itemPrice")).split(".");

			int cartItemCount = Integer.parseInt(request.getParameter("cartItemCount"));
			ctdto.setCartItemCount(cartItemCount);
			ctdto.setCartTotPrice(itemPrice*cartItemCount);

			ctdao.insertData(ctdto);


			//장바구니에 넣고 원래있던 상세페이지 출력
			url = cp +"/main/item/detail.do?itemNum="+itemNum;
			response.sendRedirect(url);
			return;
			}
			
			url = cp +"/main/customer/login.do";
			response.sendRedirect(url);

		}
		
		
	}
}
