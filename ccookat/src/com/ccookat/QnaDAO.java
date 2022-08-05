package com.ccookat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QnaDAO {

	private Connection conn;

	public QnaDAO(Connection conn) {

		this.conn = conn;

	}

	//Q&A  넘버 삭제시에도 밀리지 않게 해주는 maxnum코드
	public int getMaxNum() {

		int maxNum =0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select nvl(max(qnaNum),0) from qna";

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

	//페이징 처리를 위한 전체 데이터 갯수 도출
	public int getDataCount(String searchValue) {

		int dataCount = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			searchValue = "%" + searchValue + "%";

			sql = "select nvl(count(*),0) from qna ";
			sql+= "where qnaContent like ? or qnaTitle like ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, searchValue);
			pstmt.setString(2, searchValue);

			rs = pstmt.executeQuery();

			if(rs.next()) {

				dataCount = rs.getInt(1);							
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}		
		return dataCount;
	}

	public void updateHitCount(int qnaNum) {

		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "update qna set qnahitCount=qnahitCount+1 where qnaNum=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, qnaNum);

			pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}


	//Q&A 목록에 뿌려줄 데이터
	public List<QnaDTO> selectAll(int start,int end, String searchValue) {

		List<QnaDTO> lists = new ArrayList<>();
		QnaDTO qdto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			searchValue = "%" + searchValue + "%";

			sql ="select * from(select rownum rnum,data.* from ";
			sql+="(select qnaNum,qnaTitle,SUBSTR(qnaContent, 1, 30) qnaContent, ";
			sql+="customerId,to_char(qnaCreated,'yyyy.mm.dd') qnaCreated,qnaAnswer,qnaHitCount ";
			sql+="from qna where (qnacontent like ? or qnatitle like ?) ";			
			sql+="order by qnaNum desc) data) ";
			sql+="where rnum>=? and rnum<=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, searchValue);
			pstmt.setString(2, searchValue);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);

			rs = pstmt.executeQuery();

			while(rs.next()) {

				qdto = new QnaDTO();

				qdto.setQnaNum(rs.getInt("qnaNum"));
				qdto.setQnaTitle(rs.getString("qnaTitle"));
				qdto.setQnaContent(rs.getString("qnaContent"));
				qdto.setCustomerId(rs.getString("customerId"));
				qdto.setQnaCreated(rs.getString("qnaCreated"));
				qdto.setQnaAnswer(rs.getString("qnaAnswer"));
				qdto.setQnaHitCount(rs.getInt("qnaHitCount"));

				lists.add(qdto);

			}

			pstmt.close();
			rs.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return lists;
	}

	//Q&A 업로드
	public void insertData(QnaDTO qdto) {

		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "insert into qna(qnaNum,qnaTitle,qnaCreated,customerId,";
			sql+= "qnaContent,qnaHitCount) ";
			sql+= "values(?,?,sysdate,?,?,0)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, qdto.getQnaNum());
			pstmt.setString(2, qdto.getQnaTitle());
			pstmt.setString(3, qdto.getCustomerId());
			pstmt.setString(4, qdto.getQnaContent());

			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	//updata Data
	public void updateData(QnaDTO qdto) {

		PreparedStatement pstmt = null;
		String sql;

		try {
			
			sql = "update qna set qnaTitle=?,qnaContent=?, ";
			sql+= "where qnaNum=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, qdto.getQnaTitle());
			pstmt.setString(2, qdto.getQnaContent());
			pstmt.setInt(3, qdto.getQnaNum());
			
			pstmt.executeUpdate();
			pstmt.close();
		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}	
	
	
	//delete Data
	public void deleteData(int qnaNum) {
		
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "delete from qna where qnaNum=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, qnaNum);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
	}	

		
	//수정시 뿌려줄 데이터
	public QnaDTO slectData(int qnaNum) {

		QnaDTO qdto=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql ="select qnaNum,qnaTitle,qnaCreated,";
			sql+="qnaContent,qnaHitCount ";
			sql+="from qna where qnaNum=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, qnaNum);

			rs = pstmt.executeQuery();

			if(rs.next()) {

				qdto = new QnaDTO();
				
				qdto.setQnaNum(rs.getInt("qnaNum"));
				qdto.setQnaTitle(rs.getString("qnaTitle"));
				qdto.setQnaCreated(rs.getString("qnaCreated"));
				qdto.setQnaContent(rs.getString("qnaContent"));
				qdto.setQnaHitCount(rs.getInt("qnaHitCount"));
			}

			pstmt.close();
			rs.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return qdto;
	}	


}