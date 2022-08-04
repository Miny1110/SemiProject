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
			sql ="select nvl(max(reviewNum),0) from review";
			
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

	//업로드
	public void insertData(ReviewDTO rdto) {
		
	
		PreparedStatement pstmt = null;
		String sql;
		 
		 try {
			 /*System.out.println(rdto.getCustomerId());
			 System.out.println(rdto.getReviewTitle());
			 System.out.println(rdto.getReviewContent());*/
			 
			 sql = "insert into review (customerId,reviewTitle,reviewContent,";
			 sql += "reviewNum,reviewImage,itemNum,reviewCreated,reviewLike) ";
			 sql += "values (?,?,?,?,?,?,sysdate,0)";
			 
			 pstmt = conn.prepareStatement(sql);
			 
			pstmt.setString(1, rdto.getCustomerId());
			 pstmt.setString(2, rdto.getReviewTitle());
			 pstmt.setString(3, rdto.getReviewContent());
			 pstmt.setInt(4, rdto.getReviewNum());
			 pstmt.setString(5, rdto.getReviewImage());
			 pstmt.setInt(6, rdto.getItemNum());
			
			
			 pstmt.executeUpdate();
			 pstmt.close();
			
			} catch (Exception e) {
				 System.out.println(e.toString());
			}
		
			  }
	
	 //전체데이터 가져오기
	 public List<ReviewDTO> getLists(int start, int end,int itemNum){
			
			List<ReviewDTO> reviewlists = new ArrayList<ReviewDTO>();
			ReviewDTO rdto = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql;
			
			try {
				
				sql = "select * from ("; 
				sql+= "select rownum rnum, data.* from (";
				sql+= "select customerId,reviewTitle,reviewContent,reviewNum,reviewImage,itemNum,reviewCreated,reviewLike ";
				sql+= "from review where itemNum=? order by reviewNum desc) data)";
				sql+= "where rnum>=? and rnum<=?";
				
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, itemNum);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
				
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					rdto = new ReviewDTO();
					
					rdto.setCustomerId(rs.getString("customerId"));
					rdto.setReviewTitle(rs.getString("reviewTitle"));
					rdto.setReviewContent(rs.getString("reviewContent"));
					rdto.setReviewNum(rs.getInt("reviewNum"));
					rdto.setReviewImage(rs.getString("reviewImage"));
					rdto.setItemNum(rs.getInt("itemNum"));
					rdto.setReviewCreated(rs.getString("reviewCreated"));
					rdto.setReviewLike(rs.getInt("reviewLike"));
					
					reviewlists.add(rdto);
					
				}
				
				rs.close();
				pstmt.close();
				
			} catch (Exception e) {
				System.out.println(e.toString());
				
			}
			
			return reviewlists;
			
		}
	 //하나 읽어오기
	 public ReviewDTO getReadData(int reviewNum) {
		 
		 ReviewDTO rdto = null;

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

					rdto = new ReviewDTO();

					rdto.setCustomerId(rs.getString("customerId"));
					rdto.setReviewTitle(rs.getString("reviewTitle"));
					rdto.setReviewContent(rs.getString("reviewContent"));
					rdto.setReviewNum(rs.getInt("reviewNum"));
					rdto.setReviewImage(rs.getString("reviewImage"));
					rdto.setItemNum(rs.getInt("itemNum"));
					rdto.setReviewCreated(rs.getString("reviewCreated"));
					rdto.setReviewLike(rs.getInt("reviewLike"));

				}
				rs.close();
				pstmt.close();

				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			return rdto;
	 }
	 //삭제하기
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
		public int updateData(ReviewDTO rdto){
			
			
			int result = 0;
			PreparedStatement pstmt = null;
			String sql;
				
			try {
				sql = "update review set reviewTitle=?,reviewContent=?,reviewImage=?,reviewCreated=sysdate ";
				sql += "where reviewNum=? ";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, rdto.getReviewTitle());
				pstmt.setString(2, rdto.getReviewContent());
				pstmt.setString(3, rdto.getReviewImage());
				pstmt.setInt(4, rdto.getReviewNum());
				
				result = pstmt.executeUpdate();
				pstmt.close();
					
			} catch (Exception e) {
				System.out.println(e.toString());
			}
				
			return result;
	}
		
	
	
}

