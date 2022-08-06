package com.svt;

import java.io.File;
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

			url = cp + "/main" ;
			resp.sendRedirect(url);
			return;

		}else if(uri.indexOf("detail.do")!=-1) { //상세페이지 화면 보여주기

			//제품번호 가져와
			int itemNum = Integer.parseInt(req.getParameter("itemNum"));

			//페이지번호 가져와
			String pageNum = req.getParameter("pageNum");

			//제품번호 매개로 조회수  업데이트
			idao.updateHitCount(itemNum);

			//제품번호 매개로 객체 불러와
			ItemDTO idto = idao.getReadData_detail(itemNum);

			//널이면 리스트로 가
			if(idto==null) {
				url = cp + "/item/list.do";
				resp.sendRedirect(url);
				return;
			}


			int currentPage = 1;
			if(pageNum!=null) {
				currentPage = Integer.parseInt(pageNum);
			}

			//처음 전체 데이터 갯수 구하기
			//int dataCount = idao.getDataCount(itemType);
			//하나의 페이지에 보일 페이지 갯수
			int reviewtotalArticle = rdao.getDataCount();				
			int numPerPage = 5;
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
			String pageIndexList = myPage.pageIndexList(currentPage, totalPage, listUrl);
			//리스트 나오게 하기
			List<ReviewDTO> reviewlists = rdao.getLists(start, end, itemNum);

			/* 이부분 변수명 정리함 */
			String reviewdDeletePath = cp + "/main/review/delete.do";
			String reviewImagePath = cp + "/pds/imageFile";			
			//String params = "pageNum=" + currentPage;
			String itemImagePath = cp + "/pds/itemImageFile";
			String itemDeletePath = cp + "/main/item/deleted.do";
			
			

			//제품설명 텍스트 엔터는 엔터로 변경
			idto.setItemContent(idto.getItemContent().replaceAll("\n", "<br/>"));

			req.setAttribute("currentPage", currentPage);

			req.setAttribute("itemNum", itemNum);
			req.setAttribute("itemImagePath", itemImagePath);
			req.setAttribute("itemDeletePath", itemDeletePath);
			req.setAttribute("reviewImagePath", reviewImagePath);
			req.setAttribute("reviewdDeletePath", reviewdDeletePath);
			req.setAttribute("pageIndexList", pageIndexList);
			req.setAttribute("idto", idto);
			req.setAttribute("reviewlists", reviewlists);

			//req.setAttribute("params", params);


			url = "/item/detail.jsp";

			forward(req, resp, url);

		}else if(uri.indexOf("deleted.do")!=-1) {

			//num과 pageNum을 받아온다. 리다이렉트 주소를 만들기 위해 필요한 값
			int itemNum = Integer.parseInt(req.getParameter("itemNum"));
			System.out.println(itemNum);
			int currentPage = Integer.parseInt(req.getParameter("pageNum"));
			System.out.println(currentPage);
			

			//삭제하려는 데이터의 num을 사용해서 그 하나의 데이터 정보를 읽어온다
			ItemDTO idto = idao.getReadData_detail(itemNum);

			//그 데이터의 파일저장명과 동일한 데이터를 삭제한다. (물리적 데이터 삭제)
			FileManager.doFileDelete(idto.getItemImage1(), path);
			FileManager.doFileDelete(idto.getItemImage2(), path);
			FileManager.doFileDelete(idto.getItemImage3(), path);
			FileManager.doFileDelete(idto.getItemImage4(), path);

			//DB 테이블에 저장된 데이터 삭제
			idao.deleteData(itemNum);

			url = cp + "/main/item/list.do?pageNum=" + currentPage;
			resp.sendRedirect(url);

			return;


		}/*else if(uri.indexOf("updated.do")!=-1) {

			int itemNum = Integer.parseInt(req.getParameter("itemNum"));

			ItemDTO idto = idao.getReadData_detail(itemNum);


		}*/else if(uri.indexOf("list.do")!=-1) {

			//여기서부터 페이징 처리
			String pageNum = req.getParameter("pageNum");
			String itemType = req.getParameter("itemType");
			if(itemType==null) {
				itemType = "fruit";
			}

			int currentPage = 1;

			if (pageNum != null){
				currentPage = Integer.parseInt(pageNum);
			}

			int numPerPage = 6; 
			int dataCount = idao.getDataCount(itemType);
			int totalPage = myPage.getPageCount(numPerPage, dataCount);

			if(currentPage>totalPage) {
				currentPage = totalPage;
			}

			int start = (currentPage-1) * numPerPage +1;
			int end = currentPage * numPerPage;
			//여기까지 페이징 처리


			//카테고리별 이미지 게시판 전체 상품 출력 시작		
			List<ItemDTO> itemMainList = idao.getLists(itemType, start, end);

			//제품메인 이미지 게시판 가짜주소(페이징 처리에 필요)
			String itemMainUrl = cp + "/main/item/list.do?itemType=" + itemType;
			//제품별 상세페이지 가짜주소(페이지번호 들고감)
			String itemDetailUrl = cp + "/main/item/detail.do?itemType=" + itemType;
			
			String pageUrl = cp+"/main/item/detail.do";

			String pageIndexList = myPage.pageIndexList(currentPage, totalPage, itemMainUrl);
			String reviewPageIndexList = myPage.pageIndexList(currentPage, totalPage, pageUrl);
			

			//이미지 실제 주소
			String itemImagePath = cp + "/pds/itemImageFile";
			//삭제 주소
			String itemDeletePath = cp + "/item/deleted.do";

			req.setAttribute("itemImagePath", itemImagePath);
			req.setAttribute("itemMainList", itemMainList);
			req.setAttribute("pageIndexList", pageIndexList);
			req.setAttribute("dataCount", dataCount);
			req.setAttribute("currentPage", currentPage);
			req.setAttribute("itemDeletePath", itemDeletePath);
			req.setAttribute("itemDetailUrl", itemDetailUrl);
			req.setAttribute("reviewPageIndexList", reviewPageIndexList);
			//카테고리별 이미지 게시판 전체 상품 출력 끝

			List<ItemDTO> itemHitCountList = idao.getHitCountLists(itemType);

			req.setAttribute("itemHitCountList", itemHitCountList);

			url = "/item/list.jsp";
			forward(req, resp, url);

		}	
		
		/*else if(uri.indexOf("cart/list.do")!=-1){
			
			int itemNum = Integer.parseInt(req.getParameter("itemNum"));
			
			ItemDTO idto = idao.getReadData_Customer(itemNum);
			
			req.setAttribute("idto", idto);
			
			url = "/cart/cartMain.jsp";
			forward(req, resp, url);
			
		}*/

















	}





}
