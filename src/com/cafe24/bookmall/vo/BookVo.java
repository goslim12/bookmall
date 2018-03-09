package com.cafe24.bookmall.vo;

public class BookVo {
	private Long bookNo;
	private String title;
	private Long price;
	private Long ctgNo;
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getCtgNo() {
		return ctgNo;
	}
	public void setCtgNo(Long ctgNo) {
		this.ctgNo = ctgNo;
	}
	@Override
	public String toString() {
		return "BookVo [bookNo=" + bookNo + ", title=" + title + ", price=" + price + ", ctgNo=" + ctgNo + "]";
	}
	
}
