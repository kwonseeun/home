package com.vam.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vam.mapper.AdminMapper;
import com.vam.model.AttachImageVO;
import com.vam.model.BookVO;
import com.vam.model.CateVO;
import com.vam.model.Criteria;

@Service
public class AdminServiceImpl implements AdminService {
	
	private static final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);

	@Autowired
	private AdminMapper adminMapper;	
	
	/* ��ǰ ��� */
	@Transactional
	@Override
	public void bookEnroll(BookVO book) {
		
		log.info("(srevice)bookEnroll........");
		
		adminMapper.bookEnroll(book);
		
		if(book.getImageList() == null || book.getImageList().size() <= 0) {
			return;
		}
		
		book.getImageList().forEach(attach ->{
			
			attach.setBookId(book.getBookId());
			adminMapper.imageEnroll(attach);
			
		});
		
		
	}

	/* ī�װ� ����Ʈ */
	@Override
	public List<CateVO> cateList() {
		
		log.info("(service)cateList........");
		
		return adminMapper.cateList();
	}

	/* ��ǰ ����Ʈ */
	@Override
	public List<BookVO> goodsGetList(Criteria cri) {
		
		log.info("goodsGetTotalList()..........");
		
		return adminMapper.goodsGetList(cri);
	}

	/* ��ǰ �� ���� */
	public int goodsGetTotal(Criteria cri) {
		
		log.info("goodsGetTotal().........");
		
		return adminMapper.goodsGetTotal(cri);
	}	
	
	/* ��ǰ ��ȸ ������ */
	@Override
	public BookVO goodsGetDetail(int bookId) {
		
		log.info("(service)bookGetDetail......." + bookId);
		
		return adminMapper.goodsGetDetail(bookId);
	}	
	
	/* ��ǰ ���� ���� */
	@Transactional
	@Override
	public int goodsModify(BookVO vo) {

		int result = adminMapper.goodsModify(vo);
		
		if(result == 1 && vo.getImageList() != null && vo.getImageList().size() > 0) {
			
			adminMapper.deleteImageAll(vo.getBookId());
			
			vo.getImageList().forEach(attach -> {
				
				attach.setBookId(vo.getBookId());
				adminMapper.imageEnroll(attach);
				
			});
			
		}
		
		return result;
	}	
	
	
	/* ��ǰ ���� ���� */
	@Override
	@Transactional
	public int goodsDelete(int bookId) {

		log.info("goodsDelete..........");
		
		adminMapper.deleteImageAll(bookId);			
		
		return adminMapper.goodsDelete(bookId);
	}		
	
	
	/* ���� ��ǰ �̹��� ���� ��� */
	@Override
	public List<AttachImageVO> getAttachInfo(int bookId) {
		
		log.info("getAttachInfo........");
		
		return adminMapper.getAttachInfo(bookId);
	}		
	
	
}
