package com.svt;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
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
import com.ccookat.ItemDAO;
import com.ccookat.ItemDTO;
import com.ccookat.ReviewDTO;
import com.util.DBConn;
import com.util.MyPage;

public class MainServlet extends HttpServlet {

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

		Connection conn = DBConn.getconnection();
		ItemDAO idao = new ItemDAO(conn);
		CartDAO ctdao = new CartDAO(conn);

		String cp = req.getContextPath();
		String uri = req.getRequestURI();
		String url;

		HttpSession session = req.getSession();

		CustomerInfo customerInfo = new CustomerInfo();

		customerInfo = (CustomerInfo)session.getAttribute("customerInfo");

		if(customerInfo!=null) {
		String customerId = customerInfo.getCustomerId();

		int cartCount = ctdao.cartCount(customerId);
		req.setAttribute("cartCount", cartCount);
		}

		List<ItemDTO> mainLists = new ArrayList<ItemDTO>(); 

		mainLists = idao.getHitCountLists();
		String itemImagePath = cp + "/pds/itemImageFile";
		String itemDetailUrl = cp + "/main/item/detail.do?itemType=";

		req.setAttribute("itemDetailUrl", itemDetailUrl);
		req.setAttribute("mainList", mainLists);
		req.setAttribute("itemImagePath", itemImagePath);

		
		url = "/main.jsp";
		forward(req, resp, url);

	}


}
