package com.ccookat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	//주문조회에 뿌려줄 데이터
	public List<CustomerOrderDTO> selectAll(String customerId) {
		
		List<CustomerOrderDTO> orderlists = new ArrayList<CustomerOrderDTO>();
		CustomerOrderDTO ordto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
		
			sql ="select ordernum,customerid,TO_CHAR(ordate,'HH24:MI:SS') ordate,";
			sql+="customerOrderName,customerOrderZipCode,customerOrderAddr1,customerOrderAddr2,";
			sql+="customerOrderTel,customerOrderPay,customerMemo,customerOrderPrice ";
			sql+="from customerorder where customerId = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, customerId);

			rs = pstmt.executeQuery();

			while(rs.next()) {

				ordto = new CustomerOrderDTO();

				ordto.setOrderNum(rs.getInt("ordernum"));
				ordto.setCustomerId(rs.getString("customerId"));
				ordto.setOrdate(rs.getString("ordate"));
				ordto.setCustomerOrderName(rs.getString("customerOrderName"));
				ordto.setCustomerOrderZipCode(rs.getString("customerOrderZipCode"));
				ordto.setCustomerOrderAddr1(rs.getString("customerOrderAddr1"));
				ordto.setCustomerOrderAddr2(rs.getString("customerOrderAddr2"));
				ordto.setCustomerMemo(rs.getString("customerMemo"));
				ordto.setCustomerOrderTel(rs.getString("customerOrderTel"));
				ordto.setCustomerOrderPay(rs.getString("customerOrderPay"));
				ordto.setCustomerOrderPrice(rs.getInt("customerOrderPrice"));
				
				orderlists.add(ordto);		
			}

			pstmt.close();
			rs.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return orderlists;
	}
	

	//결제한 아티엠 타입의 수량 만큼 재고에서 빼주는 코딩 필요함
	
	

	
	
}
