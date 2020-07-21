package com.somcat.cpos.persistence;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.HeadVO;
import com.somcat.cpos.domain.MemberVO;

@Repository
public class OrderDAO implements OrderDAOIntf{
	private static Logger log = LoggerFactory.getLogger(OrderDAO.class);

	@Override
	public int insertProduct(MemberVO mvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectBarcode(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectPname(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HeadVO> selectHeadlist(Criterion cri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> selectLargeCate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> selectMediumCate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProduct(HeadVO hvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int bacode) {
		// TODO Auto-generated method stub
		return 0;
	}
}
