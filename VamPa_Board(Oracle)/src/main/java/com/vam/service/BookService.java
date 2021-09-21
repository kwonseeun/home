package com.vam.service;

import java.util.List;

import com.vam.model.BookVO;
import com.vam.model.Criteria;

public interface BookService {

	/* »óÇ° °Ë»ö */
	public List<BookVO> getGoodsList(Criteria cri);
	
	/* »óÇ° ÃÑ °¹¼ö */
	public int goodsGetTotal(Criteria cri);	
	
}
