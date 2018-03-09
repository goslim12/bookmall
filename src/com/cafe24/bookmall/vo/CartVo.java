package com.cafe24.bookmall.vo;

public class CartVo {
	private Long memNo;
	private Long bookNo;
	private Long count;
	@Override
	public String toString() {
		return "CartVo [memNo=" + memNo + ", bookNo=" + bookNo + ", count=" + count + "]";
	}
	public Long getMemNo() {
		return memNo;
	}
	public void setMemNo(Long ctmNo) {
		this.memNo = ctmNo;
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
}
