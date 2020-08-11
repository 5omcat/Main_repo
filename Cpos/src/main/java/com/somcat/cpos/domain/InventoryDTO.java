package com.somcat.cpos.domain;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InventoryDTO {
	private static Logger log = LoggerFactory.getLogger(InventoryDTO.class);
	
	
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


