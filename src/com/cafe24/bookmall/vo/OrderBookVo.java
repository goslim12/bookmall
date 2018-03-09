package com.cafe24.bookmall.vo;

public class OrderBookVo {
	private Long orderNo;
	private Long bookNo;
	private Long count;
	private Long price;
	public Long getOrderNo() {
		return orderNo;
	} 
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderVo [orderNo=" + orderNo + ", bookNo=" + bookNo + ", count=" + count + ", price=" + price + "]";
	}
	
}
