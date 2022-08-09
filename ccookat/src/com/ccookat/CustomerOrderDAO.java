package com.ccookat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerOrderDAO {

	Connection conn;
	
	public CustomerOrderDAO(Connection conn) {
		
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
	public int insertData(CustomerOrderDTO cudto) {
		
		int result = 0;
		PreparedStatement pstmt= null;
		String sql;
		
		try {
			
			sql = "insert into order(orderNum,customerId,itemNum,cartNum,";
			sql+= "customerOrderName,customerOrderZipCode,customerOrderAddr1,customerAddr2,customerOrderTel,customerOrderPay,customerMemo) ";
			sql+= "values (?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cudto.getOrderNum());
			pstmt.setString(2, cudto.getCustomerId());
			pstmt.setInt(3, cudto.getItemNum());
			pstmt.setInt(4, cudto.getCartNum());
			pstmt.setString(5, cudto.getCustomerOrderName());
			pstmt.setString(6, cudto.getCustomerOrderZipCode());
			pstmt.setString(7, cudto.getCustomerOrderTel());
			pstmt.setString(8, cudto.getCustomerOrderAddr1());
			pstmt.setString(9, cudto.getCustomerOrderAddr2());
			pstmt.setString(10, cudto.getCustomerOrderPay());
			pstmt.setString(11, cudto.getCustomerMemo());
			
		
			pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	
	//결제한 아티엠 타입의 수량 만큼 재고에서 빼주는 코딩 필요함
	
	
	
	//고객정보와 아이템 수량 아이템 타입을 테이블에 insert해줘야함
	
	
	
}
