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

			sql = "select nvl(max(orderNum),0) from CUSTOMERORDER";

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
	
	//주문정보(상품x오직 주문정보)
	public int insertOrderData(CustomerOrderDTO ordto) {
		
		int result = 0;
		PreparedStatement pstmt= null;
		String sql;
		
		try {
			
			sql = "insert into CUSTOMERORDER(orderNum,customerId,ordate,";
			sql+= "customerOrderName,customerOrderZipCode,customerOrderAddr1,customerOrderAddr2,customerOrderTel,customerOrderPay,customerMemo) ";
			sql+= "values (?,?,sysdate,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, ordto.getOrderNum());
			pstmt.setString(2, ordto.getCustomerId());
			pstmt.setString(3, ordto.getCustomerOrderName());
			pstmt.setString(4, ordto.getCustomerOrderZipCode());
			pstmt.setString(5, ordto.getCustomerOrderTel());
			pstmt.setString(6, ordto.getCustomerOrderAddr1());
			pstmt.setString(7, ordto.getCustomerOrderAddr2());
			pstmt.setString(8, ordto.getCustomerOrderPay());
			pstmt.setString(9, ordto.getCustomerMemo());			
		
			pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	
	
	
	
	//결제한 아티엠 타입의 수량 만큼 재고에서 빼주는 코딩 필요함
	
	

	
	
}
