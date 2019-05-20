package com.learn.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.dao.Learn_Interface;
import com.learn.pojo.LearnVO;
import com.learn.service.LearnService;


@Service
public class LearnServiceImpl implements LearnService{

	@Autowired
	private Learn_Interface learn_Interface;//UserMapper 是接口

	@Override
	public void addLearn(LearnVO learnVO) {
		learn_Interface.insert(learnVO);
		
	}

	

}
