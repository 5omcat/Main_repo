package com.somcat.cpos.service;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.somcat.cpos.domain.CategoryVO;
import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.InventoryDTO;
import com.somcat.cpos.domain.InventoryVO;
import com.somcat.cpos.domain.ScrapVO;
import com.somcat.cpos.persistence.StockScrapDAOIntf;

@Service
public class StockScrapService implements StockScrapServiceIntf{
	private static Logger log = LoggerFactory.getLogger(StockScrapService.class);
	
	@Inject
	StockScrapDAOIntf sdao;

	@Override
<<<<<<< HEAD
	public int addInventory(int wno) {
		return sdao.insertInventory(wno);
	}

	@Override
=======
>>>>>>> 30468e00518ec32b79620720d3d47f0feeb6ae67
	public List<InventoryVO> getLargeCate() {
		return sdao.selectLargeCate();
	}

	@Override
	public List<InventoryVO> getMediumCate() {
		return sdao.selectMediumCate();
	}

	@Transactional
	@Override
	public int addScrap(List<ScrapVO> svo) {
		List<Integer> ilist = sdao.insertScrap(svo);
		log.info("addscrap-ilist: "+ilist);
		return sdao.deleteInventory(ilist);
	}

	@Override
	public List<ScrapVO> getScrapList(Date date) {
		return sdao.selectScrapList(date);
	}

	@Override
	public int modifyQuantity(InventoryVO ivo) {
		return sdao.updateQuantity(ivo);
	}

	@Override
	public int removeInventory(int inventory_no) {
		return sdao.deleteInven(inventory_no);
	}

	@Override
	public InventoryDTO getInvenList(Criterion cri) {
		List<InventoryVO> list = sdao.selectInvenList(cri);
		int itemCnt = sdao.totalCount(cri);
		InventoryDTO idto= new InventoryDTO(itemCnt, list);
		return idto;
	}

	@Override
	public List<CategoryVO> getAllCate() {
		return sdao.selectAllCate();
	}
	
	@Override
	public InventoryDTO getInvenList2(Criterion cri) {
		List<InventoryVO> list = sdao.selectInventoryList(cri);
		int itemCnt = sdao.totalCount(cri);
		InventoryDTO idto= new InventoryDTO(itemCnt, list);
		return idto;
	}

	@Transactional
	@Override
	public int addScrap(ScrapVO svo) {
		sdao.insertScrap(svo);
		return sdao.deleteInven(svo.getIno());
	}

	@Override
	public int getTotalCount(Criterion cri) {
		return sdao.totalCount(cri);
	}
}
