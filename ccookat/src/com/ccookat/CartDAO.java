package com.ccookat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {

	private Connection conn;

	public CartDAO(Connection conn) {
		this.conn = conn;	
	}

	public int getMaxNum() {

		int maxNum =0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select nvl(max(cartNum),0) from cart";

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


	//장바구니에 넣어져있는 데이터를 가져오기
	//나중에 주문하기 버튼활성화 시킬때를 고려해서 
	//아이템 가격을 item 테이블에서 가져오고
	//totprice는 서블릿에서 장바구니에 인서트할때 연산을 통해서 가격을 넣을 예정 인데
	//이거는 상세페이지에서 장바구니에 넣는 작업을 하면서 그때그때 수정해야 할 것 같음
	//몰르겠음 이부분 걍 일단 다 가져와놓고 필요없으면 삭제
	public List<CartDTO> selectAll(String customerId) {

		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String sql;

		CartDTO ctdto = null;
		List<CartDTO> lists = new ArrayList<CartDTO>();

		try {	

			sql = "select a.cartnum,a.customerid,a.itemnum,a.cartitemcount,";
			sql+= "a.carttotprice, b.itemname,b.itemImage1,b.itemPrice,b.itemDiscount from cart a join item b ";
			sql+= "on a.itemnum = b.itemnum where customerid=? order by a.cartnum desc";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, customerId);

			rs = pstmt.executeQuery();

			while(rs.next()) {

				ctdto = new CartDTO();

				ctdto.setCartNum(rs.getInt(1));
				ctdto.setCustomerId(rs.getString(2));
				ctdto.setItemNum(rs.getInt(3));
				ctdto.setCartItemCount(rs.getInt(4));
				ctdto.setCartTotPrice(rs.getInt(5));//이건 할인후 수량까지 추가한 총금액
				ctdto.setItemName(rs.getString(6));
				ctdto.setItemImage1(rs.getString(7));				
				ctdto.setItemPrice(rs.getInt(8)); //이건 할인전 금액
				ctdto.setItemDiscount(rs.getInt(9));
					
				lists.add(ctdto);

			}

			pstmt.close();
			rs.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return lists;	
	}


	//장바구니에 담기
	//고객이 장바구니에 담으면 아이템넘버랑 수량 고객정보 가져와서 넣어야함
	//totalprice가격이 있는데 이건 주문으로 넘어갈때 담아서 넘겨줌
	//생각해보니까 maxnum있어야함 그걸로 cartnum 순서대로 관리해야됨
	public void insertData(CartDTO ctdto) {

		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "insert into cart(cartnum,customerid,itemnum,";
			sql+= "cartitemcount,carttotprice,itemprice) ";
			sql+= "values(?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, ctdto.getCartNum());
			pstmt.setString(2, ctdto.getCustomerId());
			pstmt.setInt(3, ctdto.getItemNum());
			pstmt.setInt(4, ctdto.getCartItemCount());
			pstmt.setInt(5, ctdto.getCartTotPrice());
			pstmt.setInt(6, ctdto.getItemPrice());
			
			pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
	public void deleteData(int itemNum, String customerId) {
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "delete from cart where itemNum =? and customerId = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, itemNum);
			pstmt.setString(2, customerId);

			pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}	

	}

	//같은상품을 장바구니에 또 담았을때 기존에 있던 수량에 추가된수량을 더해서 수정해줌
	public void updateData(CartDTO ctdto) {

		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "update cart set cartItemCount = cartItemCount+?, ";
			sql+="CartTotPrice=CartTotPrice+? ";	
			sql+="where customerId=? and cartNum = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, ctdto.getCartItemCount());
			pstmt.setInt(2, ctdto.getCartTotPrice());
			pstmt.setString(3, ctdto.getCustomerId());
			pstmt.setInt(4, ctdto.getCartNum());

			pstmt.executeUpdate();			
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	//그아이디에 장바구니에 같은상품이 있는지 알아보기위해 한개의 데이터를 가져와보는 출력문
	public int getReadData(int itemNum, String customerId) {
		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select cartNum from cart where itemNum=? and customerId=? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, itemNum);
			pstmt.setString(2, customerId);

			rs = pstmt.executeQuery();

			if(rs.next()) {				
				result =rs.getInt(1);					
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	//로그인한 사람이 가지고 있는 장바구니 수량 갯수를 장바구니 이모티콘에 출력해줄 데이터
	public int cartCount(String customerId) {
		int cartCount = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql; 

		try {

			sql = "select nvl(count(*),0) from cart where customerid = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, customerId);

			rs = pstmt.executeQuery();

			if(rs.next()) {

				cartCount = rs.getInt(1); 	

			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return cartCount;
	}
	
	//주문하기가 성공하면 장바구니에서 데이터를 삭제해줌
	public void orderdelete(String customerId) {		
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "delete from cart where customerId = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, customerId);

			pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}	
		
	}





}