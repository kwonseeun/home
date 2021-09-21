package com.vam.service;

import java.util.List;

import com.vam.model.BookVO;
import com.vam.model.Criteria;

public interface BookService {

	/* ��ǰ �˻� */
	public List<BookVO> getGoodsList(Criteria cri);
	
	/* ��ǰ �� ���� */
	public int goodsGetTotal(Criteria cri);	
	
}
