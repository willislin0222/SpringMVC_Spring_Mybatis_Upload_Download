package com.learn.service;


import java.util.List;

import com.learn.pojo.LearnVO;


public interface LearnService {

	public void addLearn(LearnVO learnVO);
	public LearnVO findLearnByPk(int no);
	public List<LearnVO> getAll();
}
