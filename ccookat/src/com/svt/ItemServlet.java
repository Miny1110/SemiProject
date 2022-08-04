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
				
				int maxNum = idto.getItemNum();
				
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
			
			url = cp + "/main/item/list.do";
			resp.sendRedirect(url);
			return;
			
		}else if(uri.indexOf("detail.do")!=-1) { //상세페이지 화면 보여주기
			
			//제품번호 가져와
			int itemNum = Integer.parseInt(req.getParameter("itemNum"));
			String currentPage = req.getParameter("pageNum");
			//제품번호 매개로 객체 불러와
			ItemDTO idto = idao.getReadData_detail(itemNum);
			
			//널이면 리스트로 가
			if(idto==null) {
				url = cp + "/main/item/list.do";
				resp.sendRedirect(url);
				return;
			}
			
			//제품설명 텍스트 엔터는 엔터로 변경
			//idto.setItemContent(idto.getItemContent().replaceAll("\n", "<br/>"));
			
			//String params = "pageNum=" + currentPage;
			String imagePath = cp + "/pds/itemImageFile";
			String deletePath = cp + "/main/item/deleted.do";
			
			req.setAttribute("imagePath", imagePath);
			req.setAttribute("idto", idto);
			req.setAttribute("deletePath", deletePath);
			//req.setAttribute("params", params);
			req.setAttribute("currentPage", currentPage);
			
			url = "/item/detail.jsp";
			forward(req, resp, url);
			
		}else if(uri.indexOf("deleted.do")!=-1) {
			
			//num과 pageNum을 받아온다. 리다이렉트 주소를 만들기 위해 필요한 값
			int itemNum = Integer.parseInt(req.getParameter("num"));
			String currentPage = req.getParameter("pageNum");
			
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
			
			
		}else if(uri.indexOf("updated.do")!=-1) {
			
			int itemNum = Integer.parseInt(req.getParameter("itemNum"));
			
			ItemDTO idto = idao.getReadData_detail(itemNum);
			
			
		}else if(uri.indexOf("list.do")!=-1) {
			
	//여기서부터 페이징 처리
			String pageNum = req.getParameter("pageNum");
			
			int currentPage = 1;
			
			if (pageNum != null){
				currentPage = Integer.parseInt(pageNum);
			}
			
			int numPerPage = 9; 
			int dataCount = idao.getDataCount();
			int totalPage = myPage.getPageCount(numPerPage, dataCount);
			
			if(currentPage>totalPage) {
				currentPage = totalPage;
			}
			
			int start = (currentPage-1) * numPerPage +1;
			int end = currentPage * numPerPage;
	//여기까지 페이징 처리
			
			List<ItemDTO> itemMainList = idao.getLists(start, end);
			
			//제품메인 이미지 게시판 가짜주소(페이징 처리에 필요)
			String itemMainUrl = cp + "/main/item/list.do";
			//제품별 상세페이지 가짜주소(페이지번호 들고감)
			String itemDetailUrl = cp + "/main/item/detail.do?pageNum=" + currentPage;
			
			String pageIndexList = myPage.pageIndexList(currentPage, totalPage, itemMainUrl);
			
			//이미지 실제 주소
			String imagePath = cp + "/pds/itemImageFile";
			//삭제 주소
			String deletePath = cp + "/item/deleted.do";

			req.setAttribute("imagePath", imagePath);
			req.setAttribute("itemMainList", itemMainList);
			req.setAttribute("pageIndexList", pageIndexList);
			req.setAttribute("dataCount", dataCount);
			req.setAttribute("currentPage", currentPage);
			req.setAttribute("deletePath", deletePath);
			req.setAttribute("itemDetailUrl", itemDetailUrl);
			
			url = "/item/list.jsp";
			forward(req, resp, url);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
}
