package com.cafe24.bookmall.vo;

public class CategoryVo {
	private Long ctgNo;
	private String name;
	
	@Override
	public String toString() {
		return "CategoryVo [ctgNo=" + ctgNo + ", name=" + name + "]";
	}
	public Long getCtgNo() {
		return ctgNo;
	}
	public void setCtgNo(Long ctgNo) {
		this.ctgNo = ctgNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
