package com.ccookat;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderDetailDAO {
	
	Connection conn;
	
	public OrderDetailDAO(Connection conn){
		
		this.conn = conn;
	}

	public void insertDetailData(OrderDetailDTO oddto){

		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "insert into customerorderdetail(ordernum,customerid,itemnum,";
			sql+= "cartitemcount,carttotprice) ";
			sql+= "values(?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, oddto.getOrderNum());
			pstmt.setString(2, oddto.getCustomerId());
			pstmt.setInt(3, oddto.getItemNum());
			pstmt.setInt(4, oddto.getItemCount());
			pstmt.setInt(5, oddto.getCartTotPrice());	
			
			pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	
	}
	
	
	
	
	
	
	
}
