package com.somcat.cpos.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.MemberVO;
import com.somcat.cpos.persistence.MemberDAOIntf;

@Service
public class MemberService implements MemberServiceIntf{
	private static Logger log = LoggerFactory.getLogger(MemberService.class);

	@Inject
	MemberDAOIntf mdao;
	
	@Override
	public int regist(MemberVO mvo) {
		return mdao.insertMember(mvo);
	}

	@Override
	public int checkId(String member_id) {
		return mdao.selectId(member_id);
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		return mdao.selectMember(mvo);
	}

	@Override
	public List<MemberVO> getList(Criterion cri) {
		return mdao.selectList(cri);
	}

	@Override
	public int resign(String id) {
		return mdao.deleteMember(id);
	}

	@Override
	public int getTotalCount(Criterion cri) {
		return mdao.selectTotalCount(cri);
	}
}
