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

	
	//장바구니에서 넘어온거 보여주기
	
	
	//결제한 아티엠 타입의 수량 만큼 재고에서 빼주는 코딩 필요함
	
	
	
	//고객정보와 아이템 수량 아이템 타입을 테이블에 insert해줘야함
	
	
	
}
