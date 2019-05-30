package com.learn.service;


import java.util.List;

import com.learn.pojo.LearnVO;


public interface LearnService {

	public void addLearn(LearnVO learnVO);
	public List<LearnVO> getAll();
}
