package com.project.plus.tests;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.project.plus.domain.MemberVO;
import com.project.plus.service.MemberService;

public class MemberMapperTest {
	
	public static void main(String[] args) throws Exception {
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("classpath:spring/root-context.xml");
		
		
		MemberService memeberService = 
				(MemberService)container.getBean("MemberService");

		MemberVO vo = new MemberVO();
		
		
		vo.setMemberEmail("test");
		vo.setMemberPassword("test");
		vo.setMemberPhone("0000");
		vo.setMemberName("tst");
		vo.setMemberNickname("test");
		
		
		memeberService.joinMember(vo);
		
		System.out.println("된당");
		container.close();
}

}
