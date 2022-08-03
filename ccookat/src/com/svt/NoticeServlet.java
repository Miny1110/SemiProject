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

import com.ccookat.NoticeDAO;
import com.ccookat.NoticeDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.util.DBConn;
import com.util.FileManager;
import com.util.MyPage;

@WebServlet("/NoticeServlet")
public class NoticeServlet extends HttpServlet {
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
		NoticeDAO ndao = new NoticeDAO(conn);

		MyPage myPage = new MyPage(); 

		String cp = request.getContextPath();
		String uri = request.getRequestURI();
		String url;

		String root = getServletContext().getRealPath("/");
		String path = root + "pds" + File.separator + "noticeFile";
		// 이미지 저장 경로는 최상위pds파일에 각자 파일만들어서 저장하는걸로

		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}

		if(uri.indexOf("list.do")!=-1) {
			
			String pageNum = request.getParameter("pageNum");
			
			int currentPage = 1;

			if(pageNum!=null) {
				currentPage = Integer.parseInt(pageNum);
			}

			int dataCount = ndao.getDataCount();

			int numPerPage = 4;

			int totalPage = myPage.getPageCount(numPerPage, dataCount);

			if(currentPage>totalPage) {
				currentPage=totalPage;
				url = "/notice/noticeMain.jsp?pageNum="+currentPage;	
			}

			int start = (currentPage-1)*numPerPage+1;
			int end = currentPage * numPerPage;

			List<NoticeDTO> lists = ndao.selectAll(start, end);
			
			String listUrl = cp + "/main/notice/list.do";
			
			String pageIndexList = myPage.pageIndexList(currentPage, totalPage, listUrl);

			String deletePath = cp + "main/notice/delete.do";
			String imagePath = cp + "/pds/noticeFile";
								
			request.setAttribute("deletePath", deletePath);
			request.setAttribute("imagePath", imagePath);
			request.setAttribute("lists", lists);
			request.setAttribute("pageIndexList", pageIndexList);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("dataCount", dataCount);
			
			url = "/notice/noticeMain.jsp";
			forward(request, response, url);

		}else if(uri.indexOf("upload.do")!=-1) {

			url = "/notice/noticeUpload.jsp";
			forward(request, response, url);

		}else if(uri.indexOf("upload_ok.do")!=-1) {

			String encType = "UTF-8";
			int maxSize = 10*1054*1024;

			MultipartRequest mr = 
					new MultipartRequest(request, path,maxSize,encType,
							new DefaultFileRenamePolicy());


			if(mr.getFile("upload")!=null) {

				NoticeDTO dto = new NoticeDTO();

				int maxnum = ndao.getMaxNum();
				
				dto.setNoticeNum(maxnum+1);
				dto.setNoticeTitle(mr.getParameter("noticeTitle"));
				dto.setNoticeImage(mr.getFilesystemName("upload"));
				dto.setNoticeContent(mr.getParameter("noticeContent"));
	
				ndao.insertData(dto);
			}

			url = cp + "/main/notice/list.do";
			response.sendRedirect(url);

		}else if(uri.indexOf("detail.do")!=-1) {

			int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));
			String pageNum = request.getParameter("pageNum");

			String imagePath = cp + "/pds/noticeFile";
			ndao.updateHitCount(noticeNum);
			
			NoticeDTO ndto = ndao.selectData(noticeNum);
			
			
			if(ndto==null) {
				url = cp + "/main/notice/list.do";
				response.sendRedirect(url);
			}
			
			
			//int line = ndto.getNoticeContent().split("\n").length;

			//ndto.setNoticeContent(ndto.getNoticeContent().replaceAll("\n\r", "<br/>"));


			request.setAttribute("ndto", ndto);
			//request.setAttribute("lineSu", line);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("imagePath", imagePath);
			
			url = "/notice/noticeDetail.jsp";
			forward(request, response, url);
			
		}else if(uri.indexOf("delete.do")!=-1) {
			
			int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));
			String pageNum = request.getParameter("pageNum");
			
			NoticeDTO ndto = ndao.selectData(noticeNum);
			
			//파일에있는 이미지데이터 삭제
			FileManager.doFileDelete(ndto.getNoticeImage(), path);
			//DB데이터 삭제
			ndao.deleteData(noticeNum);
			
			url = cp + "/main/notice/list.do?pageNum=" + pageNum;
			response.sendRedirect(url);
		}

	}

}
