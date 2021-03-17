package com.project.plus.tests;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import com.project.plus.domain.FaqVO;
import com.project.plus.service.FaqService;


public class FaqServiceClient {
	public static void main(String[] args) {
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("classpath:spring/root-context.xml");
		
		
		FaqService faqService = 
				(FaqService)container.getBean("FaqService");
		
		
		FaqVO vo = new FaqVO();
		vo.setFaqNum(1);
		vo.setFaqCategory("dhsmf");
		vo.setFaqTitle("제목");
		vo.setFaqContent("myBatis 내용입니다...");
		

		faqService.insertFaq(vo);

		System.out.println("된당~~");

				
		container.close();
	}

}
