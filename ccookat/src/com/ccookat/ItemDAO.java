package com.ccookat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ItemDAO {
	
	private Connection conn;
	
	public ItemDAO(Connection conn) {
		
		this.conn = conn;
	}
	
	
	//제품별 상세페이지 itemNum을 위한 메소드
	public int getMaxNum() {
		
		int maxNum = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select nvl(max(itemNum),0) from item";
			
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

	
	//상세페이지 게시글 작성 메소드 (관리자 권한)
	public int insertData(ItemDTO idto) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "insert into item (itemNum,itemName,itemCount,itemPrice,itemDiscount,";
			sql+= "itemType,itemContent,itemImage1,itemImage2,itemImage3,itemImage4,";
			sql+= "itemStock,itemHitCount) ";
			sql+= "values (?,?,0,?,?,?,?,?,?,?,?,?,0)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, idto.getItemNum());
			pstmt.setString(2, idto.getItemName());
			pstmt.setInt(3, idto.getItemPrice());
			pstmt.setInt(4, idto.getItemDiscount());
			pstmt.setString(5, idto.getItemType());
			pstmt.setString(6, idto.getItemContent());
			pstmt.setString(7, idto.getItemImage1());
			pstmt.setString(8, idto.getItemImage2());
			pstmt.setString(9, idto.getItemImage3());
			pstmt.setString(10, idto.getItemImage4());
			pstmt.setInt(11, idto.getItemStock());
		
			pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
	}
	
	
	//itemNum으로 하나의 데이터 가져오기 (고객)
	public ItemDTO getReadData_Customer(int itemNum) {
		
		ItemDTO idto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select itemNum,itemName,itemCount,itemPrice,itemDiscount,";
			sql+= "itemType,itemContent,itemImage1) ";
			sql+= "from item where itemNum=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, itemNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				idto = new ItemDTO();
				
				idto.setItemNum(rs.getInt("itemNum"));
				idto.setItemName(rs.getString("itemName"));
				idto.setItemCount(rs.getInt("itemCount"));
				idto.setItemPrice(rs.getInt("itemPrice"));
				idto.setItemDiscount(rs.getInt("itemDiscount"));
				idto.setItemType(rs.getString("itemType"));
				idto.setItemContent(rs.getString("itemContent"));
				idto.setItemImage1(rs.getString("itemImage1"));
				
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return idto;
		
	}
	
	
	//전체상품 이미지 게시판에 데이터 불러오기
	public List<ItemDTO> getLists(int start, int end, String itemSearchValue){
		
		List<ItemDTO> lists = new ArrayList<ItemDTO>();
		ItemDTO idto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;	
		
		try {
			
			itemSearchValue = "%" + itemSearchValue + "%";
			
			sql = "select * from (";
			sql+= "select rownum rnum, data.* from (";
			sql+= "select itemNum,itemName,itemPrice,itemDiscount,itemType,itemImage1,itemHitCount ";
			sql+= "from item where itemName like ? order by itemNum desc) data ) ";
			sql+= "where rnum>=? and rnum<=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, itemSearchValue);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				idto = new ItemDTO();
				
				idto.setItemNum(rs.getInt("itemNum"));
				idto.setItemName(rs.getString("itemName"));
				idto.setItemPrice(rs.getInt("itemPrice"));
				idto.setItemDiscount(rs.getInt("itemDiscount"));
				idto.setItemType(rs.getString("itemType"));
				idto.setItemImage1(rs.getString("itemImage1"));
				idto.setItemHitCount(rs.getInt("itemHitCount"));
				
				lists.add(idto);
				
			}

			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println("전체상품에러");
			System.out.println(e.toString());
		}
		
		return lists;
		
	}
	
	
	//카테고리별 이미지 게시판에 데이터 불러오기
	public List<ItemDTO> getLists(int start, int end, String itemSearchValue, String itemType){
		
		List<ItemDTO> lists = new ArrayList<ItemDTO>();
		ItemDTO idto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;	
		
		try {
			
			itemSearchValue = "%" + itemSearchValue + "%";
			
			sql = "select * from (";
			sql+= "select rownum rnum, data.* from (";
			sql+= "select itemNum,itemName,itemPrice,itemDiscount,itemType,itemImage1,itemHitCount ";
			sql+= "from item where itemType=? and itemName like ? order by itemNum desc) data ) ";
			sql+= "where rnum>=? and rnum<=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, itemType);
			pstmt.setString(2, itemSearchValue);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				idto = new ItemDTO();
				
				idto.setItemNum(rs.getInt("itemNum"));
				idto.setItemName(rs.getString("itemName"));
				idto.setItemPrice(rs.getInt("itemPrice"));
				idto.setItemDiscount(rs.getInt("itemDiscount"));
				idto.setItemType(rs.getString("itemType"));
				idto.setItemImage1(rs.getString("itemImage1"));
				idto.setItemHitCount(rs.getInt("itemHitCount"));
				
				lists.add(idto);
				
			}

			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println("카테고리에러");
			System.out.println(e.toString());
		}
		
		return lists;
		
	}
	
	
	//itemNum으로 제품별 상세페이지에 띄울 하나의 데이터 가져오기
	//필요한 데이터: 제품번호, 이름, 가격, 할인, 카테고리, 내용, 이미지 4개, 재고
	public ItemDTO getReadData_detail(int itemNum) {
		
		ItemDTO idto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select itemNum,itemName,itemPrice,itemDiscount,itemType,";
			sql+= "itemContent,itemImage1,itemImage2,itemImage3,itemImage4,itemHitCount,itemStock ";
			sql+= "from item where itemNum=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, itemNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				idto = new ItemDTO();
				
				idto.setItemNum(rs.getInt("itemNum"));
				idto.setItemName(rs.getString("itemName"));
				idto.setItemPrice(rs.getInt("itemPrice"));
				idto.setItemDiscount(rs.getInt("itemDiscount"));
				idto.setItemType(rs.getString("itemType"));
				idto.setItemContent(rs.getString("itemContent"));
				idto.setItemImage1(rs.getString("itemImage1"));
				idto.setItemImage2(rs.getString("itemImage2"));
				idto.setItemImage3(rs.getString("itemImage3"));
				idto.setItemImage4(rs.getString("itemImage4"));
				idto.setItemHitCount(rs.getInt("itemHitCount"));
				idto.setItemStock(rs.getInt("itemStock"));
				
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return idto;
		
	}
	
	
	//상세페이지 게시글 삭제 메소드 (관리자 권한)
	public void deleteData(int itemNum) {
		
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "delete item where itemNum=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, itemNum);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	
	//페이징 처리를 위한 전체상품 데이터 개수 세기
	public int getDataCount(String itemSearchValue) {
		
		int dataCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			itemSearchValue = "%" + itemSearchValue + "%";
			
			sql = "select nvl(count(*),0) from item where itemName like ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, itemSearchValue);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dataCount = rs.getInt(1);
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dataCount;
		
	}
	

	//카테고리별 데이터 개수 세기
	public int getDataCount(String itemType, String itemSearchValue) {
		
		int dataCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			itemSearchValue = "%" + itemSearchValue + "%";
			
			sql = "select nvl(count(*),0) from item ";
			sql+= "where itemType=? and itemName like ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, itemType);
			pstmt.setString(2, itemSearchValue);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dataCount = rs.getInt(1);
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dataCount;
		
	}
	
	
	//조회수 증가
	public int updateHitCount(int itemNum) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "update item set itemHitCount = itemHitCount + 1 where itemNum=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, itemNum);
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
	}
	
	//전체상품 조회순으로 정렬
	//메인 jsp에 필요
	public List<ItemDTO> getHitCountLists(){

		List<ItemDTO> mainLists = new ArrayList<ItemDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;	

		try {

			
			sql = "select * from (";
			sql+= "select rownum rnum, data.* from (";
			sql+= "select itemNum,itemName,itemPrice,itemDiscount,itemType,itemImage1,itemHitCount ";
			sql+= "from item order by itemHitCount desc) data ) ";
			sql+= "where rnum>=1 and rnum<=12";

			pstmt = conn.prepareStatement(sql);

			
			rs = pstmt.executeQuery();

			while(rs.next()) {

				ItemDTO idto = new ItemDTO();

				idto.setItemNum(rs.getInt("itemNum"));
				idto.setItemName(rs.getString("itemName"));
				idto.setItemPrice(rs.getInt("itemPrice"));
				idto.setItemDiscount(rs.getInt("itemDiscount"));
				idto.setItemType(rs.getString("itemType"));
				idto.setItemImage1(rs.getString("itemImage1"));
				idto.setItemHitCount(rs.getInt("itemHitCount"));

				mainLists.add(idto);

			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return mainLists;

	}
	
	
	//조회순으로 정렬
	//카테고리별 이미지 게시판에 데이터 불러오기
	public List<ItemDTO> getHitCountLists(String itemType){
		
		List<ItemDTO> mainLists = new ArrayList<ItemDTO>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;	
		
		try {
			
			sql = "select * from (";
			sql+= "select rownum rnum, data.* from (";
			sql+= "select itemNum,itemName,itemPrice,itemDiscount,itemType,itemImage1,itemHitCount ";
			sql+= "from item where itemType=? order by itemHitCount desc) data ) ";
			sql+= "where rnum>=1 and rnum<=4";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, itemType);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				ItemDTO idto = new ItemDTO();
				
				idto.setItemNum(rs.getInt("itemNum"));
				idto.setItemName(rs.getString("itemName"));
				idto.setItemPrice(rs.getInt("itemPrice"));
				idto.setItemDiscount(rs.getInt("itemDiscount"));
				idto.setItemType(rs.getString("itemType"));
				idto.setItemImage1(rs.getString("itemImage1"));
				idto.setItemHitCount(rs.getInt("itemHitCount"));
				
				mainLists.add(idto);
				
			}

			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println("카테고리 인기상품 에러");
			System.out.println(e.toString());
		}
		
		return mainLists;
		
	}
	//주문하기되면 상품 수량에서 주문한 수량만큼 빼줘야함 itemNum이랑 itemCount 로 어떻게 해야되는데 .. ..
	public void afterOrder(int itemcount, int itemnum) {
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
				sql = "update item set itemStock=itemStock-? ";
				sql+= "where itemnum = ?";
			
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, itemcount);
				pstmt.setInt(2, itemnum);
				
				pstmt.executeUpdate();
				
				pstmt.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}	
		
	}
		
	
}
