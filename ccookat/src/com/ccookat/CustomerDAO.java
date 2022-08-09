package com.ccookat;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

public class CustomerDAO {
	
	private Connection conn;
	
	public CustomerDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	//입력
	public void insertData(CustomerDTO cdto) {
		
		//int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "insert into customer(customerId,customerPwd,customerName,";
			sql+= "customerEmail,customerTel,customerZipcode,customerAddr1,customerAddr2) ";
			sql+= "values(?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cdto.getCustomerId());
			pstmt.setString(2, cdto.getCustomerPwd());
			pstmt.setString(3, cdto.getCustomerName());
			pstmt.setString(4, cdto.getCustomerEmail());
			pstmt.setString(5, cdto.getCustomerTel());
			pstmt.setString(6, cdto.getCustomerZipcode());
			pstmt.setString(7, cdto.getCustomerAddr1());
			pstmt.setString(8, cdto.getCustomerAddr2());
			
			
			//result = pstmt.executeUpdate();
			pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
	
	
	
	//아이디 중복
/*	public boolean checkId(String customerId) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql; sql = "select customerId from customer where customerId = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString (1, customerId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("customerId").equals(customerId)) {
					return true;
				}
				
				
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return false;
	}*/
	
	public int idChk(String customerId) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "select customerId from customer where customerId=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customerId);
			result = pstmt.executeUpdate();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	
	
	//customerId로 한개의 데이터 가져오기
	public CustomerDTO getReadData(String customerId) {
		
		CustomerDTO cdto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select customerId,customerPwd,";
			sql+= "customerName,customerEmail,customerTel,customerZipcode,customerAddr1,customerAddr2 ";
			sql+= "from customer where customerId=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, customerId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				cdto = new CustomerDTO();
				
				cdto.setCustomerId(rs.getString("customerId"));
				cdto.setCustomerPwd(rs.getString("customerPwd"));
				cdto.setCustomerName(rs.getString("customerName"));
				cdto.setCustomerEmail(rs.getString("customerEmail"));
				cdto.setCustomerTel(rs.getString("customerTel"));
				cdto.setCustomerZipcode(rs.getString("customerZipcode"));
				cdto.setCustomerAddr1(rs.getString("customerAddr1"));
				cdto.setCustomerAddr2(rs.getString("customerAddr2"));
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return cdto;
	}
	
	
	//아이디 찾기 할때 쓰는 메소드
		public CustomerDTO getReadData(String customerName, String customerTel ) {
			
			CustomerDTO cdto = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql;
			
			try {
				
				sql = "select customerId,";
				sql+= "customerName,customerTel ";
				sql+= "from customer where customerName=? and customerTel=?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, customerName);
				pstmt.setString(2, customerTel);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					
					cdto = new CustomerDTO();
					
					cdto.setCustomerId(rs.getString("customerId"));
					cdto.setCustomerName(rs.getString("customerName"));
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
	public void updateData(CustomerDTO cdto) {
		
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "update customer set customerPwd=?,customerEmail=?,customerTel=?,";
			sql+= "customerZipcode=?,customerAddr1=?,customerAddr2=? ";
			sql+= "where customerId=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cdto.getCustomerPwd());
			pstmt.setString(2, cdto.getCustomerEmail());
			pstmt.setString(3, cdto.getCustomerTel());
			pstmt.setString(4, cdto.getCustomerZipcode());
			pstmt.setString(5, cdto.getCustomerAddr1());
			pstmt.setString(6, cdto.getCustomerAddr2());
			pstmt.setString(7, cdto.getCustomerId());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
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
