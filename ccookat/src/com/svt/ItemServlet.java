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

public class ItemServlet extends HttpServlet {

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
		
		//이미지 파일 첨부를 위한 설정
		String root = getServletContext().getRealPath("/");
		String path = root + "pds" + File.separator + "itemImageFile";
		
		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}
		

		
		if(uri.indexOf("created.do")!=-1) {
			
			url = "/item/created.jsp";
			forward(req, resp, url);
			
		}else if(uri.indexOf("created_ok.do")!=-1) { //글작성에서 입력한 데이터 DB에 넣기
													//제품번호,제품명,가격,할인,카테고리,내용,사진4개,재고량
													//나머지는 사용자가 입력
			
			
			String encType = "utf-8";
			int maxSize = 10*1024*1024;
			
			MultipartRequest mr = new MultipartRequest(req, path, maxSize, encType, 
					new DefaultFileRenamePolicy());
			
			if(mr.getFile("itemImage1")!=null && mr.getFile("itemImage2")!=null && 
					mr.getFile("itemImage3")!=null && mr.getFile("itemImage4")!=null) {
				
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
			
			url = cp + "/main/item/detail.do";
			resp.sendRedirect(url);
			
		}else if(uri.indexOf("detail.do")!=-1) { //상세페이지 화면 보여주기
			
			List<ItemDTO> lists = idao.getLists();
					
			String listUrl = cp + "/main/item/list.do";
			
			String imagePath = cp + "/pds/imageFile";
			String deletePath = cp + "/image/deleted.do";
			
			req.setAttribute("imagePath", imagePath);
			req.setAttribute("lists", lists);
			req.setAttribute("deletePath", deletePath);
			
			url = "/item/detail.jsp";
			forward(req, resp, url);
			
		}else if(uri.indexOf("deleted.do")!=-1) {
			
			int itemNum = Integer.parseInt(req.getParameter("itemNum"));
			
			ItemDTO idto = idao.getReadData(itemNum);
			
			//이미지 파일 삭제
			FileManager.doFileDelete(idto.getItemImage1(), path);
			FileManager.doFileDelete(idto.getItemImage2(), path);
			FileManager.doFileDelete(idto.getItemImage3(), path);
			FileManager.doFileDelete(idto.getItemImage4(), path);
			
			//이미지 DB 파일정보 삭제
			idao.deleteData(itemNum);
			
			url = cp + "/item/list.do";
			
			
		}else if(uri.indexOf("list.do")!=-1) {
			
			System.out.println("굿");
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
}
