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
	private MemberMapper membermapper;			//MemberMapper.java �������̽� ������ ����
	
	@Autowired
	JavaMailSenderImpl mailSender;
	
	//ȸ������ ���� �׽�Ʈ �޼���
	@Test
	public void memberJoin() throws Exception{
		MemberVO member = new MemberVO();
		
		member.setMemberId("test2");			//ȸ�� id
		member.setMemberPw("test2");			//ȸ�� ��й�ȣ
		member.setMemberName("test2");		//ȸ�� �̸�
		member.setMemberMail("test2");		//ȸ�� ����
		member.setMemberAddr1("test2");		//ȸ�� �����ȣ
		member.setMemberAddr2("test2");		//ȸ�� �ּ�
		member.setMemberAddr3("test2");		//ȸ�� ���ּ�
		
		membermapper.memberJoin(member);			//���� �޼��� ����
		
	}
	
	// ���̵� �ߺ��˻�
	//@Test
	public void memberIdChk() throws Exception{
		String id = "admin";	// �����ϴ� ���̵�
		String id2 = "test123";	// �������� �ʴ� ���̵�
		membermapper.idCheck(id);
		membermapper.idCheck(id2);
	}
	
	 // MimeMessagePreparator�� ����ؼ� ������ �����ϴ� ���
   // @Test
    public void mailSendTest2() throws Exception{
        
        String subject = "test@naver.com";
        String content = "���� �׽�Ʈ ����" + "<img src=\"https://t1.daumcdn.net/cfile/tistory/214DCD42594CC40625\">";
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