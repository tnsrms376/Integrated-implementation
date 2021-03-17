package com.project.plus.service;

import org.apache.ibatis.session.SqlSession;

import com.project.plus.domain.MemberVO;

public interface MemberService {

	//회원가입
	public void joinMember(MemberVO vo);

	public MemberVO login(MemberVO vo);
}
