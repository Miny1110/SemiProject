package com.ccookat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class NoticeDAO {
	
	private Connection conn;

	public NoticeDAO(Connection conn) {

		this.conn = conn;		
	}
	
	//공지사항 넘버 삭제시에도 밀리지 않게 해주는 maxnum코드
	public int getMaxNum() {
		
		int maxNum =0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select nvl(max(num),0) from notice";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				maxNum = rs.getInt(1); 								
			}
			
			rs.close();
			pstmt.close();
		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return maxNum;
	}
	
	//공지사항 업로드
	public void insertData(NoticeDTO dto) {
		
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "insert into(noticeNum,noticeTitle,noticeCreated,";
			sql+= "noticeContent,noticeHitCount,noticeImage) ";
			sql+= "values(?,?,sysdate,?,?,?)";
					
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getNoticeNum());
			pstmt.setString(2, dto.getNoticeTitle());
			pstmt.setString(3, dto.getNoticeContent());
			pstmt.setString(4, dto.getNoticeImage());
			
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	//공지사항 수정
	public void updateData(NoticeDTO dto) {
		
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			 sql ="update notice set noticeTitle=?,noticeContent=?,";
			 sql+="noticeImage=? where noticeNum = ?";
				
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setString(1, dto.getNoticeTitle());
			 pstmt.setString(2, dto.getNoticeContent());
			 pstmt.setString(3, dto.getNoticeImage());
			 pstmt.setInt(4, dto.getNoticeNum());
			 
			 pstmt.executeUpdate();
			 
			 pstmt.close();
			 			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
			
	}
	
	//공지사항 삭제
	public void deleteData(int noticeNum) {
		
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql ="delete from notice where noticenum=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, noticeNum);
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
			
	}
	
	//수정시 뿌려줄 데이터
	public NoticeDTO selectData(int noticeNum) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		NoticeDTO dto = null;
		String sql;
		
		try {
			
			sql ="select noticeNum,noticeTitle,noticeCreated,";
			sql+="noticeContent,noticeHitCount,noticeImage) ";
			sql+="from notice where noticenum=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, noticeNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto = new NoticeDTO();
				
				dto.setNoticeNum(Integer.parseInt("noticeNum"));
				dto.setNoticeTitle("noticeTitle");
				dto.setNoticeCreated("noticeCreated");
				dto.setNoticeContent("noticeContent");
				dto.setNoticeHitCount(Integer.parseInt("noticeHitCount"));
				dto.setNoticeImage("noticeImage");
				
			}
			
			pstmt.close();
			rs.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dto;
	}
	
	//공지사항 목록에 뿌려줄 데이터
	
	public List<NoticeDTO> selectAll(int start,int end) {
		
		List<NoticeDTO> lists = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {

			sql ="select * from(select rownum rnum,data.* from ";
			sql+="(select noticeNum,noticeTitle,noticeCreated,noticeContent,noticeHitCount,noticeImage ";
			sql+="from notice order by noticeNum) data) ";
			sql+="where rnum>=? and rnum<=?";
			
				
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				
				NoticeDTO dto = new NoticeDTO();
				
				dto.getNoticeNum();
				dto.getNoticeTitle();
				dto.getNoticeCreated();
				dto.getNoticeContent();
				dto.getNoticeHitCount();
				dto.getNoticeImage();							
				
				lists.add(dto);
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists;
	}
	
	

}
