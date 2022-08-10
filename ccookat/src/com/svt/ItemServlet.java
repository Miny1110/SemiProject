package com.svt;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccookat.CartDAO;
import com.ccookat.CustomerInfo;
import com.ccookat.ItemDAO;
import com.ccookat.ItemDTO;
import com.ccookat.ReviewDAO;
import com.ccookat.ReviewDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.util.DBConn;
import com.util.FileManager;
import com.util.MyPage;

public class ItemServlet extends HttpServlet {

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
		ReviewDAO rdao = new ReviewDAO(conn);
		MyPage myPage = new MyPage();
		CartDAO ctdao = new CartDAO(conn);
		
		String cp = req.getContextPath();
		String uri = req.getRequestURI();
		String url;

		//이미지 파일 첨부를 위한 설정
		String root = getServletContext().getRealPath("/");
		String path = root + "pds" + File.separator + "itemImageFile";
		//String path = "C:\\Users\\정민정\\Desktop\\itemImage";

		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}



		if(uri.indexOf("created.do")!=-1) {

			url = "/item/created.jsp";
			forward(req, resp, url);

		}else if(uri.indexOf("created_ok.do")!=-1) { //글작성에서 입력한 데이터 DB에 넣기

			String encType = "utf-8";
			int maxSize = 10*1024*1024;

			MultipartRequest mr = new MultipartRequest(req, path, maxSize, encType, 
					new DefaultFileRenamePolicy());

			if(mr.getFile("itemImage1")!=null && mr.getFile("itemImage2")!=null
					&& mr.getFile("itemImage3")!=null && mr.getFile("itemImage4")!=null ) {

				ItemDTO idto = new ItemDTO();
				

				int maxNum = idao.getMaxNum();

				idto.setItemNum(maxNum+1);
				idto.setItemName(mr.getParameter("itemName"));
				idto.setItemPrice(Integer.parseInt(mr.getParameter("itemPrice")));
				idto.setItemDiscount(Integer.parseInt(mr.getParameter("itemDiscount")));
				idto.setItemType(mr.getParameter("itemType"));
				idto.setItemContent(mr.getParameter("itemContent"));
				idto.setItemImage1(mr.getFilesystemName("itemImage1"));
				idto.setItemImage2(mr.getFilesystemName("itemImage2"));
				idto.setItemImage3(mr.getFilesystemName("itemImage3"));
				idto.setItemImage4(mr.getFilesystemName("itemImage4"));
				idto.setItemStock(Integer.parseInt(mr.getParameter("itemStock")));

				idao.insertData(idto);

			}

			url = cp + "/main/item/list.do" ;
			resp.sendRedirect(url);
			return;

		}else if(uri.indexOf("detail.do")!=-1) { //상세페이지 화면 보여주기
			
			//제품번호 가져와
			int itemNum = Integer.parseInt(req.getParameter("itemNum"));
			
			//페이지번호 가져와
			String currentPage = req.getParameter("pageNum");

			//아이템타입 가져와
			String itemType = req.getParameter("itemType");
			
			//제품번호 매개로 조회수  업데이트
			idao.updateHitCount(itemNum);

			//제품번호 매개로 객체 불러와
			ItemDTO idto = idao.getReadData_detail(itemNum);
			
			List<ItemDTO> itemHitCountList;

			if(itemType==null) {
				itemHitCountList = idao.getHitCountLists();
			}else {
				itemHitCountList = idao.getHitCountLists(itemType);
			}


			//널이면 리스트로 가
			if(idto==null) {
				url = cp + "/main/item/list.do";
				resp.sendRedirect(url);
				return;
			}


			/*int currentPage = 1;
			if(pageNum!=null) {
				currentPage = Integer.parseInt(pageNum);
			}*/


			//하나의 페이지에 보일 페이지 갯수
			int reviewtotalArticle = rdao.getDataCount(itemNum);
			/*int numPerPage = 30;
			int totalPage = myPage.getPageCount(numPerPage, reviewtotalArticle);
			
			
			//삭제시 페이지수가 줄었을때 처리하는 방법 
			if (currentPage > totalPage) {
				currentPage = totalPage;
			}

			//데이터베이스에서 가져올 rownum의 시작과 끝 구하기
			int start = (currentPage-1)*numPerPage+1;
			int end = currentPage*numPerPage; 

			start = (currentPage-1) * numPerPage + 1;
			end = currentPage * numPerPage;

			String listUrl = cp + "/item/detail.do";
			String reviewPageIndexList = myPage.pageIndexList(currentPage, totalPage, listUrl);*/
			
			//리스트 나오게 하기
			List<ReviewDTO> reviewlists = rdao.getLists(itemNum);

			/* 이부분 변수명 정리함 */
			String reviewdDeletePath = cp + "/main/review/delete.do";
			String reviewImagePath = cp + "/pds/imageFile";			
			//String params = "pageNum=" + currentPage;
			String itemImagePath = cp + "/pds/itemImageFile";
			String itemDeletePath = cp + "/main/item/deleted.do";
			

			//제품설명 텍스트 엔터는 엔터로 변경
			idto.setItemContent(idto.getItemContent().replaceAll("\n", "<br/>"));

			HttpSession session = req.getSession();

			CustomerInfo customerInfo = new CustomerInfo();
			customerInfo = (CustomerInfo)session.getAttribute("customerInfo");

			if(customerInfo!=null) {
			String customerId = customerInfo.getCustomerId();

			int cartCount = ctdao.cartCount(customerId);
			req.setAttribute("cartCount", cartCount);
			}
						
			req.setAttribute("currentPage", currentPage);
			req.setAttribute("itemImagePath", itemImagePath);
			req.setAttribute("itemDeletePath", itemDeletePath);
			req.setAttribute("reviewImagePath", reviewImagePath);
			req.setAttribute("reviewdDeletePath", reviewdDeletePath);
			req.setAttribute("reviewlists", reviewlists);
			req.setAttribute("idto", idto);
			//req.setAttribute("reviewPageIndexList", reviewPageIndexList);
			req.setAttribute("reviewtotalArticle", reviewtotalArticle);

			req.setAttribute("itemHitCountList", itemHitCountList);

			//req.setAttribute("params", params);


			url = "/item/detail.jsp";
			

			forward(req, resp, url);

		}else if(uri.indexOf("deleted.do")!=-1) {

			//num과 pageNum을 받아온다. 리다이렉트 주소를 만들기 위해 필요한 값
			int itemNum = Integer.parseInt(req.getParameter("itemNum"));
			int currentPage = 0;
			System.out.println(itemNum);
			
			String itemType = req.getParameter("itemType");

			//삭제하려는 데이터의 num을 사용해서 그 하나의 데이터 정보를 읽어온다
			ItemDTO idto = idao.getReadData_detail(itemNum);

			//그 데이터의 파일저장명과 동일한 데이터를 삭제한다. (물리적 데이터 삭제)
			FileManager.doFileDelete(idto.getItemImage1(), path);
			FileManager.doFileDelete(idto.getItemImage2(), path);
			FileManager.doFileDelete(idto.getItemImage3(), path);
			FileManager.doFileDelete(idto.getItemImage4(), path);

			//DB 테이블에 저장된 데이터 삭제
			rdao.deleteDataItem(itemNum);
			idao.deleteData(itemNum);
			
			if(currentPage==0) {
				url = cp + "/main/item/list.do";
				resp.sendRedirect(url);}
			else {
				currentPage = Integer.parseInt(req.getParameter("pageNum"));
				url = cp + "/main/item/list.do?itemType="+itemType +"&pageNum="+currentPage;
				resp.sendRedirect(url);
			}
			
			

		}else if(uri.indexOf("list.do")!=-1) {
			
			String itemType = req.getParameter("itemType");
			int dataCount;
	
			//페이지넘 받아온다.
			String pageNum = req.getParameter("pageNum");
			
			
			//현재페이지 디폴트값 1. 페이지넘이 널이면 1을 넣는다.
			int currentPage = 1;
			if (pageNum != null){
				currentPage = Integer.parseInt(pageNum);
			}
			
			//검색값 받아온다.
			//검색값 있으면 utr-8로, 없으면 그냥 널
			String itemSearchValue = req.getParameter("itemSearchValue");
			
			if(itemSearchValue!=null) {
				if(req.getMethod().equalsIgnoreCase("GET")) {
					itemSearchValue = URLDecoder.decode(itemSearchValue,"UTF-8");
				}
			}else {
				itemSearchValue = "";
			}
			
			
			
			//데이터 개수 가져온다.
			//검색값이 있으면 itemName에 검색값이 포함된 데이터를
			//검색값이 없으면 모든 데이터를
			if(itemType==null) {
				dataCount = idao.getDataCount(itemSearchValue) ;
			}else {
				dataCount = idao.getDataCount(itemType, itemSearchValue);
			}
			
			//한 페이지에 나올 데이터는 6개
			int numPerPage = 9; 
			int totalPage = myPage.getPageCount(numPerPage, dataCount);
			if(currentPage>totalPage) {
				currentPage = totalPage;
			}
			
			int start = (currentPage-1) * numPerPage +1;
			int end = currentPage * numPerPage;
			
			//전체 데이터 (검색값이 있으면 검색어가 포함된 전체 데이터) 불러온다.
			List<ItemDTO> lists;
			
			if(itemType==null) {
				lists = idao.getLists(start, end, itemSearchValue);
			}else {
				lists = idao.getLists(start, end, itemSearchValue, itemType);
			}
			
			
			String params = "";
	
			if(itemType==null || itemType.equals("")) {
				if(itemSearchValue!=null || !itemSearchValue.equals("")) {
					params = "?itemSearchValue=" + URLEncoder.encode(itemSearchValue, "UTF-8");
				}
			}else {
				if(itemSearchValue!=null || !itemSearchValue.equals("")) {
					params = "?itemType=" + itemType + "&itemSearchValue=" + URLEncoder.encode(itemSearchValue, "UTF-8");
				}
			}
			
			String listUrl = cp + "/main/item/list.do" + params;
			
			if(params.equals("")) {
				listUrl += "?" + params;
			}
			
			String pageIndexList = myPage.pageIndexList(currentPage, totalPage, listUrl);
			
			//이미지 실제 주소
			String itemImagePath = cp + "/pds/itemImageFile";
			//삭제 주소
			String itemDeletePath = cp + "/item/deleted.do";
			String itemDetailUrl;
			
			if(itemType==null || itemType.equals("")) {
				itemDetailUrl = cp + "/main/item/detail.do?pageNum=" + currentPage;
			}else {
				itemDetailUrl = cp + "/main/item/detail.do?pageNum=" + currentPage + "&itemType=" + itemType;
			}
			
			
			//카트 받아올때 필요한듯?
			HttpSession session = req.getSession();
			
			CustomerInfo customerInfo = new CustomerInfo();

			customerInfo = (CustomerInfo)session.getAttribute("customerInfo");

			if(customerInfo!=null) {
				String customerId = customerInfo.getCustomerId();
	
				int cartCount = ctdao.cartCount(customerId);
				req.setAttribute("cartCount", cartCount);
			}
	
			
			req.setAttribute("itemType", itemType);
			req.setAttribute("itemDetailUrl", itemDetailUrl);
			req.setAttribute("itemDeletePath", itemDeletePath);
			req.setAttribute("itemImagePath", itemImagePath);
			req.setAttribute("lists", lists);
			req.setAttribute("pageIndexList", pageIndexList);
			req.setAttribute("totalPage", totalPage);
			req.setAttribute("currentPage", currentPage);
			req.setAttribute("dataCount", dataCount);


			
			List<ItemDTO> itemHitCountList;
			
			if(itemType==null) {
				itemHitCountList = idao.getHitCountLists();
			}else {
				itemHitCountList = idao.getHitCountLists(itemType);
			}

			req.setAttribute("itemHitCountList", itemHitCountList);

			url = "/item/list.jsp";
			forward(req, resp, url);

		}	
		

	}


}
