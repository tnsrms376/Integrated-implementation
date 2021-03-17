package com.project.plus.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.plus.domain.FaqVO;
import com.project.plus.mapper.FaqMapper;
import com.project.plus.service.FaqService;

@Service("FaqService") //controller 
public class FaqServiceImpl implements FaqService{

	@Autowired
	private FaqMapper mapper;  //service 
	
	
	public void insertFaq(FaqVO vo) {
		mapper.insertFaq(vo);
	}  //service에서 dao.insert~ 로 하는거랑 똑같다고 생각하면됨
	public String selectNow() {
		return mapper.selectNow();
		
	}
}
