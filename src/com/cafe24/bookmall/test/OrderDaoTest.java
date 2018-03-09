package com.cafe24.bookmall.test;

import java.util.List;

import com.cafe24.bookmall.dao.OrderDao;
import com.cafe24.bookmall.vo.OrderVo;

public class OrderDaoTest {
	public static void main(String[] args) {
		insertTest();
		getListTest();	
	} 
	public static void insertTest() {
		OrderDao dao = new OrderDao();
		OrderVo vo = new OrderVo();
		
		vo.setOrderNo(1L);
		vo.setName("kgh20180001");
		vo.setMemNo(2L);
		vo.setDst("서울");
		vo.setPrice(50000L);
		vo.setOrderDate("2018-11-23");
		dao.insert(vo);

	}
	
	public static void getListTest() {
		OrderDao dao = new OrderDao();
		List<OrderVo> list = dao.getList();
		
		for(OrderVo vo:list)
			System.out.println(vo);
		
	}
}
