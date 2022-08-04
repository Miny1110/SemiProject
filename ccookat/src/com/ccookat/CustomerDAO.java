package com.ccookat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
	
	private Connection conn;
	
	public CustomerDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	/*public int getMaxNum() {
		
		int maxNum = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select nvl(max(customernum),0) from customer";
			
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
		
	}*/
	
	
	//입력
	public void insertData(CustomerDTO cdto) {
		
		//int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "insert into customer (customerId,customerPwd1,customerPwd2,customerName,";
			sql+= "customerEmail,customerTel) ";
			sql+= "values (?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cdto.getCustomerId());
			pstmt.setString(2, cdto.getCustomerPwd1());
			pstmt.setString(3, cdto.getCustomerPwd2()); 
			pstmt.setString(4, cdto.getCustomerName());
			pstmt.setString(5, cdto.getCustomerEmail());
			pstmt.setString(6, cdto.getCustomerTel());
			
			
			//result = pstmt.executeUpdate();
			pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	//전체 데이터 가져오기
	public List<CustomerDTO> getLists(int start,int end) {
		
		List<CustomerDTO> lists = new ArrayList<CustomerDTO>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select * from (";
			sql+= "select rownum rnum,data.* from (";
			sql+= "select customerId,customerPwd1,customerPwd2,";
			sql+= "customerName,customerEmail,customerTel ";
			//sql+= "to_char(created,'YYYY-MM-DD') created ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				CustomerDTO dto = new CustomerDTO();
				
				dto.setCustomerId(rs.getString("customerId"));
				dto.setCustomerPwd1(rs.getString("customerPwd1"));
				dto.setCustomerPwd2(rs.getString("customerPwd2"));
				dto.setCustomerName(rs.getString("customerName"));
				dto.setCustomerEmail(rs.getString("customerEmail"));
				dto.setCustomerTel(rs.getString("customerTel"));
				//dto.setCustomerCreated(rs.getString("created"));
				
				lists.add(dto);
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists;
		
	}
	
	
	//customerId로 한개의 데이터 가져오기
	public CustomerDTO getReadData(String customerId) {
		
		CustomerDTO cdto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select customerId,customerPwd1,customerPwd2,";
			sql+= "customerName,customerEmail,customerTel,";
			sql+= "from Customer where customerId=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, customerId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				cdto = new CustomerDTO();
				
				cdto.setCustomerId(rs.getString("customerId"));
				cdto.setCustomerPwd1(rs.getString("customerPwd1"));
				cdto.setCustomerPwd2(rs.getString("customerPwd2"));
				cdto.setCustomerName(rs.getString("customerName"));
				cdto.setCustomerEmail(rs.getString("customerEmail"));
				cdto.setCustomerTel(rs.getString("customerTel"));
				//cdto.setCustomerCreated(rs.getString("created"));
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return cdto;
	}
	
	
	//회원정보 수정
	public int updateData(CustomerDTO cdto) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "update customer set customerPwd1=?,customerPwd2=?, ";
			sql+= "customerEmail=?,customerTel=? from customer where customerId=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cdto.getCustomerPwd1());
			pstmt.setString(2, cdto.getCustomerPwd2());
			pstmt.setString(3, cdto.getCustomerEmail());
			pstmt.setString(4, cdto.getCustomerTel());
			pstmt.setString(5, cdto.getCustomerId());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
	}
	
	//회원탈퇴(삭제)
	public int deleteData(String customerId) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "delete customer where customerId=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, customerId);
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
	}

}
