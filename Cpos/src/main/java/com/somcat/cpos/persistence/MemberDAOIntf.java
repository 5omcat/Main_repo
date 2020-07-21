package com.somcat.cpos.persistence;

import java.util.List;

import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.MemberVO;

public interface MemberDAOIntf {
	public int insertMember(MemberVO mvo);
	public int selectId(String member_id);
	public MemberVO selectMember(MemberVO mvo);
	public List<MemberVO> selectList(Criterion cri);
	public int deleteMember(String id);
	public int selectTotalCount(Criterion cri);
}
