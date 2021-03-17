package com.project.plus.controller;

import java.io.File;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.plus.domain.MemberVO;
import com.project.plus.service.MemberService;

public class MemberController implements Controller {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="join", method=RequestMethod.GET)
	public String memberJoin(MemberVO vo) throws IOException {
		
		
		MultipartFile uploadFile = vo.getUploadfile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/" + fileName));
		}
		
		
		
		memberService.joinMember(vo);
		return "redirect:/index";
			
	}
	


}
