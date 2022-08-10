package com.ccookat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	//주문조회에 뿌려줄 데이터
	
	public List<OrderDetailDTO> selectAll(String customerId) {
		
		List<OrderDetailDTO> dtlists = new ArrayList<OrderDetailDTO>();
		OrderDetailDTO oddto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			
			sql ="select a.ordernum,a.customerid,a.cartitemcount,a.carttotprice,b.itemname,b.ItemImage1,a.itemnum ";
			sql+="from CUSTOMERORDERDETAIL a join item b on a.itemnum = b.itemnum ";
			sql+="where customerid = ?";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, customerId);

			rs = pstmt.executeQuery();

			while(rs.next()) {

				oddto = new OrderDetailDTO();

				oddto.setOrderNum(rs.getInt(1));
				oddto.setCustomerId(rs.getString(2));
				oddto.setItemCount(rs.getInt(3));
				oddto.setCartTotPrice(rs.getInt(4));
				oddto.setItemName(rs.getString(5));
				oddto.setItemImage1(rs.getString(6));
				oddto.setItemNum(rs.getInt(7));
				
				dtlists.add(oddto);
			}

			pstmt.close();
			rs.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dtlists;
		
	}
	

	
}
