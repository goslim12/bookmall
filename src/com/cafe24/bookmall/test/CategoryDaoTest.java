package com.cafe24.bookmall.test;

import java.util.List;

import com.cafe24.bookmall.dao.CategoryDao;
import com.cafe24.bookmall.vo.CategoryVo;

public class CategoryDaoTest {
	public static void main(String[] args) {
		insertTest();
		getListTest();	
	} 
	public static void insertTest() {
		CategoryDao dao = new CategoryDao();
		CategoryVo vo = new CategoryVo();
		
		vo.setCtgNo(1L);
		vo.setName("만화");
		dao.insert(vo);
		vo.setCtgNo(2L);
		vo.setName("잡지");
		dao.insert(vo);
		vo.setCtgNo(3L);
		vo.setName("소설");
		dao.insert(vo);	
	}
	
	public static void getListTest() {
		CategoryDao dao = new CategoryDao();
		List<CategoryVo> list = dao.getList();
		
		for(CategoryVo vo:list)
			System.out.println(vo);
		
	}
}
