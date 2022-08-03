package com.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.nio.Buffer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

public class FileManager {

	// 파일 다운로드
	public static boolean doFileDownload(HttpServletResponse response,
	String saveFileName,String originalFileName,String path) {//이게 필수로 필요행
		
		try {
			String fullPath = path + File.separator + saveFileName; // 이 path는 saveFile 까지의 위치
		if(originalFileName==null|| originalFileName.equals("")) {
			
			originalFileName=saveFileName; 
		}//혹시나해서 하는 검증작업
		
		//한글파일 이름 깨짐 방지 필수!!
		originalFileName= new String(originalFileName.getBytes("euc-kr"),"ISO-8859-1");
		
		File f = new File(fullPath);
		
		if(!f.exists()) {
			return false;
		}
		//파일 다운로드 클라이언트에게 주는거답!
		
		response.setContentType("application/octet-stream");
		
		response.setHeader("Content-disposition", "attachment;fileName=" +originalFileName);
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));// 파일 정보를 읽어서 bis에 넣어놔
		
		OutputStream out = response.getOutputStream();
		
		int data;
		byte [] bytes = new byte[4096];
		
		while((data=bis.read(bytes,0,4096))!=-1) {
			out.write(bytes,0,data);
		}
		out.flush();
		out.close();
		bis.close();
		
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
		
		return true;

	}

	// 파일 삭제<진짜 파일을 지우는 메소드>
	public static void doFileDelete(String fileName, String path) {
		
		try {
			
		
		
		String filePath = path + File.separator + fileName;
		
		File f =  new File(filePath);
		
		if(f.exists()) {
			f.delete();//물리적 파일삭제
		}
		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		
		
		
		
	}
	
	
	
}