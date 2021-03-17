package com.project.plus.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.plus.domain.MemberVO;
import com.project.plus.service.MemberService;



public class LoginControllerVersion2 implements Controller {

    private static final Logger logger = LoggerFactory.getLogger(LoginControllerVersion2.class);
    

	@Autowired
	private MemberService memberService;
	
    @RequestMapping(value = "/login.jsp", method = RequestMethod.GET)
    public String LoginPage() {
        return "login.jsp";
    }
	
	@RequestMapping(value="login.jsp", method=RequestMethod.POST) 
	public String login(@RequestParam("email") String email
            , @RequestParam("password") String password, HttpSession session) throws Exception{
		String path = "";

        MemberVO vo = new MemberVO();

        vo.setMemberEmail(email);
        vo.setMemberPassword(password);

        int result = memberService.login(vo);

        if(result == 1) {
            path = "index";
			session.setAttribute("userName", vo.getMemberNickname());

        } else {
            path = "login.jsp";
        }

        return path;		
	}
}

	
	
//	@Autowired
//	MemberVO memberService;  //?
//	
//	@RequestMapping(value="/login.do", method=RequestMethod.POST)
//	public String login(MemberVO vo, HttpSession session) {
//		System.out.println("로그인 인증 처리...");
//		if(vo.getMemberEmail() == null || vo.getMemberEmail().equals("")) {
//			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다");
//		}
//		MemberVO user = memberService;  //?
//		if(user != null) { 
//			session.setAttribute("userName", user.getMemberNickname());
//			return "getBoardList.do";
//		}
//		else
//			return "login.jsp";
//	}
////}
