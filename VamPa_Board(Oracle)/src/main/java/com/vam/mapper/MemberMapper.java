package com.vam.mapper;

import org.springframework.stereotype.Repository;

import com.vam.model.MemberVO;

@Repository
public interface MemberMapper {
	
	//ȸ������
	public void memberJoin(MemberVO member);
	//�ߺ�Ȯ��
	public int idCheck(String memberId);
	
	/* �α��� */
	public MemberVO memberLogin(MemberVO member);
}
