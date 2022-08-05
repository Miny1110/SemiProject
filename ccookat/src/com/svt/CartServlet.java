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
import com.ccookat.CartDTO;
import com.ccookat.CustomerInfo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.util.DBConn;
import com.util.FileManager;
import com.util.MyPage;

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

		MyPage myPage = new MyPage(); 

		String cp = request.getContextPath();
		String uri = request.getRequestURI();
		String url;


		if(uri.indexOf("list.do")!=-1) {
			
			String itemImagePath = cp + "/pds/itemImageFile";
			
			HttpSession session = request.getSession();
			
			CustomerInfo customerInfo = new CustomerInfo();
			
			session.getAttribute("customerInfo");
			
			String customerId = customerInfo.getCustomerId();
						
			List<CartDTO> lists = ctdao.selectAll(customerId);
			
			if(lists==null) {				
				

				url = "/cart/cartMain.jsp";
				forward(request, response, url);	
				return;
			}
			request.setAttribute("message",	"장바구니에 담긴 상품이 없습니다.");
			request.setAttribute("itemImagePath", itemImagePath);
			request.setAttribute("lists", lists);
					
			url = "/cart/cartMain.jsp";
			forward(request, response, url);	
		}
	}

}
