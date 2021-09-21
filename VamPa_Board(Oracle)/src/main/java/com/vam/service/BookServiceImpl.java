package com.vam.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.BookMapper;
import com.vam.model.BookVO;
import com.vam.model.Criteria;


@Service
public class BookServiceImpl implements BookService{
	
	private static final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);

	@Autowired
	private BookMapper bookMapper;
	
	/* »óÇ° °Ë»ö */
	@Override
	public List<BookVO> getGoodsList(Criteria cri) {
		
		log.info("getGoodsList().......");
		
		String type = cri.getType();
		String[] typeArr = type.split("");
		
		for(String t : typeArr) {
			if(t.equals("A")) {
				String[] authorArr = bookMapper.getAuthorIdList(cri.getKeyword());
				cri.setAuthorArr(authorArr);
			}
		}

		return bookMapper.getGoodsList(cri);
	}

	/* »çÇ° ÃÑ °¹¼ö */
	@Override
	public int goodsGetTotal(Criteria cri) {
		
		log.info("goodsGetTotal().......");
		
		return bookMapper.goodsGetTotal(cri);
		
	}	
	
}
