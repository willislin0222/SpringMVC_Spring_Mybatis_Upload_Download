package com.learn.dao;


import java.util.List;

import com.learn.pojo.LearnVO;


public interface Learn_Interface {

	public int insert(LearnVO learnVO);
	public LearnVO findLearnByPk(int no);
	public List<LearnVO> getAll();
}
