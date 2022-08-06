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
		
		String itemType = req.getParameter("itemType");

		String itemImagePath = cp + "/pds/itemImageFile";
		System.out.println("dkdk");
		List<ItemDTO> mainList = idao.getHitCountLists(itemType);

		req.setAttribute("itemImagePath", itemImagePath);
		req.setAttribute("mainList", mainList);

		url = cp ;
		forward(req, resp, url);
		//System.out.println(cp);


		/*	List<ItemDTO> itemMainList = idao.getitemHitCount();

			//제품메인 이미지 게시판 가짜주소(페이징 처리에 필요)
			String itemMainUrl = cp + "/main/item/list.do?itemType=" + itemType;
			//제품별 상세페이지 가짜주소(페이지번호 들고감)
			String itemDetailUrl = cp + "/main/item/detail.do?itemType=" + itemType + "&pageNum=" + currentPage;

			String pageIndexList = MyPage.

			//이미지 실제 주소
			String imagepath = cp + "/pds/itemImageFile";
			//삭제 주소
			String deletePath = cp + "/item/deleted.do";

			req.setAttribute("imagePath", imagePath);
			req.setAttribute("itemMainList", itemMainList);
			req.setAttribute("pageIndexList", pageIndexList);
			req.setAttribute("dataCount", dataCount);
			req.setAttribute("deletePath", deletePath);
			req.setAttribute("itemDetailUrl", itemDetailUrl);

			url = "/item/list.jsp";
			forward(req, resp, url);
		 */


	}


}
