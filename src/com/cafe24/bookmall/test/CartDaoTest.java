package com.cafe24.bookmall.test;

import java.util.List;

import com.cafe24.bookmall.dao.CartDao;
import com.cafe24.bookmall.dao.CategoryDao;
import com.cafe24.bookmall.vo.CartVo;
import com.cafe24.bookmall.vo.CategoryVo;
 
public class CartDaoTest {
	public static void main(String[] args) {
		insertTest();
		getListTest();	
	}
	public static void insertTest() {
		CartDao dao = new CartDao();
		CartVo vo = new CartVo();
		
		
		vo.setMemNo(1L);
		vo.setBookNo(1L);
		vo.setCount(2L);
		dao.insert(vo);	
		
		vo.setMemNo(2L);
		vo.setBookNo(2L);
		vo.setCount(3L);
		dao.insert(vo);	
	}
	
	public static void getListTest() {
		CartDao dao = new CartDao();
		List<CartVo> list = dao.getList();
		
		for(CartVo vo:list)
			System.out.println(vo);
		
	}
}
