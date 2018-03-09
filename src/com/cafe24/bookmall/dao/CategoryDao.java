package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.vo.CategoryVo;

public class CategoryDao extends DBConnection {
	public boolean insert(CategoryVo vo) {

		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn= getConnection();
			String sql = "insert into category values(?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getCtgNo());
			pstmt.setString(2, vo.getName());
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
	public List<CategoryVo> getList(){
		List<CategoryVo> list = new ArrayList <CategoryVo>();
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select *\r\n" + 
					" from category";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next() == true) {
				Long ctgNo = rs.getLong(1);
				String name = rs.getString(2);
				CategoryVo vo = new CategoryVo();
				
				vo.setCtgNo(ctgNo);
				vo.setName(name);
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
