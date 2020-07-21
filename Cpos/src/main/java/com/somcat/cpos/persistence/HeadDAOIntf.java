package com.somcat.cpos.persistence;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.HeadVO;

public interface HeadDAOIntf {
	public int insertHead(HeadVO hvo);
	public int selectBarcode(int barcode);
	public int selectPname(String pname);
	public List<HeadVO> selectHeadList(Criterion cri);
	public List<HeadVO> selectLargeCate(Criterion cri);
	public List<HeadVO> selectMediumCate(Criterion cri);
	public int updateHead(HeadVO hvo);
	public int deleteHead(int barcode);
	public int selectTotalCount(Criterion cri);
}