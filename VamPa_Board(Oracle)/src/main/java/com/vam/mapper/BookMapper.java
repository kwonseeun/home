package com.vam.mapper;

import java.util.List;

import com.vam.model.BookVO;
import com.vam.model.Criteria;

public interface BookMapper {

	/* ��ǰ �˻� */
	public List<BookVO> getGoodsList(Criteria cri);
	
	/* ��ǰ �� ���� */
	public int goodsGetTotal(Criteria cri);
	
	/* �۰� id ����Ʈ ��û */
	public String[] getAuthorIdList(String keyword);
}
