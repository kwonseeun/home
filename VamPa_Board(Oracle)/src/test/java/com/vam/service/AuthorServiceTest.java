package com.vam.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.AuthorVO;

public class AuthorServiceTest {

	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
	public class AuthorServiceTests {
	    
	    /*AuthoreService ������ ����*/
	    @Autowired
	    private AuthorService service;
	    
	    @Test
	    public void authorEnrollTest() throws Exception {
	 
	        AuthorVO author = new AuthorVO();
	        
	        author.setNationId("01");
	        author.setAuthorName("�׽�Ʈ");
	        author.setAuthorIntro("�׽�Ʈ �Ұ�");
	        
	        service.authorEnroll(author);
	        
	    }
	 
	}
}