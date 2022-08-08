package com.ccookat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerOrderDAO {

	Connection conn;
	
	private CustomerOrderDAO(Connection conn) {
		
		this.conn = conn;
	}
	
	public int getMaxNum() {
		
		int maxNum =0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		try {

			sql = "select nvl(max(customerOrderNum),0) from customerorder";

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

	
	//이미 주문하고 목록 불러와야하니 인서트하기
	public int insertData(CustomerOrderDTO cusdto ) {
		
		int result = 0;
		PreparedStatement pstmt= null;
		String sql;
		
		try {
			
			sql= "insert into order (""
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	//결제한 아티엠 타입의 수량 만큼 재고에서 빼주는 코딩 필요함
	
	
	
	//고객정보와 아이템 수량 아이템 타입을 테이블에 insert해줘야함
	
	
	
}
