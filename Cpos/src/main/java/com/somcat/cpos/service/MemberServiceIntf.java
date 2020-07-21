package com.somcat.cpos.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.MemberVO;

public interface MemberServiceIntf {
	public int regist (MemberVO mvo);
	public int checkId(String member_id);
	public MemberVO login(MemberVO mvo);
	public List<MemberVO> getList(Criterion cri);
	public int resign(String id);
	public int getTotalCount(Criterion cri);
}
