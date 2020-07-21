package com.somcat.cpos.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.MemberVO;

@Repository
public class MemberDAO implements MemberDAOIntf{
	private static Logger log = LoggerFactory.getLogger(MemberDAO.class);
	private static String ns = "MemberMapper.";

	@Inject
	SqlSession sql;
	
	@Override
	public int insertMember(MemberVO mvo) {
		return sql.insert(ns+"join", mvo);
	}

	@Override
	public int selectId(String member_id) {
		return sql.selectOne(ns+"checkid", member_id);
	}

	@Override
	public MemberVO selectMember(MemberVO mvo) {
		return sql.selectOne(ns+"login", mvo);
	}

	@Override
	public List<MemberVO> selectList(Criterion cri) {
		return sql.selectList(ns+"mlist", cri);
	}

	@Override
	public int deleteMember(String id) {
		return sql.delete(ns+"resign", id);
	}

	@Override
	public int selectTotalCount(Criterion cri) {
		return sql.selectOne(ns+"totalCount", cri);
	}
}
