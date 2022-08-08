package com.ccookat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReplyDAO {
	private Connection conn = null;
	
	public ReplyDAO(Connection conn) {
		this.conn =conn;
	}
	
	public int getMaxNum() {
		int maxNum = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			sql ="select nvl(max(replyNum),0) from reply";
			
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

		
	//답변 업로드
	public void insertData(ReplyDTO redto) {

		PreparedStatement pstmt = null;
		String sql;

		try {
			/*
			 * System.out.println(rdto.getCustomerId());
			 * System.out.println(rdto.getReviewTitle());
			 * System.out.println(rdto.getReviewContent());
			 */

			sql = "insert into reply (replyNum,customerId,replyContent,replyCreated) ";
			sql += "values (?,?,?,sysdate)";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, redto.getReplyNum());
			pstmt.setString(2, redto.getCustomerId());
			pstmt.setString(3, redto.getReplyContent());

			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
	
	
	//답변보이게 하기<데이터 뿌리기>
	public List<ReplyDTO> getLists() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		ReplyDTO redto = null;
		List<ReplyDTO> lists = new ArrayList<ReplyDTO>();

		try {

			sql = "select replyNum,customerId,replyContent,replyCreated ";
			sql += "from reply order by replyNum desc";

			pstmt = conn.prepareStatement(sql);

			// 답변 페이징 할지 결정해서 이거 수정하기
			// pstmt.setString(1, start);
			// pstmt.setString(2, end);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				redto = new ReplyDTO();

				redto.setReplyNum(rs.getInt("replyNum"));
				redto.setCustomerId(rs.getString("customerId"));
				redto.setReplyContent(rs.getString("replyContent"));
				redto.setReplyCreated(rs.getString("replyCreated"));

				lists.add(redto);

			}

			pstmt.close();
			rs.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return lists;
	}
	
	//리플넘 기반 한놈만 불러오는거...
	public ReplyDTO getReadData(int qnaNum) {
	
		ReplyDTO redto =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			sql = "select replyNum,customerId,replyContent,replyCreated ";
			sql+= "from reply where replyNum=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, qnaNum);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				
				redto = new ReplyDTO();

				redto.setReplyNum(rs.getInt("replyNum"));
				redto.setCustomerId(rs.getString("customerId"));
				redto.setReplyContent(rs.getString("replyContent"));
				redto.setReplyCreated(rs.getString("replyCreated"));

			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return redto;
	}
}
	

