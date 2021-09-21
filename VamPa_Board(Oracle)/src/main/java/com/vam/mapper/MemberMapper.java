package com.vam.mapper;

import org.springframework.stereotype.Repository;

import com.vam.model.MemberVO;

@Repository
public interface MemberMapper {
	
	//회원가입
	public void memberJoin(MemberVO member);
	//중복확인
	public int idCheck(String memberId);
	
	/* 로그인 */
	public MemberVO memberLogin(MemberVO member);
}
