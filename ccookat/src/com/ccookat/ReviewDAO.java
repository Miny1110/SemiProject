package com.ccookat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class ReviewDAO {
	
	//최댓값 구하기
	private Connection conn = null;
	
	public ReviewDAO(Connection conn) {
		this.conn = conn;
	}
	
	public int getMaxNum() {
		int maxNum = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			sql ="select nvl(max(num),0) from review";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				maxNum = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return maxNum;
		
	}
	
	// 전체 데이터 갯수 구하기
		public int getDataCount() {

			int totalCount = 0;

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql;

			try {

				sql = "select nvl(count(*),0) from review ";

				pstmt = conn.prepareStatement(sql);

				rs = pstmt.executeQuery();

				if(rs.next()) {
					totalCount = rs.getInt(1);
				}

				rs.close();
				pstmt.close();

			} catch (Exception e) {
				System.out.println(e.toString());
			}
			return totalCount;
		}

	
	public int insertData(ReviewDTO dto) {
		
	
		int result = 0;
			
		PreparedStatement pstmt = null;
		String sql;
		 
		 try {
			 
			 sql = "insert into review (customerId,reviewTitle,reviewContent,";
			 sql += "reviewNum,reviewImage,itemNum,reviewCreated,reviewLike) ";
			 sql += "values (?,?,?,?,?,?,sysdate,0)";
			 
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setString(1, dto.getCustomerId());
			 pstmt.setString(2, dto.getReviewTitle());
			 pstmt.setString(3, dto.getReviewContent());
			 pstmt.setInt(4, dto.getReviewNum());
			 pstmt.setString(5, dto.getReviewImage());
			 pstmt.setInt(6, dto.getItemNum());
			 
			 result= pstmt.executeUpdate();
			 
			 pstmt.close();
			
			} catch (Exception e) {
				 System.out.println(e.toString());
			}
			 return result;
			  }
	
	 //전체데이터 가져오기
	 public List<ReviewDTO> getLists(int start, int end){
			
			List<ReviewDTO> lists = new ArrayList<ReviewDTO>();
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql;
			
			try {
				
				sql = "select * from ("; 
				sql+= "select rownum rnum, data.* from (";
				sql+= "select customerId,reviewTitle,reviewContent,reviewNum,reviewImage,itemNum,reviewCreated,reviewLike ";
				sql+= "from review order by num desc) data)";
				sql+= "where rnum>=? and rnum<=?";
				
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					ReviewDTO dto = new ReviewDTO();
					
					dto.setCustomerId(rs.getString("customerId"));
					dto.setReviewTitle(rs.getString("reviewTitle"));
					dto.setReviewContent(rs.getString("reviewContent"));
					dto.setReviewNum(rs.getInt("reviewNum"));
					dto.setReviewImage(rs.getString("reviewImage"));
					dto.setItemNum(rs.getInt("itemNum"));
					dto.setReviewCreated(rs.getString("reviewCreated"));
					dto.setReviewLike(rs.getInt("reviewLike"));
					
					lists.add(dto);
					
				}
				
				rs.close();
				pstmt.close();
				
			} catch (Exception e) {
				System.out.println(e.toString());
				
			}
			
			return lists;
			
		}
	 public ReviewDTO getReadData(int reviewNum) {
		 
		 ReviewDTO dto = null;

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql;
			
			try {
				sql = "select customerId,reviewTitle,reviewContent,reviewNum,reviewImage,itemNum,reviewCreated,reviewLike ";
				sql += "from review where reviewNum=?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, reviewNum);
				
				rs = pstmt.executeQuery();
				
				if (rs.next()) {

					dto = new ReviewDTO();

					dto.setCustomerId(rs.getString("customerId"));
					dto.setReviewTitle(rs.getString("reviewTitle"));
					dto.setReviewContent(rs.getString("reviewContent"));
					dto.setReviewNum(rs.getInt("reviewNum"));
					dto.setReviewImage(rs.getString("reviewImage"));
					dto.setItemNum(rs.getInt("itemNum"));
					dto.setReviewCreated(rs.getString("reviewCreated"));
					dto.setReviewLike(rs.getInt("reviewLike"));

				}
				rs.close();
				pstmt.close();

				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			return dto;
	 }
	 
	 public int deleteData(int reviewNum) {

			int result = 0;

			PreparedStatement pstmt = null;
			String sql;

			try {

				sql = "delete review where reviewNum=?";

				pstmt = conn.prepareStatement(sql);

				pstmt.setInt(1, reviewNum);

				result = pstmt.executeUpdate();

				pstmt.close();

			} catch (Exception e) {
				System.out.println(e.toString());
			}

			return result;

		}
	 
	 //수정
	 
		public int updateData(ReviewDTO dto){
			
			int result = 0;
			PreparedStatement pstmt = null;
			String sql;
				
			try {
				sql = "update review set reviewTitle=?,reviewContent=?,reviewImage=?,reviewCreated=sysdate ";
				sql += "where customerId=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getReviewTitle());
				pstmt.setString(2, dto.getReviewContent());
				pstmt.setString(3, dto.getReviewImage());
				pstmt.setString(4, dto.getCustomerId());
				result = pstmt.executeUpdate();
				pstmt.close();
					
			} catch (Exception e) {
				System.out.println(e.toString());
			}
				
			return result;
	}
		
	
	
}

