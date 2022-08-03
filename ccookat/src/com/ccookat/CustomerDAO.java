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
	
	
	public int getMaxNum() {
		
		int maxNum = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select nvl(max(num),0) from customer";
			
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
	
	
	//입력
	public int insertData(CustomerDTO dto) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "insert into customer (customerId,customerPwd,customerName,customerTel ";
			sql+= "customerZipcode,customerAddr,customerYear,customerMonth, customerDay,customerCreated) ";
			sql+= "values (?,?,?,?,?,?,?,?,?,sysdate)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getCustomerId());
			pstmt.setString(2, dto.getCustomerPwd());
			pstmt.setString(3, dto.getCustomerName());
			pstmt.setString(4, dto.getCustomerTel());
			pstmt.setString(5, dto.getCustomerZipcode());
			pstmt.setString(6, dto.getCustomerAddr());
			pstmt.setString(7, dto.getCustomerYear());
			pstmt.setString(8, dto.getCustomerMonth());
			pstmt.setString(9, dto.getCustomerDay());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		  
		return result;
		
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
			sql+= "select customerId,customerPwd,customerName,customerTel, ";
			sql+= "customerZipcode,customerAddr,customerYear,customerMonth, customerDay, ";
			sql+= "to_char(created,'YYYY-MM-DD') created ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				CustomerDTO dto = new CustomerDTO();
				
				dto.setCustomerId(rs.getString("customerId"));
				dto.setCustomerPwd(rs.getString("customerPwd"));
				dto.setCustomerName(rs.getString("customerName"));
				dto.setCustomerTel(rs.getString("customerTel"));
				dto.setCustomerZipcode(rs.getString("customerZipcode"));
				dto.setCustomerAddr(rs.getString("customerAddr"));
				dto.setCustomerYear(rs.getString("customerYear"));
				dto.setCustomerMonth(rs.getString("customerMonth"));
				dto.setCustomerDay(rs.getString("customerDay"));
				dto.setCustomerCreated(rs.getString("created"));
				
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
		
		CustomerDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select customerId,customerPwd,customerName,customerTel,";
			sql+= "customerZipcode,customerAddr,customerYear,customerMonth,customerDay,";
			sql+= "created from Customer where customerId=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, customerId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto = new CustomerDTO();
				
				dto.setCustomerId(rs.getString("customerId"));
				dto.setCustomerPwd(rs.getString("customerPwd"));
				dto.setCustomerName(rs.getString("customerName"));
				dto.setCustomerTel(rs.getString("customerTel"));
				dto.setCustomerZipcode(rs.getString("customerZipcode"));
				dto.setCustomerAddr(rs.getString("customerAddr"));
				dto.setCustomerYear(rs.getString("customerYear"));
				dto.setCustomerMonth(rs.getString("customerMonth"));
				dto.setCustomerDay(rs.getString("customerDay"));
				dto.setCustomerCreated(rs.getString("created"));
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dto;
	}
	
	
	//회원정보 수정
	public int updateData(CustomerDTO dto) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "update customer set customerPwd=?,customerTel=?,";
			sql+= "customerZipcode=?,customerAddr=? where customerId=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getCustomerPwd());
			pstmt.setString(2, dto.getCustomerTel());
			pstmt.setString(3, dto.getCustomerZipcode());
			pstmt.setString(4, dto.getCustomerAddr());
			pstmt.setString(5, dto.getCustomerId());
			
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
