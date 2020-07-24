package com.somcat.cpos.service;

import java.util.List;

import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.HeadVO;

public interface HeadServiceIntf {
	public int regist(HeadVO hvo);
	public int checkBarcode(int barcode);
	public int checkPname(String pname);
	public List<HeadVO> getHeadList(Criterion cri);
	public List<HeadVO> getLargeCate(Criterion cri);
	public List<HeadVO> getMediumCate(Criterion cri);
	public int modify(HeadVO hvo);
	public int remove(int barcode);	
	public int getTotalCount(Criterion cri);
}
