package com.vam.mapper;

import java.io.File;

import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberMapperTest {

	@Autowired
	private MemberMapper membermapper;			//MemberMapper.java 인터페이스 의존성 주입
	
	@Autowired
	JavaMailSenderImpl mailSender;
	
	//회원가입 쿼리 테스트 메서드
	@Test
	public void memberJoin() throws Exception{
		MemberVO member = new MemberVO();
		
		member.setMemberId("test2");			//회원 id
		member.setMemberPw("test2");			//회원 비밀번호
		member.setMemberName("test2");		//회원 이름
		member.setMemberMail("test2");		//회원 메일
		member.setMemberAddr1("test2");		//회원 우편번호
		member.setMemberAddr2("test2");		//회원 주소
		member.setMemberAddr3("test2");		//회원 상세주소
		
		membermapper.memberJoin(member);			//쿼리 메서드 실행
		
	}
	
	// 아이디 중복검사
	//@Test
	public void memberIdChk() throws Exception{
		String id = "admin";	// 존재하는 아이디
		String id2 = "test123";	// 존재하지 않는 아이디
		membermapper.idCheck(id);
		membermapper.idCheck(id2);
	}
	
	 // MimeMessagePreparator를 사용해서 메일을 전송하는 방법
   // @Test
    public void mailSendTest2() throws Exception{
        
        String subject = "test@naver.com";
        String content = "메일 테스트 내용" + "<img src=\"https://t1.daumcdn.net/cfile/tistory/214DCD42594CC40625\">";
        String from = "test@naver.com";
        String to = "tpdms0115@naver.com";
        
        try {
            final MimeMessagePreparator preparator = new MimeMessagePreparator() {
                
                public void prepare(MimeMessage mimeMessage) throws Exception{
                    final MimeMessageHelper mailHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                    
                    mailHelper.setFrom(from);
                    mailHelper.setTo(to);
                    mailHelper.setSubject(subject);
                    mailHelper.setText(content, true);
                    
                    FileSystemResource file = new FileSystemResource(new File("D:\\test.txt")); 
                    mailHelper.addAttachment("test.txt", file);
                    
                }
                
            };
            
            mailSender.send(preparator);
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
}