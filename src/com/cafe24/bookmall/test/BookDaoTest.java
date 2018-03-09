package com.cafe24.bookmall.test;

import java.util.List;

import com.cafe24.bookmall.dao.BookDao;
import com.cafe24.bookmall.dao.CategoryDao;
import com.cafe24.bookmall.vo.BookVo;
import com.cafe24.bookmall.vo.CategoryVo;

public class BookDaoTest {
	public static void main(String[] args) {
		insertTest();
		getListTest();	
	} 
	public static void insertTest() {
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		
		vo.setBookNo(1L);
		vo.setTitle("노인과바다");
		vo.setPrice(10000L);
		vo.setCtgNo(3L);
		dao.insert(vo);	
		
		vo.setBookNo(2L);
		vo.setTitle("마징가Z");
		vo.setPrice(20000L);
		vo.setCtgNo(1L);
		dao.insert(vo);	
		
		vo.setBookNo(3L);
		vo.setTitle("맥심");
		vo.setPrice(40000L);
		vo.setCtgNo(2L);
		dao.insert(vo);	
	}
	
	public static void getListTest() {
		BookDao dao = new BookDao();
		List<BookVo> list = dao.getList();
		
		for(BookVo vo:list)
			System.out.println(vo);
		
	}
}
