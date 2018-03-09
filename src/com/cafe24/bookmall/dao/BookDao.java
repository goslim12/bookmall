package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.vo.BookVo;
import com.cafe24.bookmall.vo.CategoryVo;

public class BookDao extends DBConnection{
	public boolean insert(BookVo vo) {

		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn= getConnection();
			String sql = "insert into book values(?, ?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getBookNo());
			pstmt.setString(2, vo.getTitle());
			pstmt.setLong(3, vo.getPrice());
			pstmt.setLong(4, vo.getCtgNo());

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
	public List<BookVo> getList(){
		List<BookVo> list = new ArrayList <BookVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select *\r\n" + 
					" from book";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next() == true) {
				Long bookNo = rs.getLong(1);
				String title = rs.getString(2);
				Long price = rs.getLong(3);
				Long ctgNo = rs.getLong(4);
				BookVo vo = new BookVo();
				
				vo.setBookNo(bookNo);
				vo.setTitle(title);
				vo.setPrice(price);
				vo.setCtgNo(ctgNo);
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
