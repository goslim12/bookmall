package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.vo.CartVo;
import com.cafe24.bookmall.vo.MemberVo;

public class CartDao extends DBConnection {
	public boolean insert(CartVo vo) {

		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn= getConnection();
			String sql = "insert into cart values(?, ?,?);";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getMemNo());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setLong(3, vo.getCount());

			int count = pstmt.executeUpdate();
			
			result = (count==1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn!=null)
					conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public List<CartVo> getList(){
		List<CartVo> list = new ArrayList <CartVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select *\r\n" + 
					" from cart";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next() == true) {
				Long memNo 	 = rs.getLong(1);
				Long bookNo	 = rs.getLong(2);
				Long count	 = rs.getLong(3);
				
				CartVo vo= new CartVo();
				
				vo.setMemNo(memNo);
				vo.setBookNo(bookNo);
				vo.setCount(count);
				list.add(vo);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver loading fail : "+e);
		} catch (SQLException e) {
			System.out.println("error "+e);
		} finally {
			//자원정리(Clean-Up)
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(rs != null) {
					rs.close();
				}
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
