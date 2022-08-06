package com.svt;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


		String cp = req.getContextPath();
		//String uri = req.getRequestURI();
		String url;


		String itemImagePath = cp + "/pds/itemImageFile";

		List<ItemDTO> mainList = idao.getHitCountLists();

		req.setAttribute("itemImagePath", itemImagePath);
		req.setAttribute("mainList", mainList);

		url = cp ;
		forward(req, resp, url);
		
	}


}
