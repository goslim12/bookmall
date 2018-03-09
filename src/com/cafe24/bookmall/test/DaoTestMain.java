package com.cafe24.bookmall.test;

public class DaoTestMain {

	public static void main(String[] args) {
		CategoryDaoTest.insertTest();
		BookDaoTest.insertTest();
		MemberDaoTest.insertTest();
		OrderDaoTest.insertTest();
		CartDaoTest.insertTest();
		OrderBookDaoTest.insertTest();
 
		
		System.out.println("==================카테고리===================");
		CategoryDaoTest.getListTest();
		System.out.println("\n==================서적===================");
		BookDaoTest.getListTest();
		System.out.println("\n==================주문===================");
		OrderDaoTest.getListTest();
		System.out.println("\n==================회원===================");
		MemberDaoTest.getListTest();
		System.out.println("\n==================카트===================");
		CartDaoTest.getListTest();
		System.out.println("\n==================주문도서===================");
		OrderBookDaoTest.getListTest();

		
		
		
		
	}

}
