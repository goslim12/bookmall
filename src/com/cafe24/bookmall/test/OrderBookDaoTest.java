package com.cafe24.bookmall.test;

import java.util.List;

import com.cafe24.bookmall.dao.OrderBookDao;
import com.cafe24.bookmall.dao.OrderDao;
import com.cafe24.bookmall.vo.OrderBookVo;
import com.cafe24.bookmall.vo.OrderVo;

public class OrderBookDaoTest {
	public static void main(String[] args) {
		insertTest();
		getListTest();	
	} 
	public static void insertTest() {
		OrderBookDao dao = new OrderBookDao();
		OrderBookVo vo = new OrderBookVo();
		
		vo.setOrderNo(1L);
		vo.setBookNo(2L);
		vo.setCount(3L);
		vo.setPrice(50000L);
		dao.insert(vo);
		
		vo.setOrderNo(1L);
		vo.setBookNo(3L);
		vo.setCount(3L);
		vo.setPrice(45000L);
		dao.insert(vo);
	}
	
	public static void getListTest() {
		OrderBookDao dao = new OrderBookDao();
		List<OrderBookVo> list = dao.getList();
		
		for(OrderBookVo vo:list)
			System.out.println(vo);
		
	}
}
