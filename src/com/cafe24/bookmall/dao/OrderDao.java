package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.vo.OrderVo;

public class OrderDao extends DBConnection {
	public boolean insert(OrderVo vo) {

		boolean result = false;
			
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn= getConnection();
			String sql = "insert into bookmall.`order` values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getOrderNo());
			pstmt.setString(2, vo.getName());
			pstmt.setLong(3, vo.getMemNo());
			pstmt.setString(4, vo.getDst());
			pstmt.setLong(5, vo.getPrice());
			pstmt.setString(6, vo.getOrderDate());
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
	public List<OrderVo> getList(){
		List<OrderVo> list = new ArrayList <OrderVo>();
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select *\r\n" + 
					" from bookmall.`order`";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next() == true) {
				Long orderNo = rs.getLong(1);
				String name = rs.getString(2);
		        Long memNo = rs.getLong(3);
				String dst = rs.getString(4);
				Long price = rs.getLong(5);
				String orderDate =rs.getString(6);
				
				OrderVo vo = new OrderVo();
				
				vo.setOrderNo(orderNo);
				vo.setName(name);
				vo.setMemNo(memNo);
				vo.setDst(dst);
				vo.setPrice(price);
				vo.setOrderDate(orderDate);
				
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
