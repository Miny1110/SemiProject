package com.ccookat;

import java.sql.Connection;

public class CartDAO {

	private Connection conn;
	
	public CartDAO(Connection conn) {
		this.conn = conn;	
	}
	
	//장바구니에 넣어져있는 데이터를 가져오기
	//조건절에 customerId 일치할때 넣기
	public void selectAll(String customerId) {
		
		
	}
	
	//장바구니에 담기
	//
	public void insertData(CartDTO ctdto) {
		
		
		
	}
	
	
	
	
	
}
