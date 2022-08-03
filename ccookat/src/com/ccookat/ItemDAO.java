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
			
			sql = "select nvl(max(num),0) from item";
			
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
	public void insertData(ItemDTO dto) {
		
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "insert into item (itemNum,itemName,itemCount,itemPrice,itemDiscount,)";
			sql+= "itemType,itemContent,itemImage1,itemImage2,itemImage3,itemImage4,";
			sql+= "itemStock,itemHitCount) ";
			sql+= "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getItemNum());
			pstmt.setString(2, dto.getItemName());
			pstmt.setInt(3, dto.getItemCount());
			pstmt.setInt(4, dto.getItemPrice());
			pstmt.setInt(5, dto.getItemDiscount());
			pstmt.setString(6, dto.getItemType());
			pstmt.setString(7, dto.getItemContent());
			pstmt.setString(8, dto.getItemImage1());
			pstmt.setString(9, dto.getItemImage2());
			pstmt.setString(10, dto.getItemImage3());
			pstmt.setString(11, dto.getItemImage4());
			pstmt.setInt(12, dto.getItemStock());
			pstmt.setInt(13, dto.getItemHitCount());
		
			pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	
	//상세페이지 게시글 수정 메소드 (관리자 권한)
	public ItemDTO getReadData(int itemNum) {
		
		ItemDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select itemNum,itemName,itemCount,itemPrice,itemDiscount,";
			sql+= "itemType,itemContent,itemImage1,itemImage2,itemImage3,itemImage4,";
			sql+= "itemStock,itemHitCount) ";
			sql+= "from item where itemNum=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, itemNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto = new ItemDTO();
				
				dto.setItemNum(rs.getInt("itemNum"));
				dto.setItemName(rs.getString("itemName"));
				dto.setItemCount(rs.getInt("itemCount"));
				dto.setItemPrice(rs.getInt("itemPrice"));
				dto.setItemDiscount(rs.getInt("itemDiscount"));
				dto.setItemType(rs.getString("itemType"));
				dto.setItemContent(rs.getString("itemContent"));
				dto.setItemImage1(rs.getString("itemImage1"));
				dto.setItemImage2(rs.getString("itemImage2"));
				dto.setItemImage3(rs.getString("itemImage3"));
				dto.setItemImage4(rs.getString("itemImage4"));
				dto.setItemStock(rs.getInt("itemStock"));
				dto.setItemHitCount(rs.getInt("itemHitCount"));
				
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dto;
		
	}
	
	
	//상세페이지 게시글 삭제 메소드 (관리자 권한)
	public void deleteDaata(int itemNum) {
		
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
	
	
	
	//카테고리별 이미지 게시판에 데이터 불러오기
	public List<ItemDTO> getLists(){
		
		List<ItemDTO> lists = new ArrayList<ItemDTO>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;	
		
		try {
			
			sql = "select * from (";
			sql+= "select rownum rnum, data.* from (";
			sql+= "select itemNum,itemName,itemPrice,itemDisccount,itemType,itemImage1 ";
			sql+= "from item order by itemNum desc) data ) ";
			
			pstmt = conn.prepareStatement(sql);
			
			while(rs.next()) {
				
				ItemDTO dto = new ItemDTO();
				
				dto.setItemNum(rs.getInt("itemNum"));
				dto.setItemName(rs.getString("itemName"));
				dto.setItemPrice(rs.getInt("itemPrice"));
				dto.setItemDiscount(rs.getInt("itemDiscount"));
				dto.setItemType(rs.getString("itemType"));
				dto.setItemImage1(rs.getString("itemImage1"));
				
				lists.add(dto);
				
			}

			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
