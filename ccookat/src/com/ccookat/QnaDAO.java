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

	//Q&A 넘버 삭제시에도 밀리지 않게 해주는 maxnum코드
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

	//Q&A 업로드(입력메소드)
	public int insertData(QnaDTO qdto) {

		int qnaResult = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "insert into qna (qnaNum,qnaTitle,qnaCreated,customerId,";
			sql+= "qnaContent,qnaHitCount) ";
			sql+= "values (?,?,sysdate,?,?,0)";

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
		return qnaResult;
	}

	/*//admin일때 다보이게 하는 메소드
			public List<QnaDTO> selectALladmin(int start,int end,String searchValue) {

				List<QnaDTO> lists = new ArrayList<QnaDTO>();
				
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql;

				try {
					
					
					searchValue = "%" + searchValue + "%";

					//rownum의 시작값(start)과 끝값(end)을 받을것임
					//rownum은 무조건 별칭을 만들어주어야함
					sql ="select * from(select rownum rnum,data.* from ";
					sql+="(select qnaNum,qnaTitle,qnaContent,";
					sql+="customerId,to_char(qnaCreated,'yyyy.mm.dd') qnaCreated,qnaHitCount ";
					sql+="from qna where qnatitle like ? ";			
					sql+="order by qnaNum desc) data) ";
					sql+="where rnum>=? and rnum<=?";

					pstmt = conn.prepareStatement(sql);

			
					pstmt.setString(1, searchValue);
					pstmt.setInt(2, start);
					pstmt.setInt(2, end);

					rs = pstmt.executeQuery();

					while(rs.next()) {

						QnaDTO qdto = new QnaDTO();

						qdto.setQnaNum(rs.getInt("qnaNum"));
						qdto.setQnaTitle(rs.getString("qnaTitle"));
						qdto.setQnaContent(rs.getString("qnaContent"));
						qdto.setCustomerId(rs.getString("customerId"));
						qdto.setQnaCreated(rs.getString("qnaCreated"));
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
*/
	//Q&A 목록에 뿌려줄 전체 데이터
	public List<QnaDTO> selectAll(int start,int end,
			String searchKey, String searchValue) {

		List<QnaDTO> lists = new ArrayList<QnaDTO>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			
			
			searchValue = "%" + searchValue + "%";

			//rownum의 시작값(start)과 끝값(end)을 받을것임
			//rownum은 무조건 별칭을 만들어주어야함
			sql ="select * from(select rownum rnum,data.* from ";
			sql+="(select qnaNum,qnaTitle,qnaContent,";
			sql+="customerId,to_char(qnaCreated,'yyyy.mm.dd') qnaCreated,qnaHitCount ";
			sql+="from qna where " + searchKey + " like ? ";			
			sql+="order by qnaNum desc) data) ";
			sql+="where rnum>=? and rnum<=?";

			pstmt = conn.prepareStatement(sql);

			/*pstmt.setString(1, customerId);*/
			pstmt.setString(1, searchValue);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);

			rs = pstmt.executeQuery();

			while(rs.next()) {

				QnaDTO qdto = new QnaDTO();

				qdto.setQnaNum(rs.getInt("qnaNum"));
				qdto.setQnaTitle(rs.getString("qnaTitle"));
				qdto.setQnaContent(rs.getString("qnaContent"));
				qdto.setCustomerId(rs.getString("customerId"));
				qdto.setQnaCreated(rs.getString("qnaCreated"));
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

	
	
	//페이징 처리를 위한 전체 데이터 갯수 도출
	public int getDataCount(String searchkey, String searchValue,String customerId) {

		int dataCount = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			searchValue = "%" + searchValue + "%";

			sql = "select nvl(count(*),0) from qna ";
			sql+= "where customerId =? and " + searchkey + " like ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, customerId);
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
	
	//num으로 한개의 데이터 가져오기
	public QnaDTO getReadData(int qnaNum) {
		
		QnaDTO qdto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select qnaNum,customerId,qnaCreated,qnaTitle,qnaContent ";
			sql+= "from qna where qnaNum=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, qnaNum);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				
				qdto = new QnaDTO();

				qdto.setQnaNum(rs.getInt("qnaNum"));
				qdto.setCustomerId(rs.getString("customerId"));
				qdto.setQnaCreated(rs.getString("qnaCreated"));
				qdto.setQnaTitle(rs.getString("qnaTitle"));
				qdto.setQnaContent(rs.getString("qnaContent"));

			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return qdto;
	}
	
	//조회수 증가
	public int updateHitCount(int qnaNum) {

		int qnaResult = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "update qna set qnaHitCount = qnaHitCount + 1 where qnaNum=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, qnaNum);

			qnaResult = pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return qnaResult;
		
	}
	


}