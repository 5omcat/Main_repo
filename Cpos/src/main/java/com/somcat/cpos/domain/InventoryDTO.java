package com.somcat.cpos.domain;

import java.util.List;

public class InventoryDTO {
	private int itemCnt;
	private List<InventoryVO> ilist;
	
	public InventoryDTO() {}

	public InventoryDTO(int itemCnt, List<InventoryVO> ilist) {
		this.itemCnt = itemCnt;
		this.ilist = ilist;
	}

	public int getItemCnt() {
		return itemCnt;
	}

	public void setItemCnt(int itemCnt) {
		this.itemCnt = itemCnt;
	}

	public List<InventoryVO> getIlist() {
		return ilist;
	}

	public void setIlist(List<InventoryVO> ilist) {
		this.ilist = ilist;
	}
	
}
