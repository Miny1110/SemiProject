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
		String uri = req.getRequestURI();
		String url;
		
		if(uri.indexOf("list.do")!=-1) {

			String itemType = req.getParameter("itemType");
			System.out.println(itemType);
		
			if(itemType==null) {
				System.out.println("여긴 데이터 없다는거");
				List<ItemDTO> mainLists = new ArrayList<ItemDTO>(); 
				
				mainLists = idao.getHitCountLists();
				req.setAttribute("mainList", mainLists);
				url = cp +"/main/main.jsp";
				forward(req, resp, url);
				return;
			}
			
			System.out.println("여긴 데이터 있다는거");
			List<ItemDTO> mainLists = new ArrayList<ItemDTO>(); 
			mainLists = idao.getHitCountLists(itemType);
			
			String itemImagePath = cp + "/pds/itemImageFile";
			List<ItemDTO> mainList = idao.getHitCountLists(itemType);

			req.setAttribute("itemImagePath", itemImagePath);
			req.setAttribute("mainList", mainList);

			url = cp ;
			forward(req, resp, url);
			

			
		}
		

	}


}
