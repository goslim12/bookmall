package com.cafe24.bookmall.vo;

public class OrderVo {
	private Long orderNo;
	private String name;
	private Long memNo;
	private String dst;
	private Long price;
	private String orderDate;
	@Override
	public String toString() {
		return "OrderBookVo [orderNo=" + orderNo + ", name=" + name + ", memNo=" + memNo + ", dst=" + dst + ", price="
				+ price + ", orderDate=" + orderDate + "]";
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getMemNo() {
		return memNo;
	}
	public void setMemNo(Long memNo) {
		this.memNo = memNo;
	}
	public String getDst() {
		return dst;
	}
	public void setDst(String dst) {
		this.dst = dst;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

}
