package com.somcat.cpos.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.somcat.cpos.domain.CategoryVO;
import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.HeadVO;
import com.somcat.cpos.persistence.HeadDAOIntf;

@Service
public class HeadService implements HeadServiceIntf{
	
	@Inject
	HeadDAOIntf hdao;
	
	private static Logger log = LoggerFactory.getLogger(HeadService.class);

	@Override
	public int regist(HeadVO hvo) {
		return hdao.insertHead(hvo);
	}

	@Override
	public int checkBarcode(int barcode) {
		return hdao.selectBarcode(barcode);
	}

	@Override
	public int checkPname(String pname) {
		return hdao.selectPname(pname);
	}

	@Override
	public List<HeadVO> getHeadList(Criterion cri) {
		return hdao.selectHeadList(cri);
	}

	@Override
	public List<HeadVO> getLargeCate(Criterion cri) {
		return hdao.selectLargeCate(cri);
	}

	@Override
	public List<HeadVO> getMediumCate(Criterion cri) {
		return hdao.selectMediumCate(cri);
	}

	@Override
	public int modify(HeadVO hvo) {
		return hdao.updateHead(hvo);
	}

	@Override
	public int remove(int barcode) {
		return hdao.deleteHead(barcode);
	}

	@Override
	public int getTotalCount() {
		return hdao.selectTotalCount();
	}

	@Override
	public HeadVO getProduct(int barcode) {
		return hdao.selectProduct(barcode);
	}
}
