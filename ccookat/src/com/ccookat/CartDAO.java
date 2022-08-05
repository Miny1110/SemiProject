package com.ccookat;

import java.sql.Connection;

public class CartDAO {

	private Connection conn;
	
	public CartDAO(Connection conn) {
		
		this.conn = conn;
		
	}
	
}
