package com.cafe24.bookmall.test;

import java.util.List;

import com.cafe24.bookmall.dao.MemberDao;
import com.cafe24.bookmall.vo.MemberVo;
 
public class MemberDaoTest {
	public static void main(String[] args) {
		insertTest();
		getListTest();	
	}
	public static void insertTest() {
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		
		vo.setMemNo(1L);     
		vo.setName("윤유나");    
		vo.setPhone("010-5555-1123");   
		vo.setEmail("yynaf@gmail.com");
		vo.setPassword("유나바보");
		dao.insert(vo);
		
		vo.setMemNo(2L);     
		vo.setName("김경한");    
		vo.setPhone("010-5058-1123");   
		vo.setEmail("goslim56@gmail.com");
		vo.setPassword("난더바보");
		dao.insert(vo);	
	}
	
	public static void getListTest() {
		MemberDao dao = new MemberDao();
		List<MemberVo> list = dao.getList();
		
		for(MemberVo vo:list)
			System.out.println(vo);
		
	}
}
